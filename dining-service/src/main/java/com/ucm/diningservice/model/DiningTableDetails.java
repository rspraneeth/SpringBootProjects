package com.ucm.diningservice.model;

import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "diningTables")
public class DiningTableDetails {

    @Id
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "TableAvailability")
    private String tableAvailability;

    @Column(name = "TableNumber")
    private int tableNumber;

    @Column(name = "ReservationTime")
    private String reservationTime;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTableAvailability() {
        return tableAvailability;
    }

    public void setTableAvailability(String tableAvailability) {
        this.tableAvailability = tableAvailability;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
}
