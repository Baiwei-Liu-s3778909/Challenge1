package com.s3778909.challenge1.model;

import java.util.ArrayList;
import java.util.List;

public class Items
{
    private List<Item> itemList;

    public List<Item> getTeacherList() {
        if(itemList == null) {
            itemList = new ArrayList<>();
        }
        return itemList;
    }

    public void setEmployeeList(List<Item> teacherList) {
        this.itemList = teacherList;
    }
}