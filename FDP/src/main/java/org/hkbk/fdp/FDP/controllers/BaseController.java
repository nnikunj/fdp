package org.hkbk.fdp.FDP.controllers;

import org.hkbk.fdp.FDP.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BaseController {
	private final Logger logger = LoggerFactory.getLogger(BaseController.class);
	@Autowired
	ResponseBuilder respBuild;

	@RequestMapping(method = RequestMethod.GET, value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getStatus() {
		logger.debug("Status Invoked");
		respBuild.setErrorMessage(null);
		respBuild.setMessage("Up and Running.");
		respBuild.setStatusCode(HttpStatus.OK.value());

		ResponseEntity<String> response = null;
		response = new ResponseEntity<String>(respBuild.getResponseText(), HttpStatus.OK);
		logger.debug("\n" + respBuild.getResponseText() + "\n");
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/greet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> greet() {
		logger.debug("Greet Invoked");
		respBuild.setErrorMessage(null);
		respBuild.setMessage("Hello folks!!!");
		respBuild.setStatusCode(HttpStatus.OK.value());

		ResponseEntity<String> response = null;
		response = new ResponseEntity<String>(respBuild.getResponseText(), HttpStatus.OK);
		logger.debug("\n" + respBuild.getResponseText() + "\n");
		return response;

	}

}
