package com.california.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.california.hotel.domain.Room;
import com.california.hotel.domain.RoomRepository;

@RestController
public class RoomController {
	@Autowired
	private RoomRepository roomRepository;
	
	@RequestMapping("/rooms")
	public Iterable<Room> getRooms() {
		return roomRepository.findAll();
	}
}