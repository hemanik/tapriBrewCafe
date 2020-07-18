package com.tapriBrewCafe.dashboard.staffMgmt.service;

import com.tapriBrewCafe.dashboard.config.EmbeddedPostgresConfig;
import com.tapriBrewCafe.dashboard.staffMgmt.config.StaffTestConfig;
import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.model.Staff;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.repository.StaffRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmbeddedPostgresConfig.class, StaffTestConfig.class})
@EntityScan(basePackages = {"com.tapriBrewCafe.dashboard.staffMgmt.entity.model"})
@EnableJpaRepositories(basePackages = {"com.tapriBrewCafe.dashboard.staffMgmt.entity.repository"})
@EnableAutoConfiguration
public class StaffServiceTest {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void testCreateUser() {
        StaffRequest staffRequest = new StaffRequest();
        staffRequest.setName("hemani");
        staffRequest.setPassword("xyz");
        staffRequest.setUsername("helllo");
        Staff staff = staffService.createUser(staffRequest);

        Assert.assertNotNull(staff);
    }
}
