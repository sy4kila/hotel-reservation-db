package com.csc3402.lab.hotelreservation.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    //attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto tu maybe auto increment(?)
    @Column(name = "reservation_no")
    private Integer reservationNum;

    @Column(name = "check_in")
    private Date checkIn;

    @Column(name = "check_out")
    private Date checkOut;

    //get set method -----------------------------------------
    public Integer getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(Integer reservationNum) {
        this.reservationNum = reservationNum;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    //no arg constructor (with arg x de lg)------------------------------------
    public Reservation() {
    }

    //toString method----------------------------------------

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationNum=" + reservationNum +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                '}';
    }
}
