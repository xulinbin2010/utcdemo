package com.ntt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ntt.mapper")
public class UtcDemoApplicationStart {

	public static void main(String[] args) {
		SpringApplication.run(UtcDemoApplicationStart.class, args);
        System.out.println("---------------------------System start successfully!!!-------------------------");
	}


}

