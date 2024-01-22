package com.rsp.dao;

import com.rsp.bo.VaccineDetails;
import com.rsp.view.View;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository //not adding this annotation is also fine, works
public interface IVaccineRepo extends JpaRepository<VaccineDetails, Long> {

    @Query("FROM VaccineDetails WHERE company = :company")
    public List<VaccineDetails> searchDetailsByCompany(String company);
// Both serve same purpose
//    @Query("FROM VaccineDetails WHERE company = :company")
//    public List<VaccineDetails> searchVaccineDetailsByCompany(@Param("company") String companyName);

    @Query("FROM VaccineDetails WHERE company IN(:c1, :c2)")
    public List<VaccineDetails> searchVaccineByCompanies(String c1, String c2);

    @Query("SELECT name, company from VaccineDetails where price between :min and :max")
    public List<String> filterByPriceRange(Integer min, Integer max);

    @Query("SELECT id, price, company from VaccineDetails where name in(:name)")
    public List<Object[]> filterByName(String name);


//    Have to use two extra annotations for non-select queries.
    @Transactional
    @Modifying
    @Query("UPDATE VaccineDetails set price=:newPrice where name=:name")
    public int updatePriceByVaccine(Integer newPrice, String name);


    @Transactional
    @Modifying
    @Query("DELETE VaccineDetails  where name=:name")
    public int deleteVaccineByN(String name);

    @Transactional
    @Modifying
    @Query("DELETE VaccineDetails  where price between :min and :max")
    public int deleteVaccineByPriceRange(Integer min, Integer max);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO vaccine_info(price, company, name) values(?,?,?)", nativeQuery = true)
    public int insertVaccine(Integer price, String company, String name);


    @Query(value = "SELECT NOW() FROM DUAL", nativeQuery = true)
    public Date getTheSystemDateAndTime();


}
