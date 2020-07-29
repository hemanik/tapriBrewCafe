package com.tapriBrewCafe.dashboard.staffMgmt.util;

import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;

public class StaffMgmtTestUtils {

    public static StaffRequest getStaffRequest() {
        StaffRequest staffRequest = new StaffRequest();
        staffRequest.setName("some-name");
        staffRequest.setPassword("password");
        staffRequest.setUsername("test-user");
        return staffRequest;
    }
}
