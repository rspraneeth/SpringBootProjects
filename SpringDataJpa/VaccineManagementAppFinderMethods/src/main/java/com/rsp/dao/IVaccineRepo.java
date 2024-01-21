package com.rsp.dao;

import com.rsp.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository //not adding this annotation is also fine, works
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long> {

    //findByProperty
    public List<VaccineDetails> findByCompany(String company);

    public List<VaccineDetails> findByPriceBetween(Integer start, Integer end);

    public List<VaccineDetails> findAllByOrderByPriceAsc();

    public List<VaccineDetails> findByPriceBetweenOrderByPriceAsc(Integer start, Integer end);

    public List<VaccineDetails> findByPriceLessThan(Integer price);

    public List<VaccineDetails> findByNameInAndPriceBetween(Collection<String> list, Integer start, Integer end);



}
