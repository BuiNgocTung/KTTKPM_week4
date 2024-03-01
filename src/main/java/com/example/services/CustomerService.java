package com.example.services;

import com.example.models.Customer;
import com.example.repositories.CustomerRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class CustomerService {

        private final CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }


        @Cacheable("customers")
        public List<Customer> getAllTasks() {
            return customerRepository.findAll();
        }

        @Cacheable(value = "customers", key = "#id")
        public Optional<Customer> getTaskById(Long id) {
            return customerRepository.findById(id);
        }

        public Customer createTask(Customer task) {
            return customerRepository.save(task);
        }

        @CacheEvict(value = "customers", key = "#id")
        public Customer updateTask(Long id, Customer task) {
            return customerRepository.save(task);
        }

        @CacheEvict(value = "customers", key = "#id")
        public void deleteTaskById(Long id) {
            customerRepository.deleteById(id);
        }

}
