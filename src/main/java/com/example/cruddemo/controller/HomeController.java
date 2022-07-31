package com.example.cruddemo.controller;

import com.example.cruddemo.entity.Customer;
import com.example.cruddemo.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private HomeRepository homeRepository;

    @GetMapping("/findAll")
    public List<Customer> getAllCustomers() {
        return homeRepository.findAllCustomers();
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer) {
        if (homeRepository.findById(customer.getId()).isPresent()) {
            return "Cannot! Customer with same id exists";
        }
        homeRepository.save(customer);
        return "Saved successfully!";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        Optional<Customer> c1 = homeRepository.findById(id);
        if (c1.isPresent()) {
            int age = customer.getAge();
            String name = customer.getName();
            c1.get().setAge(age);
            c1.get().setName(name);
            homeRepository.save(c1.get());
            return "Updated Successfully!";
        } else {
            homeRepository.save(customer);
            return "Operation Successful!";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
        Optional<Customer> c1 = homeRepository.findById(id);
        if (c1.isPresent()) {
            homeRepository.delete(c1.get());
            return "Operation successful!";
        } else {
            return "No customer with particular id exists!";
        }
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") String id) {
        Optional<Customer> c1 = homeRepository.findById(id);
        return c1.orElse(null);
    }
}
