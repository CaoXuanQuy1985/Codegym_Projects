package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.codegym.respository.*;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRespository customerRespository;

    @Override
    public List<Customer> findAll() {
        return customerRespository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRespository.save(customer);
    }

    @Override
    public Customer findById(Long id) {
        return customerRespository.findById(id);
    }

    @Override
    public void remove(Long id) {
        customerRespository.remove(id);
    }
}
