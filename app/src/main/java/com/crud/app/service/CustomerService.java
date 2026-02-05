package com.crud.app.service;


import com.crud.app.Customer;
import com.crud.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer (Customer customer) {

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById( Long id) {

        return customerRepository.findById(id);
    }


//    public Customer updateCustomer(Long id, Customer customer) {
//
//        customerRepository.findById(id)
//                .orElseThrow(() ->
//                        new RuntimeException("Details are not found with this Id " + id)
//                );
//
//        customer.setId(id);   // 🔥 VERY IMPORTANT
//        return customerRepository.save(customer);
//    }


    public Customer updateCustomer( Long id, Customer customer) {

        return customerRepository.findById(id)
                .map(existing-> {
                    existing.setFirstName(customer.getFirstName());
                    existing.setLastName(customer.getLastName());
                    existing.setEmail(customer.getEmail());
                    existing.setPhoneNumber(customer.getPhoneNumber());

                    return customerRepository.save(existing);
                }).orElseThrow(()-> new RuntimeException(" Details are not found with this Id" + id));
    }

    public void deleteCustomer( Long id) {

        if(!customerRepository.existsById(id)) {
            throw new RuntimeException("Data not found with this id " + id);
        }

        customerRepository.deleteById(id);
    }

}
