package ao.currencyservice.core.springfox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ao.currencyservice.api.controller.CurrencyController;
import ao.currencyservice.api.controller.CurrencyConversionController;
import ao.currencyservice.api.openapi.controller.CurrencyControllerOpenApi;
import ao.currencyservice.api.openapi.controller.CurrencyConversionControllerOpenApi;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan(basePackages = "ao.currencyservice.api.openapi")
public class SpringFoxDocumentationConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("ao.currencyservice.api")).paths(PathSelectors.ant("/v1/**"))
				.build().apiInfo(apiInfo())

				.useDefaultResponseMessages(false)
				.alternateTypeRules(
						AlternateTypeRules.newRule(CurrencyController.class,
								CurrencyControllerOpenApi.class))
				
				
				.alternateTypeRules(AlternateTypeRules.newRule(CurrencyConversionController.class,
						CurrencyConversionControllerOpenApi.class));
//				.alternateTypeRules(
//						 AlternateTypeRules.newRule(
//								 Currency.class, CurrencyOpenApi.class)
//						 )
//	
	}

	public ApiInfo apiInfo() {

		return new ApiInfoBuilder().contact(new Contact("One corp.", "one.corp.com", "Ogouveia86@gmail.com"))
				.description("Open api for money Conversion").title("Money Conversion Api").version("1.0").build();

	}
}