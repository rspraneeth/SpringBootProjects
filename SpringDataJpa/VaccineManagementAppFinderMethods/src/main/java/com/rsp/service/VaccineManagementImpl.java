package com.rsp.service;

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
    public List<VaccineDetails> searchByCompany(String company) {
        System.out.println("My custom finder method implemented by "+repo.getClass().getName());
        return repo.findByCompany(company);
    }

    @Override
    public List<VaccineDetails> filterByPriceRange(Integer start, Integer end) {
        System.out.println("My custom finder method implemented by "+repo.getClass().getName());
        return repo.findByPriceBetween(start, end);
    }

    @Override
    public List<VaccineDetails> filterByPriceSorted() {
        return repo.findAllByOrderByPriceAsc();
    }

    @Override
    public List<VaccineDetails> filterByPriceRangeSorted(Integer start, Integer end) {
        return repo.findByPriceBetweenOrderByPriceAsc(start, end);
    }

    @Override
    public List<VaccineDetails> searchByPriceBelow(Integer price) {
        return repo.findByPriceLessThan(price);
    }

    @Override
    public List<VaccineDetails> searchByNameInAndPriceBetween(Collection<String> list, Integer start, Integer end) {
        return repo.findByNameInAndPriceBetween(list, start, end);
    }
}
