package com.ucm.diningservice.constants;

public enum ReservationStatus {

    RESERVATION_CONFIRMED("Confirmed"),
    RESERVATION_UPDATED("Updated");

    private String status;

    ReservationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
