package com.s3778909.challenge1.controller;

import com.s3778909.challenge1.dao.ItemDao;
import com.s3778909.challenge1.model.Item;
import com.s3778909.challenge1.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/item")
public class ItemController
{
    @Autowired
    private ItemDao itemDao;

    @GetMapping(path="/", produces = "application/json")
    public Items getItem()
    {
        return itemDao.getAllItems();
    }
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addItem(
            @RequestHeader(name = "X-COM-PERSIST", required = false) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
            @RequestBody Item item)
            throws Exception
    {
        //Generate resource id
        Integer id = itemDao.getAllItems().getItemList().size() + 1;
        item.setId(id.toString());

        //add resource
        itemDao.addItem(item);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }

}