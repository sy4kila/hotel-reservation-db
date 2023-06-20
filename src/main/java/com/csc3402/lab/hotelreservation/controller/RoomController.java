package com.csc3402.lab.hotelreservation.controller;

import com.csc3402.lab.hotelreservation.model.Guest;
import com.csc3402.lab.hotelreservation.model.Reservation;
import com.csc3402.lab.hotelreservation.model.Room;
import com.csc3402.lab.hotelreservation.repository.GuestRepository;
import com.csc3402.lab.hotelreservation.repository.ReservationRepository;
import com.csc3402.lab.hotelreservation.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GuestRepository guestRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("list")
    public String showMyList(Model model){
        model.addAttribute("rooms", roomRepository.findAll());
        model.addAttribute("guests", guestRepository.findAll());
        model.addAttribute("reservations", reservationRepository.findAll());
        return "roomList";
    }

    @GetMapping("signup")
    public String showSignUpForm(Guest guest, Model model){
        model.addAttribute("reservations",reservationRepository.findAll());
        return "guest-info";
    }

    @PostMapping("addGuest")
    public String addGuest(@Valid Guest guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "guest-info";
        }

        guestRepository.save(guest);
        return "redirect:list";
    }
    @GetMapping("reservation")
    public String showReserveForm(Model model) {
        List<Reservation> reservations = reservationRepository.findAll();
        model.addAttribute("reservations", reservations);
        model.addAttribute("reservation", new Reservation());
        return "add-reservation";
    }

    @PostMapping("addReservation")
    public String addReservation(@Valid Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
            return "add-reservation";
        }

        reservationRepository.save(reservation);
        return "redirect:list";
    }
}
