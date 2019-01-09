package com.example.Feign.FeignCleint;

import com.example.Feign.FeignCleint.Connector.RestApiProcessor;
import com.example.RESTAPI.ReafactoredRESTAPI.Model.Product;
import com.example.RESTAPI.ReafactoredRESTAPI.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class FeignCleintApplication implements CommandLineRunner {

	@Autowired
	private RestApiProcessor restApiProcessor;
	private Logger log = LoggerFactory.getLogger(FeignCleintApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FeignCleintApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<Product> product = restApiProcessor.getProductById(1);
		log.info("Product value is:" +product.toString());

	}
}

