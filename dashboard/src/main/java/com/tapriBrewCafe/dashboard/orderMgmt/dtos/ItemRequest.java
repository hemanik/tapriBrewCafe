package com.tapriBrewCafe.dashboard.orderMgmt.dtos;

import lombok.Data;

@Data
public class ItemRequest {

    private String name;

    private String description;

    private double cost;

    private ItemType type;
}
