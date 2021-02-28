package com.dedo.devproj;

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
	private CustomerRepository customerRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		List<Customer> allCustomers = this.customerRepository.findAll();
		log.info("Number of CUSTYS: " + allCustomers.size());

//		Customer customer = new Customer();
//		customer.setCustomer_name("Naruto Uzumaki");
//		customer.setCustomer_cart(600);
//
//		log.info("...saving...");
//		this.customerRepository.save(customer);
//
//		allCustomers = customerRepository.findAll();
//		log.info("Number of CUSTYS NOW: " + allCustomers.size());
	}

	public static void main(String[] args) {
		SpringApplication.run(DevprojApplication.class, args);
	}

}
