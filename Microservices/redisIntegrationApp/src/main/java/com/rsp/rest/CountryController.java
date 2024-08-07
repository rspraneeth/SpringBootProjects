package com.rsp.rest;

import com.rsp.model.Country;
import com.rsp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @PostMapping("/add")
    public String addCountry(@RequestBody Country country) {
        return service.addCountry(country);
    }

    @GetMapping("/countries")
    public Collection<Country> getCountries(){
        return service.getAllCountries();
    }


}
