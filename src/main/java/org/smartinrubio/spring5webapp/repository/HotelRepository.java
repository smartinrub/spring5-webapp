package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.model.Hotel;

import java.util.List;

public interface HotelRepository {
    List<Hotel> findAll();
    Hotel findById(long id);
}
