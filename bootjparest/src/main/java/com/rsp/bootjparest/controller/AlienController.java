package com.rsp.bootjparest.controller;

import com.rsp.bootjparest.dao.AlienRepo;
import com.rsp.bootjparest.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @PostMapping(path = "/alien", consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }

    @DeleteMapping(path = "/alien/{aid}")
    public String deleteAlien(@PathVariable int aid){
        repo.delete(repo.getReferenceById(aid));
        return "deleted";
    }

    @GetMapping(path = "/aliens")
    public List<Alien> getAliens(){
        return repo.findAll();
    }

    @PutMapping(path = "/alien", consumes = {"application/json"})
    public Alien saveOrUpdateAlien(@RequestBody Alien alien){
        repo.save(alien);
        return alien;
    }

    @RequestMapping("/alien/{aid}")
    public Optional<Alien> getAlien(@PathVariable("aid") int aid){
        return repo.findById(aid);
    }

}
