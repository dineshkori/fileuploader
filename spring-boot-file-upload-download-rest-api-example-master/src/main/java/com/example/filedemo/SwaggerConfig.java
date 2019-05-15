package com.example.filedemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com"))
				.paths(PathSelectors.any()).build().apiInfo(metaData());

	}

	@SuppressWarnings("rawtypes")
	private ApiInfo metaData() {
		String title = "Job Manager REST API";
		String description = "This will provide Documentation for project Rest API";
		Contact contactName = new Contact("Author name", "https://linkedin.com/Author", "author.name@gmail.com");
		String license = "FreeWare Version 2.0";
		String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";
		String termsOfServiceUrl = "Terms of service";
		String version = "1.0";
		List<VendorExtension> vr = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, contactName, license, licenseUrl,
				vr);
		return apiInfo;
	}
}