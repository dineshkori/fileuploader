package com.example.filedemo.service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.filedemo.exception.FileStorageException;
import com.example.filedemo.model.JammerRequest;
import com.example.filedemo.model.ReportRow;
import com.example.filedemo.model.RestWrapper;
import com.example.filedemo.model.response.Classifier;
import com.example.filedemo.model.response.JammerResponse;
import com.example.filedemo.property.FileStorageProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.bytecode.opencsv.CSVReader;

@Service
public class CSVService {

	public static final Logger logger = LoggerFactory.getLogger(CSVService.class);

	private final Path fileStorageLocation;

	@Autowired
	private RestCallerService jammercaller;

	@Autowired
	private Environment env;

	@Autowired
	public CSVService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	/**
	 * This Method will process the request for inpul filename and hit the Jammer
	 * API and process it and sent Output to Rest Layer for calling client
	 * application.
	 * 
	 * @param fileName
	 * @return
	 */
	public RestWrapper processCSVfile(String fileName) {
		// TODO Auto-generated method stub
		logger.info("Processing file " + fileName);
		ArrayList<JammerRequest> request = new ArrayList<JammerRequest>();
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(this.fileStorageLocation.resolve(fileName).normalize().toString()),
					'|', '"', 1);
			String[] nextLine;
			int i = 0;
			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {
					/*
					 * Create Jammer Requests
					 */
					JammerRequest jr = new JammerRequest();
					String text = nextLine[0] + " " + nextLine[1];
					jr.setId("100" + i);
					jr.setText("text " + text);
					jr.setUsername("username " + i);
					request.add(jr);
					i++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IO Exception While Reading file");
			e.printStackTrace();
		}

		/*
		 * Read from Application.properties Jammer Api URL
		 */
		final String baseUrl = env.getProperty("hosturl");

		/*
		 * call Jammer Rest API Services
		 */
		String jammerResponse = jammercaller.callPostService(baseUrl, request);
		logger.info(jammerResponse);
		JammerResponse rep = null;
		RestWrapper response = new RestWrapper();
		ObjectMapper mapper = new ObjectMapper();
		try {
			rep = mapper.readValue(jammerResponse, JammerResponse.class);
		} catch (Exception e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setErrorCode("Sucess");
		ReportRow reportRow = new ReportRow();
		ArrayList<ReportRow> rows = new ArrayList<ReportRow>();

		/**
		 * Take each Classifier and populate in response
		 */
		for (Classifier classifier : rep.getClassifier()) {
			reportRow.setPercentage(classifier.getPrediction());
			reportRow.setResult(classifier.getConclusion());
			reportRow.setText(classifier.getType());
			rows.add(reportRow);
		}
		response.setRows(rows);
		return response;
	}

}
