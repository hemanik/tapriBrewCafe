package com.tapriBrewCafe.dashboard.staffMgmt.dtos;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StaffRequest {

    private String userId;

    private String name;

    private String username;

    private String password;

    private String email;

    private int mobNo;

    private Timestamp dob;
}
