package com.codegym.repository;

import com.codegym.model.Library;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LibraryProcessDB extends PagingAndSortingRepository<Library, Long> {
    Library findAllByNameCategory(String nameCategory);
}
