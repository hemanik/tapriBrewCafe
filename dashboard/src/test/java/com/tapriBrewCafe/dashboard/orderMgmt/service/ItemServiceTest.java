package com.tapriBrewCafe.dashboard.orderMgmt.service;

import java.util.List;

import com.tapriBrewCafe.dashboard.config.EmbeddedPostgresConfig;
import com.tapriBrewCafe.dashboard.orderMgmt.config.OrderMgmtTestConfig;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemRequest;
import com.tapriBrewCafe.dashboard.orderMgmt.dtos.ItemType;
import com.tapriBrewCafe.dashboard.orderMgmt.entity.model.Item;
import com.tapriBrewCafe.dashboard.orderMgmt.entity.repository.ItemRepository;
import com.tapriBrewCafe.dashboard.orderMgmt.util.OrderMgmtTestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmbeddedPostgresConfig.class, OrderMgmtTestConfig.class})
@EntityScan(basePackages = {"com.tapriBrewCafe.dashboard.orderMgmt.entity.model"})
@EnableJpaRepositories(basePackages = {"com.tapriBrewCafe.dashboard.orderMgmt.entity.repository"})
@EnableAutoConfiguration
public class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private DarkRoast darkRoast;

    @Autowired
    private Sugar sugar;

    @Test
    public void testAddItem() {
        ItemRequest itemRequest = OrderMgmtTestUtils
                .getItemRequest("dark roast", "Dark Roast Coffee",100D, ItemType.BEVERAGE);

        Item item = itemService.addItem(itemRequest);

        Assert.assertNotNull(item);
    }

    @Test
    public void testGetAllItemsOfType() {
        List<Item> items = itemService.getAllItemsOfType(ItemType.BEVERAGE);

        Assert.assertEquals(1, items.size());
        Assert.assertEquals("dark roast", items.get(0).getName());
    }

    @Test
    public void order() {
        itemService.addItem(OrderMgmtTestUtils
                .getItemRequest("dark roast", "Dark Roast Coffee",100D, ItemType.BEVERAGE));

        itemService.addItem(OrderMgmtTestUtils
                .getItemRequest("sugar", "Sugar", 50D, ItemType.CONDIMENT));

        Item item = itemRepository.findByName("dark roast");

        Assert.assertNotNull(item);

        System.out.println(darkRoast.description() + ":" + darkRoast.cost());

        System.out.println(sugar.description() + ":" + sugar.cost());
    }

}
