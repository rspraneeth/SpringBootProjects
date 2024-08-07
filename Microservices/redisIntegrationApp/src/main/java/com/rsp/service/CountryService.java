package com.rsp.service;

import com.rsp.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private HashOperations<String, Object, Object> opsForHash=null;

//    @Autowired
//    private RedisTemplate<String, Country> redisTemplate;

    public CountryService(RedisTemplate<String, Country> redisTemplate){
        this.opsForHash = redisTemplate.opsForHash();
    }

    public String addCountry(Country country){
        opsForHash.put("COUNTRIES", country.getId(), country);
        return "Country info added";
    }

    public Collection<Country> getAllCountries(){
        Map<Object, Object> entries = opsForHash.entries("COUNTRIES");
        Collection<Country> countries = entries.values().stream().map(v->(Country)v).collect(Collectors.toList());

        return countries;
    }
}
