package com.decathlon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@MapperScan("com.decathlon")
@SpringBootApplication(scanBasePackages = "com.decathlon")
@EnableSwagger2
public class TemplateMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateMessageApplication.class, args);
	}

}
