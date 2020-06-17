package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Bean
    public CustomerService customerService() {
        return new SimpleCustomerServiceImpl();
    }

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView updateCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasGlobalErrors() || bindingResult.hasFieldErrors()) {
            return new ModelAndView("customers/info");
        }
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }
}
