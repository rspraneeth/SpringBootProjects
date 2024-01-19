package com.rsp.service;


import com.rsp.bo.VaccineDetails;

import java.util.List;

public interface IVaccineManagement {

    public List<VaccineDetails> searchVaccineByData(VaccineDetails vaccine, boolean status, String... args);

    public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine);

    public VaccineDetails searchById(Long id);

    public String removeVaccineByIds(Iterable<Long> ids);
}
