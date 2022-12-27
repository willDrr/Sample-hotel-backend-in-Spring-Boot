package com.california.hotel.hotel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.california.hotel.domain.Hotel;
import com.california.hotel.domain.HotelRepository;

@DataJpaTest
public class HotelRepositoryTest {
	@Autowired
	HotelRepository hotelRepository;
	
	@Test
	public void testHotelInsertion() {
		hotelRepository.save(new Hotel("Markos", "Italia"));
		assertThat(hotelRepository.findByName("Markos")).isNotNull();
	}
}
