package com.codegym.service.impl;

import com.codegym.model.Province;
import com.codegym.repository.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class ProvinceServiceImplWithSpringData extends ProvinceService {
    @Autowired
    private ProvinceRepository repository;

    @Override
    protected CrudRepository<Province, Long> repository() {
        return repository;
    }
}
