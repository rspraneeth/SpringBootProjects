package com.rsp.dao;

import com.rsp.ResultView;
import com.rsp.bo.VaccineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository //not adding this annotation is also fine, works
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long> {

    public List<ResultView> findByPriceLessThan(Integer price);


}
