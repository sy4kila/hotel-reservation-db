package com.csc3402.lab.hotelreservation.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto tu maybe auto increment(?)
    @Column(name = "reservation_no")
    private Integer reservationNum;

    @Column(name = "check_in")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date checkIn;

    @Column(name = "check_out")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date checkOut;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL )
    private Set<Room> rooms;


    @ManyToOne
    @MapsId("guestId")
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Reservation() {
    }

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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Reservation(Integer reservationNum, Date checkIn, Date checkOut, Set<Room> rooms) {
        this.reservationNum = reservationNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationNum=" + reservationNum +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", rooms=" + rooms +
                '}';
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest){
        this.guest = guest;
    }
}

