package com.tapriBrewCafe.dashboard.staffMgmt.controller;

import com.tapriBrewCafe.dashboard.config.EmbeddedPostgresConfig;
import com.tapriBrewCafe.dashboard.staffMgmt.config.StaffTestConfig;
import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.util.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmbeddedPostgresConfig.class, StaffTestConfig.class})
@EntityScan(basePackages = { "com.tapriBrewCafe.dashboard.staffMgmt.entity.model"})
@EnableJpaRepositories(basePackages = {"com.tapriBrewCafe.dashboard.staffMgmt.entity.repository"})
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StaffController staffController;

    @Test
    public void testCreateUser() throws Exception {
        StaffRequest staffRequest = new StaffRequest();
        staffRequest.setName("hemani");
        staffRequest.setPassword("xyz");
        staffRequest.setUsername("helllo");

        mockMvc.perform(post("/add-user")
                .content(Utils.toJson(staffRequest))
                .contentType(APPLICATION_JSON))
                .andExpect(status().is(CREATED.value()))
                .andReturn();
    }

}
