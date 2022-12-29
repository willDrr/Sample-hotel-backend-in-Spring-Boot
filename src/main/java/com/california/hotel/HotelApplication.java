package com.california.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.california.hotel.domain.HotelRepository;
import com.california.hotel.domain.Room;
import com.california.hotel.domain.RoomRepository;

@SpringBootApplication
public class HotelApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(HotelApplication.class);
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
		logger.debug("Application started succesfully");
	}

	@Override
	public void run(String... args) throws Exception {
		var hotel = hotelRepository.findByName("Hotelix");
		System.out.println(hotel.get().getName());
		
		System.out.println("Room in house: ");
		var rooms = roomRepository.findAll();
		for(Room room: rooms) {
			if(room.getHotel().getName().equals("Hotelix")) {
				System.out.println("Number # " + room.getNumber());
			}
		}
	}
}