package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface InterfaceUserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void remove(Long id);

}
