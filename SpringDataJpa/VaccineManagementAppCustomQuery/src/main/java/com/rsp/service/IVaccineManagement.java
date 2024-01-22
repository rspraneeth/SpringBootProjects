package com.rsp.service;


import com.rsp.bo.VaccineDetails;
import com.rsp.view.View;

import java.util.Date;
import java.util.List;

public interface IVaccineManagement {

    public List<VaccineDetails> fetchDetailsByCompany(String company);

    public List<VaccineDetails> fetchVaccineByCompanies(String c1, String c2);

    public List<String> fetchByPriceRange(Integer min, Integer max);

    public List<Object[]> fetchByName(String name);

    public int updatePriceBasedOnVaccine(Integer newPrice, String name);

    public int deleteVaccineByN(String name);

    public int deleteVaccineByPriceRange(Integer min, Integer max);

    public int insertVaccine(Integer price, String company, String name);

    public Date getTheSystemDateAndTime();

}
