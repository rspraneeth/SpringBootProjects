package com.ucm.diningservice.controller;

import com.ucm.diningservice.model.DinnerInfo;
import com.ucm.diningservice.model.ReservationDetails;
import com.ucm.diningservice.service.impl.ReservationServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/reservation")
public class DinnerReservationController {

    public static Logger logger = LoggerFactory.getLogger(DinnerReservationController.class);

    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/reserve")
    public ResponseEntity<String> bookReservation(DinnerInfo dinnerInfo) {
        if (dinnerInfo != null) {
            boolean dinnerStatus = reservationService.bookReservation(dinnerInfo);
            if (dinnerStatus) {
                logger.info("Table reservation successful");
                return new ResponseEntity<>("Reservation Confirmed for customer "+dinnerInfo.getFirstName() + " "+dinnerInfo.getLastName(), HttpStatus.OK);
            }
            logger.info("Table reservation unsuccessful");
            return new ResponseEntity<>("Reservation UnSuccessful for customer "+dinnerInfo.getFirstName() + " "+dinnerInfo.getLastName(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.error("Dinner Information is incomplete. Table reservation unsuccessful");
        return new ResponseEntity<>("Reservation UnSuccessful for customer "+dinnerInfo.getFirstName() + " "+dinnerInfo.getLastName(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateReservation(String phoneNumber) {
        if (StringUtils.isNotEmpty(phoneNumber) && StringUtils.isNotBlank(phoneNumber)) {
            boolean status = reservationService.updateReservation(phoneNumber);
            if (status) {
                return new ResponseEntity<>("Reservation updated successfully for customer with phone number "+phoneNumber, HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>("Reservation updated unsuccessful for customer with phone number "+phoneNumber, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.error("Received invalid or empty phone number. Cannot update reservation. Phone number received={}", phoneNumber);
        return new ResponseEntity<>("Reservation not found on given phone number ="+phoneNumber, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelReservation(String phoneNumber) {
        if (StringUtils.isNotEmpty(phoneNumber) && StringUtils.isNotBlank(phoneNumber)) {
            boolean status = reservationService.cancelReservation(phoneNumber);
            if (status) {
                return new ResponseEntity<>("Reservation cancelled successfully for phone number "+phoneNumber, HttpStatus.OK);
            }
            return new ResponseEntity<>("Failed to cancel reservation for phone number "+phoneNumber, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.error("Received invalid or empty phone number. Cannot update reservation. Phone number received={}", phoneNumber);
        return new ResponseEntity<>("Received invalid or empty phone number "+phoneNumber, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/retrieve")
    public ResponseEntity<String> retrieveReservation(String phoneNumber) {
        if (StringUtils.isNotEmpty(phoneNumber) && StringUtils.isNotBlank(phoneNumber)) {
            ReservationDetails details = reservationService.findReservation(phoneNumber);
            if(details != null){
                logger.info("Reservation details fetched successfully");
                String msg = "Reservation details for given phone number " +phoneNumber + "\n"+ "FirstName "+details.getCustomerFirstName() + "\n" +details.getCustomerLastName() + "\n" +"reservationTime" + details.getReservationTime();
                return new ResponseEntity<>(msg, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Reservation details not found", HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<>("Received invalid or empty phone number "+phoneNumber, HttpStatus.BAD_REQUEST);
    }


        @GetMapping("/form")
    public ModelAndView showReservationForm(Model model) {
        ModelAndView mav = new ModelAndView("DiningReservations.html");
        return mav;
    }

    @GetMapping("/reservation-form")
    public ModelAndView loadReservationForm(Model model) {
        ModelAndView bookingForm = new ModelAndView("BookReservation.html");
        return bookingForm;
    }

    @GetMapping("/update-reservation-form")
    public ModelAndView loadReservationUpdateForm(Model model) {
        ModelAndView bookingForm = new ModelAndView("UpdateReservation.html");
        return bookingForm;
    }

    @GetMapping("/cancel-reservation-form")
    public ModelAndView loadCancellationForm(Model model) {
        ModelAndView bookingForm = new ModelAndView("CancelReservation.html");
        return bookingForm;
    }

    @GetMapping("/retrieve-reservation-form")
    public ModelAndView retrieveCancellationForm(Model model) {
        ModelAndView retrieve = new ModelAndView("RetrieveReservation.html");
        return retrieve;
    }
}
