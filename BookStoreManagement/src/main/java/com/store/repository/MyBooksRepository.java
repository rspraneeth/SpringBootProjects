package com.store.repository;

import com.store.model.MyBooksList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBooksRepository extends JpaRepository<MyBooksList, Integer> {

}
