package com.california.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.california.hotel.domain.HotelRepository;

@SpringBootApplication
public class HotelApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(HotelApplication.class);
	
	@Autowired
	HotelRepository hotelRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
		logger.debug("Application started succesfully");
	}

	@Override
	public void run(String... args) throws Exception {
		var hotels = hotelRepository.findAll();
		hotels.forEach(hotel -> System.out.println(hotel.getName() + ", " + hotel.getLocation())); 
	}
}