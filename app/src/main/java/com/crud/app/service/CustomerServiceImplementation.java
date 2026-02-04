package com.crud.app.service;

import com.crud.app.Customer;
import com.crud.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getAllCustomerById( Long id) {

        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(" Id not found"));
    }
    public Customer createCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    public String updateCustomer( Customer customer, Long id) {

        Optional<Customer> existingCustomer = customerRepository.findById(id)
                .map((c)-> {

                    customer.setFirstName() = customer.getFirstName();
                });

    }
}
