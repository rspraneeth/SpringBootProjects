package com.rsp.service;

import com.rsp.bo.VaccineDetails;
import com.rsp.dao.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepo repo;


    @Override
    public Iterable<VaccineDetails> fetchDetails(boolean status, String... properties) {
        Sort sort = Sort.by(status ? Sort.Direction.ASC : Sort.Direction.DESC, properties);

        return repo.findAll(sort);
    }

    @Override
    public List<VaccineDetails> fetchDetailsPage(int pgNo, int pgSize, boolean status, String... properties) {
        PageRequest pageable = PageRequest.of(pgNo, pgSize, status ? Sort.Direction.ASC : Sort.Direction.DESC, properties);

        Page<VaccineDetails> page = repo.findAll(pageable);
        return (List<VaccineDetails>) page.getContent();
    }

    @Override
    public void fetchDetailsByPagination(int pgSize) {
        long count = 4L;
        long pages = count/pgSize;

        pages = (count%pgSize==0)?pages:++pages;

        for (int i = 0; i<pages; i++){
            PageRequest pageable =PageRequest.of(i, pgSize);
            Page<VaccineDetails> page = repo.findAll(pageable);
            page.getContent().forEach(System.out::println);
            System.out.println("total pages for the records in db: "+page.getTotalPages());
        }

    }

}
