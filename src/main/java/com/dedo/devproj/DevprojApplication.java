package com.dedo.devproj;

import com.dedo.devproj.business.service.CustomerService;
import com.dedo.devproj.data.entity.Customer;
import com.dedo.devproj.data.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication

@Slf4j
public class DevprojApplication {

	@Autowired
	private CustomerService service;


	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		service.createCustomer("Naruto Uzumaki");
		service.createCustomer("Sasuke Uciha");
		service.createCustomer("Madara Uchiha");

		service.addProduct("FUNKO - Hinata", 5.99);
		service.addProduct("FUNKO - Jiraya", 150.00);
		service.addProduct("FUNKO - TSUNADE", 8.34);

		log.info("Added 3 customers/products");

	}

	public static void main(String[] args) {
		SpringApplication.run(DevprojApplication.class, args);
	}

}
