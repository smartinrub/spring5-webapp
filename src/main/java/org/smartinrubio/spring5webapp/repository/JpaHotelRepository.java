package org.smartinrubio.spring5webapp.repository;

import org.smartinrubio.spring5webapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaHotelRepository extends JpaRepository<Hotel, Long> {
}
