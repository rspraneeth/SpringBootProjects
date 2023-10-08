package com.ucm.diningservice.model;

public class TableReservation {

    private int reservationStartTime;

    private int reservationEndTime;

    private int totalNumOfTable;

    private String timeZone;

    private String tableNumbers;

    public int getReservationStartTime() {
        return reservationStartTime;
    }

    public void setReservationStartTime(int reservationStartTime) {
        this.reservationStartTime = reservationStartTime;
    }

    public int getReservationEndTime() {
        return reservationEndTime;
    }

    public void setReservationEndTime(int reservationEndTime) {
        this.reservationEndTime = reservationEndTime;
    }

    public int getTotalNumOfTable() {
        return totalNumOfTable;
    }

    public void setTotalNumOfTable(int totalNumOfTable) {
        this.totalNumOfTable = totalNumOfTable;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTableNumbers() {
        return tableNumbers;
    }

    public void setTableNumbers(String tableNumbers) {
        this.tableNumbers = tableNumbers;
    }
}
