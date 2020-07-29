package com.tapriBrewCafe.dashboard.orderMgmt.entity.repository;

import java.util.List;

import com.tapriBrewCafe.dashboard.orderMgmt.entity.model.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, String> {

    Item findByName(String name);

    List<Item> findByType(String type);
}
