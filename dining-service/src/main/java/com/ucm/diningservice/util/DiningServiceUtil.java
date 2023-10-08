package com.ucm.diningservice.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DiningServiceUtil {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String generateReservationTime(int reservationStartTime, int reservationEndTime, String zone){
        ZoneId timeZone = ZoneId.of(zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).withZone(timeZone);

        LocalTime startTime = LocalTime.of(reservationStartTime, 0);
        LocalTime endTime = LocalTime.of(reservationEndTime, 0);

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), startTime)
                .plusMinutes((long)(Math.random() * ((endTime.toSecondOfDay() - endTime.toSecondOfDay()) / 60)))
                .plusSeconds((long)(Math.random() * 60));

        String reservationTime = dateTime.format(formatter);

        return reservationTime;
    }



    public static String updateReservationTime(String currentTime){
        LocalDateTime dateTime = LocalDateTime.parse(currentTime, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
        LocalDateTime updatedTime = dateTime.plusHours(1);
        return updatedTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    public static int getTableNumber(int maxTable){
        Random random = new Random();
        return random.nextInt(maxTable) + 1;
    }
}
