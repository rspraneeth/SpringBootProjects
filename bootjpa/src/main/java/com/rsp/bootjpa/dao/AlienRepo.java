package com.rsp.bootjpa.dao;

import com.rsp.bootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {

}
