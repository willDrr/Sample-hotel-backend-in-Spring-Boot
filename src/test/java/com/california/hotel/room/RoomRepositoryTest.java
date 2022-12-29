package com.california.hotel.room;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.california.hotel.domain.Hotel;
import com.california.hotel.domain.HotelRepository;
import com.california.hotel.domain.Room;
import com.california.hotel.domain.RoomRepository;

@DataJpaTest
public class RoomRepositoryTest {
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Test
	public void canFindAllRooms() {
		hotelRepository.save(new Hotel("Hotelix", "San Jose"));
		 
		roomRepository.save(new Room(333, hotelRepository.findByName("Hotelix").get()));
	
		Optional<Room> optionalRoom = roomRepository.findById((long) 1); 
		
		assertThat(optionalRoom.get()).isNotNull();
	}
}
