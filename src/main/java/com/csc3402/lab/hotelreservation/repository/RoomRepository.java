package com.csc3402.lab.hotelreservation.repository;

import com.csc3402.lab.hotelreservation.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository <Room, Integer> {

}
