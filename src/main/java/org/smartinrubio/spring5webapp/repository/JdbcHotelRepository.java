package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.exception.HotelNotFoundException;
import org.smartinrubio.spring5webapp.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcHotelRepository implements HotelRepository {

    private static final String SELECT_ALL_HOTELS = "SELECT * FROM hotels";
    private static final String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE id = ?";

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcHotelRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    public List<Hotel> findAll() {
        return jdbcOperations.query(SELECT_ALL_HOTELS, new HotelRowMapper());
    }

    @Override
    public Hotel findById(long id) {
        try {
            return jdbcOperations.queryForObject(SELECT_HOTEL_BY_ID, new HotelRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            throw new HotelNotFoundException(e);
        }
    }

    public class HotelRowMapper implements RowMapper<Hotel> {
        @Override
        public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Hotel(rs.getLong("id"), rs.getString("name"), rs.getString("address"), rs.getFloat("rating"));
        }
    }
}
