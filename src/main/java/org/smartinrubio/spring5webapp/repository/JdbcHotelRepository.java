package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.exception.HotelNotFoundException;
import org.smartinrubio.spring5webapp.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class JdbcHotelRepository implements HotelRepository {

    private final List<Hotel> hotels = Arrays.asList(
            new Hotel(1L, "Molina Larios", "Malaga Centro", 9F),
            new Hotel(2L, "Barcelo Malaga", "Malaga Centro", 8.7F),
            new Hotel(3L, "AC Hotel Malaga Palacio", "Malaga Centro", 8.5F),
            new Hotel(4L, "NH Malaga", "Malaga Centro", 8.3F),
            new Hotel(5L, "Vincci Malaga", "Playa Misericordia", 8.3F),
            new Hotel(6L, "Picasso Suites Malaga", "Malaga Centro", 8.9F)

    );

    private static final String SELECT_ALL_HOTELS_SQL = "SELECT * FROM hotels";

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcHotelRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public List<Hotel> findAll() {
        return jdbcOperations.query(SELECT_ALL_HOTELS_SQL, new HotelRowMapper());
    }

    @Override
    public Hotel findById(long id) {
        return hotels.stream()
                .filter(hotel -> hotel.getId() == id)
                .findFirst()
                .orElseThrow(HotelNotFoundException::new);
    }

    public class HotelRowMapper implements RowMapper<Hotel> {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Hotel(rs.getLong("id"), rs.getString("name"), rs.getString("address"), rs.getFloat("rating"));
        }
    }
}
