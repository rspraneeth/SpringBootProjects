package com.ucm.diningservice.dao;

import com.ucm.diningservice.model.DiningTableDetails;

import java.util.List;

public interface DiningTableDao {

    List<Integer> getBookedTables();

    boolean saveTableDetails(DiningTableDetails  details);

    boolean clearTable(String phoneNumber);

    boolean updateTableDetailsInDb(DiningTableDetails details);
}
