package com.rsp.bootjpa.controller;

import com.rsp.bootjpa.dao.AlienRepo;
import com.rsp.bootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLOutput;

@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }
    @RequestMapping("/addAlien")
    public ModelAndView addAlien(Alien alien){
        ModelAndView mv = new ModelAndView("addAlien.jsp");
        mv.addObject(alien);
        repo.save(alien);
        return mv;
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("showAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());

        System.out.println(repo.findByTech("java"));
        System.out.println(repo.findByAidGreaterThan(104));
        System.out.println(repo.findByTechSorted("java"));

        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/deleteAlien")
    public ModelAndView deleteAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("removeAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        repo.deleteById(aid);
        return mv;
    }

    @RequestMapping("/updateAlien")
    public ModelAndView updateAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("updateAlien.jsp");
        Alien alien = repo.findById(aid).orElse(new Alien());
        mv.addObject(alien);
        return mv;
    }

    @RequestMapping("/saveUpdatedAlien")
    public ModelAndView saveUpdatedAlien(Alien updAlien){
        ModelAndView mv = new ModelAndView("newUpdatedAlien.jsp");
        Alien alien = repo.findById(updAlien.getAid()).orElse(new Alien());
        alien.setAid(updAlien.getAid());
        alien.setAname(updAlien.getAname());
        alien.setTech(updAlien.getTech());
        repo.save(alien);
        mv.addObject(alien);
        return mv;
    }
}
