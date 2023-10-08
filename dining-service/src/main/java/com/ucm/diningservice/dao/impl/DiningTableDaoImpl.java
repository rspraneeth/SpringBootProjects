package com.ucm.diningservice.dao.impl;

import com.ucm.diningservice.dao.DiningTableDao;
import com.ucm.diningservice.model.DiningTableDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiningTableDaoImpl implements DiningTableDao {

    public static Logger logger = LoggerFactory.getLogger(DiningTableDaoImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Integer> getBookedTables() {
        try{
            String query = "SELECT TableNumber FROM diningTables";
            List<Integer> tableNumbers = jdbcTemplate.queryForList(query, Integer.class);
            return tableNumbers;
        }catch (Exception e){
            logger.error("Error occurred while fetching table numbers from DB", e.getStackTrace());
        }
        return null;
    }

    @Override
    public boolean saveTableDetails(DiningTableDetails details) {
        try {
            String query = "INSERT INTO diningTables (PhoneNumber, TableAvailability, TableNumber, ReservationTime) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(query, details.getPhoneNumber(), details.getTableAvailability(), details.getTableNumber(), details.getReservationTime());
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while saving table details. {}", e.getStackTrace());
        }
        return false;
    }

    @Override
    public boolean clearTable(String phoneNumber) {
        try {
            String query = "DELETE FROM diningtables WHERE PhoneNumber = ?";
            //int numRowsDeleted = jdbcTemplate.update(query, phoneNumber);
//            if (numRowsDeleted > 0) {
//                return true;
//            }
            jdbcTemplate.update(query, phoneNumber);
            return true;
        } catch (Exception ex) {
            logger.error("Failed to cancel reservation.", ex.getStackTrace());
        }
        return false;
    }

    @Override
    public boolean updateTableDetailsInDb(DiningTableDetails details) {
        try{
            String sql = "UPDATE diningtables SET TableAvailability = ?, ReservationTime = ? WHERE PhoneNumber = ?";
            jdbcTemplate.update(sql, details.getTableAvailability(), details.getReservationTime(), details.getPhoneNumber());
            return true;
        }catch (Exception e){
            logger.error("Failed to update dinning table details", e.getStackTrace());
        }
        return false;
    }
}
