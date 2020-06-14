package com.codegym.repository.impl;

import com.codegym.model.Smartphone;
import com.codegym.repository.SmartphoneRepository;
import com.codegym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        Smartphone smartphone = smartphoneRepository.findOne(id);
        if (smartphone == null) {
            return null;
        }
        return smartphone;
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return  smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.delete(id);

        return smartphone;
    }
}
