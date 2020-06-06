package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    Iterable<User> findAllByFirstName(String firstName);
    Page<User> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
