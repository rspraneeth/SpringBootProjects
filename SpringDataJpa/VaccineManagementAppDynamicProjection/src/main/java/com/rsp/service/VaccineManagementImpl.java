package com.rsp.service;

import com.rsp.dao.IVaccineRepo;
import com.rsp.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepo repo;

    @Override
    public <T extends View> List<T> fetchByCompany(String company, Class<T> cls) {

        return repo.findByCompany(company, cls);
    }

}
