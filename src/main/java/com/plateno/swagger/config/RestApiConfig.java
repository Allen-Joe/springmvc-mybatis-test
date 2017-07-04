package com.plateno.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages={"com.plateno.swagger.controller"})
@Configuration
public class RestApiConfig extends WebMvcConfigurationSupport{
	
	@Bean
	public Docket createRestApi(){
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
						.apiInfo(apiInfo())
						.select()
						.apis(RequestHandlerSelectors.basePackage("com.plateno.swagger.controller"))
						.paths(PathSelectors.any())
						.build();
		
		//生产环境关闭swagger
		if(!AdminConfig.SWAGGER_OPEN){
			docket.enable(false);
		}
		
		return docket;
	}
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
		        .title("springMVC集成swagger的API")
		        .description("版权归Allen所有")
		        .contact("allen")
		        .version("1.0")
		        .build();
	}
	
	

}
