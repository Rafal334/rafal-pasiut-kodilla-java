package com.kodilla.patterns2.facade.api;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private final List<ItemDto> items = new ArrayList<>();

    public void addItem(final ItemDto itemDto){
        items.add(itemDto);
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
