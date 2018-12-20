package org.smartinrubio.spring5webapp.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.smartinrubio.spring5webapp.model.Hotel;
import org.smartinrubio.spring5webapp.repository.HotelRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class HotelsControllerTest {

    private final List<Hotel> expectedHotels = Arrays.asList(
            new Hotel(1L, "Molina Larios", "Malaga Centro", 9F),
            new Hotel(2L, "Barcelo Malaga", "Malaga Centro", 8.7F),
            new Hotel(3L, "AC Hotel Malaga Palacio", "Malaga Centro", 8.5F),
            new Hotel(4L, "NH Malaga", "Malaga Centro", 8.3F),
            new Hotel(5L, "Vincci Malaga", "Playa Misericordia", 8.3F),
            new Hotel(6L, "Picasso Suites Malaga", "Malaga Centro", 8.9F)

    );

    @InjectMocks
    HotelsController controller;

    @Mock
    HotelRepository mockRepository;

    @Test
    public void getHotels_thenReturnsHotelsPage() throws Exception {

        when(mockRepository.findHotels()).thenReturn(expectedHotels);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/hotels.jsp"))
                .build();

        mockMvc.perform(get("/hotels"))
                .andExpect(model().attributeExists("hotelList"))
                .andExpect(model().attribute("hotelList", hasItems(expectedHotels.toArray())));

    }

}