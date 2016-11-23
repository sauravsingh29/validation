package com.rxp.apm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rxp.apm.validator.RequestValidator;
import com.rxp.apm.validator.ValidatorOutput;

@RestController
public class Controller {

	@Autowired
	RequestValidator<InputRequest> validateRequest;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public String sayHello() throws Exception {
		final InputRequest inputRequest = new InputRequest();
		prepareInputToValidate(inputRequest);
		ValidatorOutput output = validateRequest.validateRequest(inputRequest);
		System.out.println("Validaton output --> " + output);
		return "Success";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> postHello(@RequestBody Hello hello ) throws Exception {
		System.out.println("Request output --> " + hello.toString());
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	void prepareInputToValidate(final InputRequest inputRequest) {
		inputRequest.setChargeCodeAm("nks000]");
		inputRequest.setCorrelationId("997876868");
	}
}
