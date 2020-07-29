package com.tapriBrewCafe.dashboard.orderMgmt.service;

import com.tapriBrewCafe.dashboard.orderMgmt.entity.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dark roast")
public class DarkRoast implements Beverage {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public String description() {
        return itemRepository.findByName("dark roast").getDescription();
    }

    @Override
    public double cost() {
        return itemRepository.findByName("dark roast").getCost();
    }
}
