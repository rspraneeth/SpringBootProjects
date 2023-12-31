package com.rsp.bootjpa.dao;

import com.rsp.bootjpa.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
    List<Alien> findByTech(String tech);

    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where tech = ?1 order by aname")
    List<Alien> findByTechSorted(String tech);
}
