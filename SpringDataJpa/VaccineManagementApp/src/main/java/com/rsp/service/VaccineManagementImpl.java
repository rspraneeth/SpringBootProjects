package com.rsp.service;

import com.rsp.bo.VaccineDetails;
import com.rsp.dao.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<VaccineDetails> getVaccineById(Long id) {
        return repo.findById(id);
    }

    @Override
    public String removeVaccineById(Long id) {
        Optional<VaccineDetails> optional = repo.findById(id);
        if (optional.isPresent()){
            repo.deleteById(id);
            return "record deleted "+optional;
        }
        return "no record exists with given id "+id;
    }

    @Override
    public String removeVaccinesByIds(List<Long> ids) {
        Iterable<VaccineDetails> list = repo.findAllById(ids);
        int count = ids.size();
        if (count==((List<VaccineDetails>)list).size()){
            repo.deleteAllById(ids);
            return "Deleted "+count+" records";
        }

        return "Not all ids are present to be deleted.";
    }

    @Override
    public String removeVaccineByObject(VaccineDetails vaccine) {
        Optional<VaccineDetails> info = repo.findById(vaccine.getId());
        if (info.isPresent()){
            repo.delete(vaccine);
            return "Vaccine object record deleted";
        }

        return "Vaccine object not found to delete.";
    }
}
