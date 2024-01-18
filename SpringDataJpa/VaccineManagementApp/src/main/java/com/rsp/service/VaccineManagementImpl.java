package com.rsp.service;

import com.rsp.bo.VaccineDetails;
import com.rsp.dao.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepo repo;
    @Override
    public String registerVaccineDetails(VaccineDetails vaccine) {
        repo.save(vaccine);
        System.out.println("Implementing class of repo IVaccineRepo is "+repo.getClass().getName());
        return "Vaccine Details registered with id "+vaccine.getId();
    }

    @Override
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccineList) {

        return repo.saveAll(vaccineList);
    }

    public Long getVaccineCount() {
        return repo.count();
    }

    @Override
    public boolean checkAvailability(Long id) {
        return repo.existsById(id);
    }

    @Override
    public Iterable<VaccineDetails> getAllVaccineInfo() {
        return repo.findAll();
    }

    @Override
    public Iterable<VaccineDetails> getVaccinesById(Iterable<Long> idList) {
        return repo.findAllById(idList);
    }
}
