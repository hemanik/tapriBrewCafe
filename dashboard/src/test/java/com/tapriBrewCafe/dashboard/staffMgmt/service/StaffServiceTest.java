package com.tapriBrewCafe.dashboard.staffMgmt.service;

import java.util.ArrayList;

import com.google.common.collect.Lists;
import com.tapriBrewCafe.dashboard.config.EmbeddedPostgresConfig;
import com.tapriBrewCafe.dashboard.staffMgmt.config.StaffTestConfig;
import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.model.Staff;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.repository.StaffRepository;
import com.tapriBrewCafe.dashboard.staffMgmt.util.StaffMgmtTestUtils;
import org.junit.After;
import org.junit.AfterClass;
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
    public void testRegisterUser() {
        StaffRequest staffRequest = StaffMgmtTestUtils.getStaffRequest();

        staffService.registerStaff(staffRequest);

        ArrayList<Staff> storedStaff = Lists.newArrayList(staffRepository.findAll());
        Assert.assertEquals(1, storedStaff.size());
        Assert.assertEquals("test-user", storedStaff.get(0).getUsername());
    }

    @Test
    public void testGetUser() {
        Staff staff = staffService.getStaffByUsername("test-user");

        Assert.assertEquals("some-name", staff.getName());
        Assert.assertEquals("password", staff.getPassword());
        Assert.assertEquals("test-user", staff.getUsername());
    }
}
