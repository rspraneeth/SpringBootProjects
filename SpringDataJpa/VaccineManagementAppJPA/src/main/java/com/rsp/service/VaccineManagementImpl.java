package com.rsp.service;

import com.rsp.bo.VaccineDetails;
import com.rsp.dao.IVaccineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VaccineManagementImpl implements IVaccineManagement{

    @Autowired
    private IVaccineRepo repo;


    @Override
    public List<VaccineDetails> searchVaccineByData(VaccineDetails vaccine, boolean status, String... args) {

        Example<VaccineDetails> example = Example.of(vaccine);
        Sort sort = Sort.by(status ? Direction.ASC : Direction.DESC, args);


        return repo.findAll(example, sort);
    }

    @Override
    public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine) {
        Example<VaccineDetails> example = Example.of(vaccine);
        return repo.findAll(example);
    }

    @Override
    public VaccineDetails searchById(Long id) {
        return repo.getById(id);
    }

    @Override
    public String removeVaccineByIds(Iterable<Long> ids) {
        List<VaccineDetails> list = repo.findAllById(ids);
        if (list.size() != 0){
            repo.deleteAllByIdInBatch(ids);
            return "Records Deleted";
        }
        repo.deleteAllById(ids);
        return "Unable to delete record/Record not found";
    }


}
