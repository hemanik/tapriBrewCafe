package com.tapriBrewCafe.dashboard.orderMgmt.service;

import com.tapriBrewCafe.dashboard.orderMgmt.entity.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseBlend implements Beverage {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public String description() {
        return itemRepository.findByName("house blend").getDescription();
    }

    @Override
    public double cost() {
        return itemRepository.findByName("house blend").getCost();
    }
}
