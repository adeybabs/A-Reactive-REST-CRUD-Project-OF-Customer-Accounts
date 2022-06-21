package com.project.reactiveSpringSample.controller;

import com.project.reactiveSpringSample.model.Customer;
import com.project.reactiveSpringSample.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //reactive spring uses project reactor as its dependency which provides
    //us with two constructs: mono for 0-1 and flux for 2 and above
    @GetMapping("/customers")
    public Flux<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Mono<Customer> getCustomer(@PathVariable Integer id){
        return customerRepository.findById(id);
    }

    @PostMapping("/save/customer")
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("update/customer/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id ){
        return customerRepository.findById(id)
                .map((c) -> {
                    c.setFirstName(customer.getFirstName());
                    c.setLastName(customer.getLastName());
                    c.setAddress(customer.getAddress());
                    c.setPhoneNumber(customer.getPhoneNumber());
                    c.setEmail(customer.getEmail());
                    c.setCardNumber(customer.getCardNumber());
                    return c;
                }).flatMap(c -> customerRepository.save(c));
    }

    @DeleteMapping("/customer/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id){
        return customerRepository.deleteById(id);
    }
}
