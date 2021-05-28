package com.fact.tax.facttax;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.fact.tax.facttax.properties.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})

public class FacttaxApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(FacttaxApplication.class, args);
	}

}
