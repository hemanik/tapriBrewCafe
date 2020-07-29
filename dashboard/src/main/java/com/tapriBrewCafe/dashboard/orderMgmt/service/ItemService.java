package com.tapriBrewCafe.dashboard.orderMgmt.service;

import java.util.List;

import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemRequest;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemType;
import com.tapriBrewCafe.dashboard.orderMgmt.entity.model.Item;
import com.tapriBrewCafe.dashboard.orderMgmt.entity.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tapriBrewCafe.dashboard.orderMgmt.util.Converters.REQUEST_ITEM_FUNCTION;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(ItemRequest itemRequest) {
        return itemRepository.save(REQUEST_ITEM_FUNCTION.apply(itemRequest));
    }

    public List<Item> getAllItemsOfType(ItemType itemType) {
        return itemRepository.findByType(itemType.toString());
    }
}
