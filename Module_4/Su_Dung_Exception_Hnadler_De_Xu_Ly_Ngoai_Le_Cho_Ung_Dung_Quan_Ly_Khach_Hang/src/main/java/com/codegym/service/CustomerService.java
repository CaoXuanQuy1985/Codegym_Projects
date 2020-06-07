package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Iterable<Customer>  findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

    /*Page<Customer> findAll(Pageable pageable) throws Exception;*/

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id) throws Exception;

    //void save(Customer customer);

    void remove(Long id);

    Customer save(Customer customer) throws DuplicateEmailException;
}
