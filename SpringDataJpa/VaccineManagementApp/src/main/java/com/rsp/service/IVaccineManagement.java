package com.rsp.service;

import com.rsp.bo.VaccineDetails;

public interface IVaccineManagement {
    public String registerVaccineDetails(VaccineDetails vaccine);
    public Iterable<VaccineDetails> registerMultipleVaccineDetails(Iterable<VaccineDetails> vaccineList);
    public Long getVaccineCount();
    public boolean checkAvailability(Long id);

    public Iterable<VaccineDetails> getAllVaccineInfo();

    public Iterable<VaccineDetails> getVaccinesById(Iterable<Long> idList);
}
