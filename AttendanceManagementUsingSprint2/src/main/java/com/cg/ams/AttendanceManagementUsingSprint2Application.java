package com.cg.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 * @author SaiDurga
 */
@SpringBootApplication
public class AttendanceManagementUsingSprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementUsingSprint2Application.class, args);
	}

}
