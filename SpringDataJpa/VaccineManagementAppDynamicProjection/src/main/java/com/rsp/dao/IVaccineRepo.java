package com.rsp.dao;

import com.rsp.bo.VaccineDetails;
import com.rsp.view.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //not adding this annotation is also fine, works
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long> {

    public <T extends View>List<T> findByCompany(String company, Class<T> cls);

}
