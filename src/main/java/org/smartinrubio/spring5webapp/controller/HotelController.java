package org.smartinrubio.spring5webapp.controller;

import org.smartinrubio.spring5webapp.exception.HotelNotFoundException;
import org.smartinrubio.spring5webapp.model.Hotel;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
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
import java.util.stream.Collectors;

@Scope("prototype")
@Controller
@RequestMapping("/hotels")
@ManagedResource(objectName = "hotel:name=HotelController")
public class HotelController {

    private static final int DEFAULT_HOTELS_PER_PAGE = 10;

    private int hotelsPerPage = DEFAULT_HOTELS_PER_PAGE;

    @ManagedAttribute
    public int getHotelsPerPage() {
        return hotelsPerPage;
    }

    @ManagedAttribute
    public void setHotelsPerPage(int hotelsPerPage) {
        this.hotelsPerPage = hotelsPerPage;
    }

    private JpaRepository jpaRepository;

    public HotelController(JpaRepository hotelRepository) {
        this.jpaRepository = hotelRepository;
    }

    @GetMapping
    public String getHotels(Model model) {
        System.out.println(hotelsPerPage);
        model.addAttribute(jpaRepository.findAll().stream().limit(getHotelsPerPage()).collect(Collectors.toList()));
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
