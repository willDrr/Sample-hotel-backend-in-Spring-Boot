package com.california.hotel.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.california.hotel.domain.Hotel;
import com.california.hotel.domain.HotelRepository;

@RestController
public class HotelController {
	@Autowired
	private HotelRepository hotelRepository;
	
	@RequestMapping("/hotels")
	public Iterable<Hotel> getHotels() {
		return hotelRepository.findAll();
	}
}