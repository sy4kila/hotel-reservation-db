package com.csc3402.lab.hotelreservation.controller;

import com.csc3402.lab.hotelreservation.model.Reservation;
import com.csc3402.lab.hotelreservation.repository.ReservationRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reservations") //ini yg dkt index ada link /reservations/...
public class ReservationController {
    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("list")
    public String showRoomList(Model model){
        model.addAttribute("reservations", reservationRepository.findAll()); //find all ni dia display semua kot
        return "room-list"; //yg ni html dia x silap
    }

    //yg ni nnt dulu x faham lagi
    @GetMapping("reserve")
    public String showSignUpForm(Reservation reservation){
        return "add-reservation";
    }

    //  @PostMapping("add")
    //public String addReservation(@Valid Reservation reservation, BindingResult result, Model model) {
    //  if (result.hasErrors()) {
    //    return "add-reservation";
    //}

//        ReservationRepository.save(reservation);
    //       return "redirect:list"; //lepas dah submit tu dia akan terus ke list page(?)
    //}






}
