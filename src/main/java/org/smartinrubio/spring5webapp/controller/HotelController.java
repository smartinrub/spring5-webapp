package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.repository.JdbcHotelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private JdbcHotelRepository jdbcHotelRepository;

    public HotelController(JdbcHotelRepository hotelRepository) {
        this.jdbcHotelRepository = hotelRepository;
    }

    @GetMapping
    public String getHotels(Model model) {
        model.addAttribute(jdbcHotelRepository.findAll());
        return "hotels";
    }

    @GetMapping("/{hotelId}")
    public String getHotelById(@PathVariable("hotelId") long id, Model model) {
        model.addAttribute(jdbcHotelRepository.findById(id));
        return "hotel";
    }

}
