package com.advisor.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advisor.api.entity.Item;
import com.advisor.api.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item getItem(Long id) {
		return itemRepository.getOne(id);
	}

	@Override
	public void deleteItem(Long id) {
		Item item = getItem(id);
		if(item!=null) {
			itemRepository.delete(item);
		}
		
		
	}

}
