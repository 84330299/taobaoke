package com.igogogo.config;

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
	@Value("${server.api-path}")
	private String pathMapping;

	@Value("${swagger.enable}")
	private Boolean enableSwagger;

	// Swagger 容器初始化配置
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.igogogo.api")).paths(PathSelectors.any()).build()
				.enable(enableSwagger);
	}

	// 文档信息描述
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("5igogogo taobaoke-apis").description("淘宝客测试工具")
				.termsOfServiceUrl("http://www.5igogogo.com").license("5igogogo Licence Version 1.0").licenseUrl("#")
				.version("1.0").build();
	}

}
