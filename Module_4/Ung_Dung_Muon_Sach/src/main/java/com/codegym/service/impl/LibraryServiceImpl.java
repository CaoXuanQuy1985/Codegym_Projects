package com.codegym.service.impl;

import com.codegym.model.Library;
import com.codegym.repository.LibraryProcessDB;
import com.codegym.service.InterfaceLibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class LibraryServiceImpl implements InterfaceLibraryService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private LibraryProcessDB libraryProcessDB;

    @Override
    public Page<Library> findAll(Pageable pageable) {
        return libraryProcessDB.findAll(pageable);
    }

    @Override
    public Library save(Library library) {
        return libraryProcessDB.save(library);
    }

    @Override
    public Library findById(Long id) {
        return libraryProcessDB.findOne(id);
    }

    @Override
    public Library findAllByNameCategory(String nameCategory) {
        return libraryProcessDB.findAllByNameCategory(nameCategory);
    }

    @Override
    public void remove(Long id) {
        libraryProcessDB.delete(id);
    }
}
