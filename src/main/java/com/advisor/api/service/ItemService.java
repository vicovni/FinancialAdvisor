package com.advisor.api.service;

import java.util.List;

import com.advisor.api.entity.Item;

public interface ItemService {
	Item saveItem(Item item);
	List<Item> getAllItems();
	Item getItem(Long id);
	void deleteItem(Long id);

}
