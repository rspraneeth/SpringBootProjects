package com.rsp.service;

import com.rsp.dao.ITouristRepo;
import com.rsp.exception.TouristNotFoundException;
import com.rsp.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristMgmtService implements ITouristMgmt{

    @Autowired
    private ITouristRepo touristRepo;
    @Override
    public String registerTourist(Tourist tourist) {
        int id = touristRepo.save(tourist).getId();
        return "Saved tourist data with id "+id;
    }

    @Override
    public Tourist fetchTouristById(Integer id) {

        return touristRepo.findById(id)
                .orElseThrow(()->new TouristNotFoundException("Couldn't find any tourist with given id"));
    }

    @Override
    public List<Tourist> fetchAllTourists() {
        return touristRepo.findAll();
    }
}
