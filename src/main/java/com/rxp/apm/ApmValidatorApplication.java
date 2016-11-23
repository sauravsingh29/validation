package com.rxp.apm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@ImportResource(locations = {"classpath:input-fileds.xml"})
public class ApmValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApmValidatorApplication.class, args);
	}
	
	static void prepareInputToValidate(final InputRequest inputRequest){
		inputRequest.setChargeCodeAm("nks000]");
		inputRequest.setCorrelationId("997876868");
	}
}
