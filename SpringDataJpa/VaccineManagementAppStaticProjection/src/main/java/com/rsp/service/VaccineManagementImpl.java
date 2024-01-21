package com.rsp.service;

import com.rsp.ResultView;
import com.rsp.bo.VaccineDetails;
import com.rsp.dao.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepo repo;


    @Override
    public List<ResultView> searchByPriceLessThan(Integer price) {
        System.out.println(repo.getClass().getName() +" is my implementation class.");
        return repo.findByPriceLessThan(price);
    }
}
