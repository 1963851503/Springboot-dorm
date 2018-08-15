package com.jsjx.dorm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan({"com.jsjx.dorm.app.dao", "com.jsjx.dorm.web.dao"})
@EnableSwagger2
public class DormApplication {

	public static void main(String[] args) {
		SpringApplication.run(DormApplication.class, args);
	}
}
