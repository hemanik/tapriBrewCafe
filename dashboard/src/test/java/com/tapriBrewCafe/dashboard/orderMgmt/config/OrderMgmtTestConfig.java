package com.tapriBrewCafe.dashboard.orderMgmt.config;

import com.tapriBrewCafe.dashboard.orderMgmt.controller.ItemController;
import com.tapriBrewCafe.dashboard.orderMgmt.service.DarkRoast;
import com.tapriBrewCafe.dashboard.orderMgmt.service.ItemService;
import com.tapriBrewCafe.dashboard.orderMgmt.service.Sugar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMgmtTestConfig {

    @Bean
    public ItemController itemController() {
        return new ItemController();
    }

    @Bean
    public ItemService itemService() {
        return new ItemService();
    }

    @Bean
    public DarkRoast darkRoast() {
        return new DarkRoast();
    }

    @Bean
    public Sugar sugar() {
        return new Sugar(darkRoast());
    }
}
