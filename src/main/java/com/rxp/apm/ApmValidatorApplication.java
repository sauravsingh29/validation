package com.rxp.apm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
@ImportResource(locations = {"classpath:apm-config.xml"})
public class ApmValidatorApplication extends SpringBootServletInitializer {
	
	

	/* (non-Javadoc)
	 * @see org.springframework.boot.context.web.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ApmValidatorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApmValidatorApplication.class, args);
	}
	
	static void prepareInputToValidate(final InputRequest inputRequest){
		inputRequest.setChargeCodeAm("nks000]");
		inputRequest.setCorrelationId("997876868");
	}
}
