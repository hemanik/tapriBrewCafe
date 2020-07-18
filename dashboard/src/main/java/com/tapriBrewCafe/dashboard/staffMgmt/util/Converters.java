package com.tapriBrewCafe.dashboard.staffMgmt.util;

import java.util.UUID;
import java.util.function.Function;

import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.model.Staff;

public interface Converters {

    Function<StaffRequest, Staff> REQUEST_STAFF_FUNCTION = staffRequest -> Staff.builder()
            .staffId(UUID.randomUUID().toString())
            .name(staffRequest.getName())
            .username(staffRequest.getUsername())
            .password(staffRequest.getPassword())
            .email(staffRequest.getEmail())
            .mobNo(staffRequest.getMobNo())
            .dob(staffRequest.getDob())
            .build();
}
