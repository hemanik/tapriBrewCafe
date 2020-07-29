package com.tapriBrewCafe.dashboard.orderMgmt.service;

import com.tapriBrewCafe.dashboard.orderMgmt.entity.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Sugar extends Condiment {

    @Autowired
    @Qualifier("")
    private Beverage beverage;

    @Autowired
    private ItemRepository itemRepository;

    public Sugar (Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return beverage.description() + itemRepository.findByName("sugar").getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost() + itemRepository.findByName("sugar").getCost();
    }
}
