package com.rsp.service;

import com.rsp.bo.VaccineDetails;

import java.util.List;
import java.util.Optional;

public interface IVaccineManagement {
    public String registerVaccineDetails(VaccineDetails vaccine);
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccineList);
    public Long getVaccineCount();
    public boolean checkAvailability(Long id);

    public Iterable<VaccineDetails> getAllVaccineInfo();

    public Iterable<VaccineDetails> getVaccinesById(Iterable<Long> idList);

    public Optional<VaccineDetails> getVaccineById(Long id);

    public String removeVaccineById(Long id);
    public String removeVaccinesByIds(List<Long> ids);

    public String removeVaccineByObject(VaccineDetails vaccine);
}
