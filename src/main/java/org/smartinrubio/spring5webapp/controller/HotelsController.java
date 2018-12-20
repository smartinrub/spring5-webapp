package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.repository.HotelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels")
public class HotelsController {

    private HotelRepository hotelRepository;

    public HotelsController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping
    public String getHotels(Model model) {
        model.addAttribute(hotelRepository.findHotels());
        return "hotels";
    }

}
