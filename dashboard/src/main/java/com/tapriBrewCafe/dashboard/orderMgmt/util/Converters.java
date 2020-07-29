package com.tapriBrewCafe.dashboard.orderMgmt.util;

import java.util.UUID;
import java.util.function.Function;

import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemRequest;
import com.tapriBrewCafe.dashboard.orderMgmt.entity.model.Item;

public interface Converters {

    Function<ItemRequest, Item> REQUEST_ITEM_FUNCTION = itemRequest -> Item.builder()
            .id(UUID.randomUUID().toString())
            .name(itemRequest.getName())
            .description(itemRequest.getDescription())
            .cost(itemRequest.getCost())
            .type(itemRequest.getType().toString())
            .build();
}
