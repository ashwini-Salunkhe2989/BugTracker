
package com.ratepay.bugtracker.bugtracker;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ratepay.bugtracker.Dto.BugDetailsDto;
import com.ratepay.bugtracker.controller.BugUpdateController;
import com.ratepay.bugtracker.service.BugUpdationService;

@WebMvcTest(controllers = BugUpdateController.class)
public class BugUpdationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
	private BugUpdationService bugUpdationService;

    
    private BugDetailsDto bugDetailsDto;


    @BeforeEach
    void setUp() {
        this.bugDetailsDto=new BugDetailsDto();
        bugDetailsDto.setAssigneeName("ashwini");
        bugDetailsDto.setUpdatedBy("pranav");
        bugDetailsDto.setBugId((long) 1);
    }
    
   


}


