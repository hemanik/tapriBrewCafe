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

    @PostMapping("/add-user")
    public ResponseEntity<Staff> createUser(@RequestBody StaffRequest staffRequest) {
        return new ResponseEntity<>(staffService.createUser(staffRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{username}")
    public ResponseEntity<Staff> getUserByName(@PathVariable("username") String username) {
        return new ResponseEntity<>(staffService.getUserByName(username), HttpStatus.OK);
    }
}
