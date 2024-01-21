package com.rsp.service;


import com.rsp.bo.VaccineDetails;

import java.util.Collection;
import java.util.List;

public interface IVaccineManagement {
    public List<VaccineDetails> searchByCompany(String company);

    public List<VaccineDetails> filterByPriceRange(Integer start, Integer end);

    public List<VaccineDetails> filterByPriceSorted();

    public List<VaccineDetails> filterByPriceRangeSorted(Integer start, Integer end);

    public List<VaccineDetails> searchByPriceBelow(Integer price);

    public List<VaccineDetails> searchByNameInAndPriceBetween(Collection<String> list, Integer start, Integer end);
}
