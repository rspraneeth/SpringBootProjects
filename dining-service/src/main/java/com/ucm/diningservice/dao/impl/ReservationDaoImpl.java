package com.ucm.diningservice.dao.impl;

import com.ucm.diningservice.constants.ReservationStatus;
import com.ucm.diningservice.dao.ReservationDao;
import com.ucm.diningservice.model.DinnerInfo;
import com.ucm.diningservice.model.ReservationDetails;
import com.ucm.diningservice.model.TableReservation;
import com.ucm.diningservice.util.DiningServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    public static Logger logger = LoggerFactory.getLogger(ReservationDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TableReservation tableReservation;

    @Override
    public ReservationDetails saveReservation(DinnerInfo dinnerInfo) {
        if (dinnerInfo != null) {
            ReservationDetails details = createReservationDetails(dinnerInfo);
            boolean reservationStatus = saveReservationDetailsInDb(details);
            if(reservationStatus){
               return details;
            }
        }
        return new ReservationDetails();
    }

    @Override
    public boolean cancelReservation(String phoneNumber) {
        return cancelReservationDetailsInDb(phoneNumber);
    }


    @Override
    public ReservationDetails getReservation(String phoneNumber) {
        String query = "SELECT * FROM reservations WHERE PhoneNumber = :phoneNumber LIMIT 1";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("phoneNumber", phoneNumber);
        return namedParameterJdbcTemplate.queryForObject(query, parameters, this::mapReservationDetails);
    }

    @Override
    public ReservationDetails updateReservation(String phoneNumber) {
        try {
            ReservationDetails reservationDetailsToUpdate = getReservation(phoneNumber);
            if (reservationDetailsToUpdate != null && phoneNumber.equalsIgnoreCase(reservationDetailsToUpdate.getPhoneNumber())) {
                logger.info("Reservation details found. Updating reservation.");
                updateReservationTime(reservationDetailsToUpdate);
                reservationDetailsToUpdate.setReservationStatus(ReservationStatus.RESERVATION_UPDATED.getStatus());
                boolean updateStatus = updateReservationDetailsInDb(reservationDetailsToUpdate);
                if(updateStatus){
                    return reservationDetailsToUpdate;
                }
            }
            logger.info("Reservation details not found. Cannot Update reservation.");
        } catch (Exception ex) {
            logger.error("Error occurred while updating reservation", ex.getStackTrace());
        }
        return null;
    }

    private ReservationDetails updateReservationTime(ReservationDetails reservationDetailsToUpdate) {
        String updatedReservationTime = DiningServiceUtil.updateReservationTime(reservationDetailsToUpdate.getReservationTime());
        reservationDetailsToUpdate.setReservationTime(updatedReservationTime);
        return reservationDetailsToUpdate;
    }

    private boolean updateReservationDetailsInDb(ReservationDetails details) {
        String query = "UPDATE reservations SET PhoneNumber = ?, FirstName = ?, LastName = ?, ReservationTime = ?, ReservationStatus = ?, TableNumber = ? WHERE PhoneNumber = ?";
        jdbcTemplate.update(query, details.getPhoneNumber(),
                details.getCustomerFirstName(),
                details.getCustomerLastName(),
                details.getReservationTime(),
                details.getReservationStatus(),
                details.getTableNumber(),
                details.getPhoneNumber());
        return true;
    }

    private boolean saveReservationDetailsInDb(ReservationDetails details) {
        try {
            String query = "INSERT INTO reservations (PhoneNumber, FirstName, LastName, ReservationTime, ReservationStatus, TableNumber) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(query, details.getPhoneNumber(), details.getCustomerFirstName(), details.getCustomerLastName(), details.getReservationTime(), details.getReservationStatus(), details.getTableNumber());
            return true;
        } catch (Exception e) {
            logger.error("Error occurred while saving reservation details. {}", e.getStackTrace());
        }
        return false;
    }

    private boolean cancelReservationDetailsInDb(String phoneNumber) {
        try {
            String query = "DELETE FROM reservations WHERE PhoneNumber = ?";
//            int numRowsDeleted = jdbcTemplate.update(query, phoneNumber);
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


    private ReservationDetails createReservationDetails(DinnerInfo dinnerInfo) {
        ReservationDetails reservationDetails = new ReservationDetails();

        String reservationTime = DiningServiceUtil.generateReservationTime(tableReservation.getReservationStartTime(), tableReservation.getReservationEndTime(), tableReservation.getTimeZone());
        reservationDetails.setPhoneNumber(dinnerInfo.getPhoneNumber());
        reservationDetails.setCustomerFirstName(dinnerInfo.getFirstName());
        reservationDetails.setCustomerLastName(dinnerInfo.getLastName());
        reservationDetails.setReservationStatus(ReservationStatus.RESERVATION_CONFIRMED.toString());
        reservationDetails.setReservationTime(reservationTime);
        reservationDetails.setTableNumber(dinnerInfo.getTableNumber());
        return reservationDetails;
    }

    private ReservationDetails mapReservationDetails(ResultSet resultSet, int rowNum) throws SQLException {
        ReservationDetails reservationDetails = new ReservationDetails();
        reservationDetails.setPhoneNumber(resultSet.getString("PhoneNumber"));
        reservationDetails.setTableNumber(resultSet.getInt("TableNumber"));
        reservationDetails.setReservationStatus(resultSet.getString("ReservationStatus"));
        reservationDetails.setCustomerFirstName(resultSet.getString("FirstName"));
        reservationDetails.setCustomerLastName(resultSet.getString("LastName"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = resultSet.getTimestamp("ReservationTime").toLocalDateTime().format(formatter);
        reservationDetails.setReservationTime(dateTime);
        return reservationDetails;
    }


}
