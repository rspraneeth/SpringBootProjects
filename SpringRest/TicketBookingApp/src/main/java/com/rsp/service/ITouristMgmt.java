package com.rsp.service;


import com.rsp.model.Tourist;

import java.util.List;

public interface ITouristMgmt {

    String registerTourist(Tourist tourist);
    Tourist fetchTouristById(Integer id);
    List<Tourist> fetchAllTourists();
    String updateTouristData(Tourist tourist);
    String updateTouristById(Integer id, Double budget);
}
