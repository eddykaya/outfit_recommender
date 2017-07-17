package de.bobbin.outfitrecommendation.resources;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configures the swagger API doc
 */
@Configuration
@EnableSwagger2
public class Swagger {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("de.bobbin.outfitrecommendation.resources"))
			.paths(PathSelectors.any())
			.build().useDefaultResponseMessages(false)
			.globalResponseMessage(RequestMethod.GET, Arrays.asList(
				new ResponseMessageBuilder().code(404).message("could not find outfit recommendation").responseModel
					(new ModelRef("Client Error")).build(),
				new ResponseMessageBuilder().code(500).message("Internal Server Error").responseModel
					(new ModelRef("Server Error")).build()
				));
	}

}