package com.tapriBrewCafe.dashboard.staffMgmt.service;

import com.tapriBrewCafe.dashboard.staffMgmt.dtos.StaffRequest;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.model.Staff;
import com.tapriBrewCafe.dashboard.staffMgmt.entity.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tapriBrewCafe.dashboard.staffMgmt.util.Converters.REQUEST_STAFF_FUNCTION;

@Service
@Slf4j
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Staff createUser(StaffRequest staffRequest) {
        validateRequest(staffRequest);
        return staffRepository.save(REQUEST_STAFF_FUNCTION.apply(staffRequest));
    }

    public Staff getUserByName(String username) {
        return staffRepository.findByUsername(username);
    }

    private void validateRequest(StaffRequest staffRequest) {
        if (Strings.isEmpty(staffRequest.getUsername())) {
            throw new IllegalArgumentException("username cannot be empty");
        }
    }
}
