package com.codegym.service;

import com.codegym.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InterfaceLibraryService {
    Page<Library> findAll(Pageable pageable);

    Library findById(Long id);

    Library findAllByNameCategory(String nameCategory);

    Library save(Library library);

    void remove(Long id);
}
