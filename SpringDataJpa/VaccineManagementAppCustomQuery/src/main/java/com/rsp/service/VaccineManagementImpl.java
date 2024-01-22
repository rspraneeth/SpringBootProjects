package com.rsp.service;

import com.rsp.bo.VaccineDetails;
import com.rsp.dao.IVaccineRepo;
import com.rsp.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepo repo;


    @Override
    public List<VaccineDetails> fetchDetailsByCompany(String company) {
        return repo.searchDetailsByCompany(company);
    }

    @Override
    public List<VaccineDetails> fetchVaccineByCompanies(String c1, String c2) {
        return repo.searchVaccineByCompanies(c1, c2);
    }

    @Override
    public List<String> fetchByPriceRange(Integer min, Integer max) {
        return repo.filterByPriceRange(min, max);
    }

    @Override
    public List<Object[]> fetchByName(String name) {
        return repo.filterByName(name);
    }

    @Override
    public int updatePriceBasedOnVaccine(Integer newPrice, String name) {
        return repo.updatePriceByVaccine(newPrice, name);
    }

    @Override
    public int deleteVaccineByN(String name) {
        return repo.deleteVaccineByN(name);
    }

    @Override
    public int deleteVaccineByPriceRange(Integer min, Integer max) {
        return repo.deleteVaccineByPriceRange(min, max);
    }

    @Override
    public int insertVaccine(Integer price, String company, String name) {
        return repo.insertVaccine(price, company, name);
    }

    @Override
    public Date getTheSystemDateAndTime() {
        return repo.getTheSystemDateAndTime();
    }
}
