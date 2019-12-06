package esse.tigerdark.gmail.com;

import com.fasterxml.jackson.databind.ObjectMapper;
import esse.tigerdark.gmail.com.controllers.ParkingController;
import esse.tigerdark.gmail.com.models.Parking;
import esse.tigerdark.gmail.com.service.ParkingService;
import esse.tigerdark.gmail.com.service.impl.ParkingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by User on 06.12.2019.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ParkingController.class)
@EnableWebMvc
@ActiveProfiles(value = "test")
public class ParkingCountFreePlaceTest {
    private ObjectMapper objectMapper = new ObjectMapper();
    @MockBean
    private ParkingService parkingService;
    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testGetFreePlacePositive() throws Exception {
        when(parkingService.getFreeParking()).thenReturn(getAllFree());
        mockMvc.perform(get("/parking/getCountFree")).andExpect(status().isOk())
                .andExpect(jsonPath("result", is(10)));

        verify(parkingService, times(1)).getFreeParking();
        verifyNoMoreInteractions(parkingService);
    }

    @Test (expected = NullPointerException.class)
    public void testFindUserByIdNegative() {
        parkingService = new ParkingServiceImpl();
        parkingService.getFreeParking();
        fail();
    }

    private Integer getAllFree() {
        List<Parking> out = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            Parking p = new Parking();
            p.setId(i);
            p.setIsEmpty(true);
            out.add(p);

        }
        return out.size();
    }
}
