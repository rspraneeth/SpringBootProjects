package com.ucm.diningservice.service.impl;

import com.ucm.diningservice.dao.impl.ReservationDaoImpl;
import com.ucm.diningservice.model.DinnerInfo;
import com.ucm.diningservice.model.ReservationDetails;
import com.ucm.diningservice.model.TableReservation;
import com.ucm.diningservice.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReservationServiceImpl implements ReservationService {

    public static Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationDaoImpl reservationDao;

    @Autowired
    private DiningTableServiceImpl diningTableService;

    @Autowired
    private TableReservation tableReservation;

    @Override
    public boolean bookReservation(DinnerInfo dinnerInfo) {
        logger.info("Received dinner information. Dinner name={}, phoneNumber={}", dinnerInfo.getFirstName(), dinnerInfo.getPhoneNumber());
        int availableTable = checkAndAllocateAvailableTables();
        ReservationDetails reservationDetails = null;
        if(availableTable != 0){
            dinnerInfo.setTableNumber(availableTable);
            reservationDetails  = reservationDao.saveReservation(dinnerInfo);
        }

        boolean tableReservationStatus = false;
        if (reservationDetails != null && reservationDetails.getReservationStatus() != null) {
            tableReservationStatus = diningTableService.saveTableReservation(reservationDetails);
        }
        if (!tableReservationStatus) {
            reservationDao.cancelReservation(dinnerInfo.getPhoneNumber());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateReservation(String phoneNumber) {
        ReservationDetails reservation = reservationDao.updateReservation(phoneNumber);
        if(reservation != null){
          return diningTableService.updateTableDetails(reservation);
        }
        return false;
    }

    @Override
    public boolean cancelReservation(String phoneNumber) {
    	boolean tableCancellation =  diningTableService.vacateTable(phoneNumber);
    	boolean reservationCancellation =  reservationDao.cancelReservation(phoneNumber);
       
       if(reservationCancellation && tableCancellation){
           return true;
       }
       return false;
    }

    @Override
    public ReservationDetails findReservation(String phoneNumber) {
        return reservationDao.getReservation(phoneNumber);
    }

    private int checkAndAllocateAvailableTables() {
        List<Integer> listOfAllocatedTables = diningTableService.getReservedTablesList();
        if(listOfAllocatedTables != null && listOfAllocatedTables.size() <= tableReservation.getTotalNumOfTable()){
            String tablesNumbersStr = tableReservation.getTableNumbers();
            List<Integer> tableNumbers = Stream.of(tablesNumbersStr.split(",",-1)).map(Integer::valueOf).collect(Collectors.toList());
            return tableNumbers.stream().filter(listOfAllocatedTables::contains).findFirst().get();
        }
        return 0;
    }

}