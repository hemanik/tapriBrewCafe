package com.tapriBrewCafe.dashboard.staffMgmt.controller;

import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.model.Staff;
import com.tapriBrewCafe.dashboard.staffMgmt.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/register-user")
    public ResponseEntity<Staff> registerStaff(@RequestBody StaffRequest staffRequest) {
        return new ResponseEntity<>(staffService.registerStaff(staffRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{username}")
    public ResponseEntity<Staff> getStaffByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(staffService.getStaffByUsername(username), HttpStatus.OK);
    }
}
