package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class HotelRepository {

    private final List<Hotel> hotels = Arrays.asList(
            new Hotel(1L, "Molina Larios", "Malaga Centro", 9F),
            new Hotel(2L, "Barcelo Malaga", "Malaga Centro", 8.7F),
            new Hotel(3L, "AC Hotel Malaga Palacio", "Malaga Centro", 8.5F),
            new Hotel(4L, "NH Malaga", "Malaga Centro", 8.3F),
            new Hotel(5L, "Vincci Malaga", "Playa Misericordia", 8.3F),
            new Hotel(6L, "Picasso Suites Malaga", "Malaga Centro", 8.9F)

    );

    public List<Hotel> findHotels() {
        return hotels;
    }
}
