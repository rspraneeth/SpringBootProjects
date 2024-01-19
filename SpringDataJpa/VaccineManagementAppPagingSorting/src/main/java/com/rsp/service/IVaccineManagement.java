package com.rsp.service;

import com.rsp.bo.VaccineDetails;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IVaccineManagement {

    public Iterable<VaccineDetails> fetchDetails(boolean status, String... properties);

    public List<VaccineDetails> fetchDetailsPage(int pgNo, int pgSize, boolean status, String... properties);

    public void fetchDetailsByPagination(int pgSize);

}
