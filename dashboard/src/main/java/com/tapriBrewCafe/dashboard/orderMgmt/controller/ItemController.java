package com.tapriBrewCafe.dashboard.orderMgmt.controller;

import java.util.List;

import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemRequest;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemType;
import com.tapriBrewCafe.dashboard.orderMgmt.entity.model.Item;
import com.tapriBrewCafe.dashboard.orderMgmt.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<Item> addItem(@RequestBody ItemRequest itemRequest) {
        return new ResponseEntity<>(itemService.addItem(itemRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-all/{itemType}")
    public ResponseEntity<List<Item>> getAllItemsOfType(@PathVariable ItemType itemType) {
        return new ResponseEntity<>(itemService.getAllItemsOfType(itemType), HttpStatus.OK);
    }
}
