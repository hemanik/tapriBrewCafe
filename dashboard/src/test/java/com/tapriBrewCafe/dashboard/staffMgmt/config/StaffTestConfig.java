package com.tapriBrewCafe.dashboard.staffMgmt.config;

import com.tapriBrewCafe.dashboard.staffMgmt.controller.StaffController;
import com.tapriBrewCafe.dashboard.staffMgmt.service.StaffService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StaffTestConfig {

    @Bean
    public StaffService staffService() {
        return new StaffService();
    }

    @Bean
    public StaffController staffController() {
        return new StaffController();
    }
}
