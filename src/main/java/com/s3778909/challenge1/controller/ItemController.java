package com.s3778909.challenge1.controller;

import com.s3778909.challenge1.dao.ItemDao;
import com.s3778909.challenge1.model.Item;
import com.s3778909.challenge1.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/item")
public class ItemController
{
    @Autowired
    private ItemDao itemDao;

    @GetMapping(path="/", produces = "application/json")
    public Items getEmployees()
    {
        return itemDao.getAllItems();
    }


}