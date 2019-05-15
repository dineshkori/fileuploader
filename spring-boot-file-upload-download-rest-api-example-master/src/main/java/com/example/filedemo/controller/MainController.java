package com.example.filedemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.filedemo.model.RestWrapper;
import com.example.filedemo.service.CSVService;
import com.example.filedemo.service.FileStorageService;

@RestController
public class MainController {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private FileStorageService fileStorageService;
	
	@Autowired
	private CSVService csvService;

	/*@GetMapping("/get")
	public RestWrapper get() {
		logger.info("Incoming Request ");
		RestWrapper response = new RestWrapper();
		ArrayList<ReportRow> rows = new ArrayList<ReportRow>();
		for (int i = 0; i < 10; i++) {
			ReportRow r1 = new ReportRow();
			r1.setPercentage(i*10+"");
			r1.setResult("Result Feild "+i);
			r1.setText("Text feild "+ i);
			rows.add(r1);
		}
		response.setRows(rows);
		return response;
	}

	@PostMapping("/uploadFile")
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		logger.info("Incoming Request for File upload "+fileName);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}*/

	@PostMapping("/processfile")
	public RestWrapper processfile(@RequestParam("file") MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		return csvService.processCSVfile(fileName);
	}

	/*@PostMapping("/uploadMultipleFiles")
	public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}*/

}
