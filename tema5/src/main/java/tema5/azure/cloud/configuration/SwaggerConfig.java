package tema5.azure.cloud.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new 
				Docket(DocumentationType.SWAGGER_2)  
		          .select()                                  
		          .apis(RequestHandlerSelectors.any())              
		          .paths(PathSelectors.any())                          
		          .build()
		          .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
			      "RESTful API - Cloud Tema 5", 
			      "RESTful API - Cloud Tema 5", 
			      "API TOS", 
			      "Terms of service", 
			      new Contact("Ilie-Andrei Daneliuc & Darius Simionescu", "", "daneliucilieandrei@gmail.com; simionescudarius23@gmail.com;"), 
			      "License of API", "API license URL", Collections.emptyList());
	}
}
