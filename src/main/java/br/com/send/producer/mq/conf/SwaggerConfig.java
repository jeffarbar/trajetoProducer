package br.com.send.producer.mq.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.basepackage}") 
	private String basePackage;
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage(basePackage))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(metaData());
    }
	
	private ApiInfo metaData() {
	    return new ApiInfoBuilder()
	        .title("API dispositivo")
	        .description("\"Sistema para receber os dados dos dispositivos\"")
	        .version("1.0.0")
	        .license("Apache License Version 2.0")
	        .build();
	  }

}
