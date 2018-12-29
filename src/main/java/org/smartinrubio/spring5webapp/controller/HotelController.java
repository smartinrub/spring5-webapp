package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.exception.HotelNotFoundException;
import org.smartinrubio.spring5webapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    private JpaRepository jpaRepository;

    public HotelController(JpaRepository hotelRepository) {
        this.jpaRepository = hotelRepository;
    }

    @GetMapping
    public String getHotels(Model model) {
        model.addAttribute(jpaRepository.findAll());
        return "hotels";
    }

    @GetMapping("/{hotelId}")
    public String getHotelById(@PathVariable("hotelId") long id, Model model) throws Throwable {
        model.addAttribute(jpaRepository.findById(id).orElseThrow(HotelNotFoundException::new));
        return "hotel";
    }

    @GetMapping("/save")
    public String hotelForm() {
        return "hotelForm";
    }

    @PreAuthorize("hasRole('ROLE_USER') and #hotel.rating <= 7 or hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    public String createHotel(@Valid Hotel hotel,
                              Errors errors,
                              RedirectAttributes model) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        Hotel savedHotel = (Hotel) jpaRepository.save(hotel);

        model.addAttribute("hotelId", savedHotel.getId());
        model.addFlashAttribute("hotel", savedHotel);
        return "redirect:/hotels/{hotelId}";
    }

}
