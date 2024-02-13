package com.rsp.service;

import com.rsp.dao.ITouristRepo;
import com.rsp.exception.TouristNotFoundException;
import com.rsp.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .orElseThrow(()->new TouristNotFoundException("Couldn't find any tourist with given id "+id));
    }

    @Override
    public List<Tourist> fetchAllTourists() {
        return touristRepo.findAll();
    }

    @Override
    public String updateTouristData(Tourist tourist) {
        Optional<Tourist> optional = touristRepo.findById(tourist.getId());
        if (optional.isPresent()){
            touristRepo.save(tourist);
            return "Tourist with id "+tourist.getId()+" updated.";
        }else
            throw new TouristNotFoundException("Tourist with id "+tourist.getId()+" not found.");
    }

    @Override
    public String updateTouristById(Integer id, Double budget) {
        Optional<Tourist> tourist = touristRepo.findById(id);

        if (tourist.isPresent()){
            Tourist tourist1 = tourist.get();
            tourist1.setBudget(budget);
            touristRepo.save(tourist1);
            return "Tourist with id "+tourist1.getId()+" updated.";
        }else
            throw new TouristNotFoundException("Tourist with id "+id+" is not present to update.");
    }

    @Override
    public String deleteById(Integer id) {
        try{
            touristRepo.deleteById(id);
            return "Deleted tourist with id "+id;
        } catch (TouristNotFoundException e){
            throw new TouristNotFoundException("Tourist with id "+id+" is not present to delete.");
        }

    }
}
