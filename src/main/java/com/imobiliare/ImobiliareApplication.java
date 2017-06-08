package com.imobiliare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ServletComponentScan(value="com.imobiliare.security")
public class ImobiliareApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ImobiliareApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ImobiliareApplication.class);
	}

}
