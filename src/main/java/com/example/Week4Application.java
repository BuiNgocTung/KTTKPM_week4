package com.example;

import com.example.models.Customer;
import com.example.repositories.CustomerRepository;
import net.datafaker.Faker;
import net.datafaker.providers.base.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@SpringBootApplication
public class Week4Application {
	@Autowired
	private CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(Week4Application.class, args);
	}
//	@Bean

	CommandLineRunner createDataProduct() {
		return args -> {
			Faker faker = new Faker();

			for (int i = 0; i < 5; i++) {
				Customer customer = new Customer();
				customer.setName(faker.name().fullName());
				customer.setEmail(faker.internet().emailAddress());
				customer.setAddress(faker.address().fullAddress());
				customer.setPhone(faker.phoneNumber().phoneNumber());

				customerRepository.save(customer);

			}


		};
	}

}
