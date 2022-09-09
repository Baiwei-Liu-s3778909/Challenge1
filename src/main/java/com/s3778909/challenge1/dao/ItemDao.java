package com.s3778909.challenge1.dao;


import com.s3778909.challenge1.model.Item;
import com.s3778909.challenge1.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao
{
    private static Items list = new Items();

    static
    {
        list.getItemList().add(new Item("1", "Bag", "good bag", "bag.jpg", 1390));
        list.getItemList().add(new Item("2", "Computer", "good computer", "computer.jpg",2213));
        list.getItemList().add(new Item("3", "Phone", "good phone", "titanic.jpg",2142));
    }

    public Item getItemById(String id){
        for(Item i : list.getItemList()){
            if(i.getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public Items getAllItems()
    {
        return list;
    }

    public void addItem(Item item) {
        list.getItemList().add(item);
    }
}