package com.tapriBrewCafe.dashboard.staffMgmt.entity.repository;

import com.tapriBrewCafe.dashboard.staffMgmt.entity.model.Staff;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends PagingAndSortingRepository<Staff, String> {

    Staff findByUsername(String username);
}
