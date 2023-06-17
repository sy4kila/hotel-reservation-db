package com.csc3402.lab.hotelreservation.controller;

import com.csc3402.lab.hotelreservation.model.Room;
import com.csc3402.lab.hotelreservation.model.Reservation;
import com.csc3402.lab.hotelreservation.repository.GuestRepository;
import com.csc3402.lab.hotelreservation.repository.ReservationRepository;
import com.csc3402.lab.hotelreservation.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
        return "roomList";
    }

    @GetMapping("signup")
    public String showSignUpForm(Room room, Model model) {
        model.addAttribute("rooms", roomRepository.findAll());
        return "guest-info";
    }

    @PostMapping("add")
    public String addReservation(@Valid Room room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "guest-info";
        }
        roomRepository.save(room);
        return "redirect:/rooms/list";
    }
}