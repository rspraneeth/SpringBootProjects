package com.rsp.bootjparest.dao;

import com.rsp.bootjparest.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
