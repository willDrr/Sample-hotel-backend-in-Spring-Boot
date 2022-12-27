package com.california.hotel.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface HotelRepository extends CrudRepository<Hotel, Long> {
	Optional<Hotel> findByName(String hotelName);
}