package com.rsp.service;


import com.rsp.ResultView;
import com.rsp.bo.VaccineDetails;

import java.util.Collection;
import java.util.List;

public interface IVaccineManagement {
    public List<ResultView> searchByPriceLessThan(Integer price);
}
