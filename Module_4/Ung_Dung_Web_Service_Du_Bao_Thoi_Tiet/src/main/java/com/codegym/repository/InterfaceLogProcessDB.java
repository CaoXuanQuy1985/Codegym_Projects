package com.codegym.repository;

import com.codegym.model.LogTable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InterfaceLogProcessDB extends PagingAndSortingRepository<LogTable, Long> {
}
