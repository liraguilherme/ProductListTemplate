package br.com.guilherme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



//Classe de configuração do SWAGGER/OPEN API


@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				  .info(new Info()
					.title("RestFul API with Java and Spring Boot 3")
					  .version("v1")
					    .description("Some description about your API ")
					      .termsOfService("https://youtube.com") //Link dos termos de serviço
					        .license(new License().name("Apache 2.0")
					        		.url("https://youtube.com"))); //Link da licença 
}
	
}
