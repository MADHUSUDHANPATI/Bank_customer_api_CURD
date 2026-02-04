package com.crud.app.controller;

import com.crud.app.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @GetMapping("/public/customers")
    public String getAllCustomer() {

        return "madhu";
    }

    @PostMapping("/public/customers")
    public Customer createCustomer(@RequestBody Customer customer) {

        return customer;
    }
}
