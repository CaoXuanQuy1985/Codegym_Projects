package com.codegym.service.impl;

import com.codegym.model.User;
import com.codegym.repository.InterfaceUserProcessDB;
import com.codegym.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements InterfaceUserService {

    @Autowired
    private InterfaceUserProcessDB interfaceUserProcessDB;

    @Override
    public List<User> findAll() {
        return interfaceUserProcessDB.findAll();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(Long id) {

    }
}
