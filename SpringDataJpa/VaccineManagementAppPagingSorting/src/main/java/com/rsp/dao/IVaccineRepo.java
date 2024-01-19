package com.rsp.dao;

import com.rsp.bo.VaccineDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository //not adding this annotation is also fine, works
public interface IVaccineRepo extends PagingAndSortingRepository<VaccineDetails, Long> {

}
