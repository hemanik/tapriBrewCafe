package com.tapriBrewCafe.dashboard.orderMgmt.controller;

import com.tapriBrewCafe.dashboard.config.EmbeddedPostgresConfig;
import com.tapriBrewCafe.dashboard.orderMgmt.config.OrderMgmtTestConfig;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemRequest;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemType;
import com.tapriBrewCafe.dashboard.orderMgmt.util.OrderMgmtTestUtils;
import com.tapriBrewCafe.dashboard.staffMgmt.controller.StaffController;
import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.util.StaffMgmtTestUtils;
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
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmbeddedPostgresConfig.class, OrderMgmtTestConfig.class})
@EntityScan(basePackages = { "com.tapriBrewCafe.dashboard.orderMgmt.entity.model"})
@EnableJpaRepositories(basePackages = {"com.tapriBrewCafe.dashboard.orderMgmt.entity.repository"})
@AutoConfigureMockMvc
@EnableAutoConfiguration
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemController itemController;

    @Test
    public void testAddItem() throws Exception {
        ItemRequest itemRequest = OrderMgmtTestUtils
                .getItemRequest("dark roast", "Dark Roast Coffee",100D, ItemType.BEVERAGE);

        mockMvc.perform(post("/add-item")
                .content(Utils.toJson(itemRequest))
                .contentType(APPLICATION_JSON))
                .andExpect(status().is(CREATED.value()))
                .andReturn();
    }

    @Test
    public void testGetAllItemsOfType() throws Exception {
        mockMvc.perform(get("/get-all/" + ItemType.BEVERAGE))
                .andExpect(status().is(OK.value()))
                .andReturn();
    }
}
