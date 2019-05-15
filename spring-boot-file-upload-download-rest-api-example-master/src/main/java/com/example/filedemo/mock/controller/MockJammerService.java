package com.example.filedemo.mock.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.filedemo.model.JammerRequest;
import com.example.filedemo.model.response.Classifier;
import com.example.filedemo.model.response.JammerResponse;

@RestController
public class MockJammerService {
	private static final Logger logger = LoggerFactory.getLogger(MockJammerService.class);

	@PostMapping("/list")
	public JammerResponse jammerApi(@RequestBody ArrayList<JammerRequest> request) {
		JammerResponse response = new JammerResponse();

		ArrayList<Classifier> classifiers = new ArrayList<Classifier>();
		Classifier classifier1 = new Classifier();
		classifier1.setConclusion("ICSR No");
		classifier1.setPrediction("86.5");
		classifier1.setType("ICSR");
		classifiers.add(classifier1);

		Classifier classifier2 = new Classifier();
		classifier2.setConclusion("Rcsi No");
		classifier2.setPrediction("56.5");
		classifier2.setType("Rcsi");
		classifiers.add(classifier2);

		response.setClassifier(classifiers);
		logger.info("Incoming Request to mock Service: " + request);
		logger.info("Sending Mock response: " + response);
		return response;
	}

}
