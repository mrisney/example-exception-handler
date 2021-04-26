package com.thrivent.payments.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String TITLE = "Payment Example Exception Codes";
	private static final String DESCRIPTION = "Example Thrivent Pyament exception handler";
	private static final String VERSION = "1.0";
	private static final String TERMS_OF_SERVICS = "Terms of service";
	private final String CONTACT = "marc.risney@gmail.com";
	private static final String LICENSE = "GNU General Public License";
	private static final String LICENSE_URL = "https://opensource.org/licenses/gpl-license";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.thrivent.payments.example"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(TITLE, DESCRIPTION, VERSION, TERMS_OF_SERVICS, CONTACT, LICENSE, LICENSE_URL);
	}
}
