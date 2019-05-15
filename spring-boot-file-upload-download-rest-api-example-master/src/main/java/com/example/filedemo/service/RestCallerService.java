/**
 * 
 */
package com.example.filedemo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.filedemo.model.JammerRequest;

/**
 * Used for calling the Rest API
 * 
 * @author
 *
 */
@Service
public class RestCallerService {


	public String callPostService(String baseUrl, ArrayList<JammerRequest> request) {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return restTemplate.postForObject(uri, request, String.class);
	}
	
	
	public static void callPostService(/*String baseUrl, IJammerRequest request*/) {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:" + "9100" + "/list";
		URI uri = null;
		try {
			uri = new URI(baseUrl);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ArrayList<JammerRequest> request = new ArrayList<JammerRequest>();
		
		for(int i=0;i<10;i++) {
			JammerRequest jr = new JammerRequest();
			jr.setId("100"+i);
			jr.setText("text "+i);
			jr.setUsername("username "+i);
			request.add(jr);
		}
		
		
		String result = restTemplate.postForObject(uri, request, String.class);
		System.out.println("Result " + result);
	}
	
	
	
	public static void main(String[] args) {
		callPostService();
		/*ObjectMapper mapper = new ObjectMapper();
		ArrayList<JammerRequest> list = new ArrayList<JammerRequest>();
	
	
		
		for(int i=0;i<10;i++) {
			JammerRequest user = new JammerRequest();
			user.setId("100"+i);
			user.setText("text "+i);
			user.setUsername("username "+i);
			list.add(user);
		}

		//Object to JSON in file
		try {
			mapper.writeValue(new File("c:\\upload\\resquest.json"), list);
			
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString(list);
			System.out.println(jsonInString );
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
