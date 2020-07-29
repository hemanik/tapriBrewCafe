package com.tapriBrewCafe.dashboard.orderMgmt.util;

import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemRequest;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemType;

public class OrderMgmtTestUtils {

    public static ItemRequest getItemRequest(String name, String desc, double cost, ItemType type) {
        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setName(name);
        itemRequest.setDescription(desc);
        itemRequest.setCost(cost);
        itemRequest.setType(type);
        return itemRequest;
    }
}
