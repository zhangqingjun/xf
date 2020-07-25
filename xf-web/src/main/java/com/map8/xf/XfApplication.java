package com.map8.xf;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.map8.*")
@MapperScan(annotationClass = Mapper.class,basePackages = "com.map8.xf.dao.*")
@EnableSwagger2
public class XfApplication {

	public static void main(String[] args) {
		SpringApplication.run(XfApplication.class, args);
	}

}
