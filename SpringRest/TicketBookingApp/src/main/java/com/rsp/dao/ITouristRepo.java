package com.rsp.dao;

import com.rsp.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}
