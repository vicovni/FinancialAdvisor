package com.advisor.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advisor.api.entity.Item;
import com.advisor.api.entity.PortfolioItem;
import com.advisor.api.service.ItemService;
import com.advisor.api.service.PortfolioItemService;
import com.advisor.api.vo.PortfolioPercentagesVO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/advisor")
public class FinancialAdvisorController {
	@Autowired
	PortfolioItemService portfolioItemService;
	@Autowired
	ItemService itemService;

	@GetMapping("/portfolio")
	List<PortfolioItem> getAllPortfolioItems(){
		return portfolioItemService.getAllPortfolioItems();
	}
	@GetMapping("/risk/{risk}")
	List<PortfolioItem> getPortfolioItemsByRisk(@PathVariable Integer risk){
		return portfolioItemService.getPortfolioItemsByRisk(risk);
	}
	@GetMapping("/portfolio/{id}")
	PortfolioItem getPortfolioItem(@PathVariable Long id) {
		return portfolioItemService.getPortfolioItem(id);
	}
	@GetMapping("/item")
	List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	@PostMapping("/item")
	Item saveItem(@RequestBody Item item) {		
		return itemService.saveItem(item);
	}
	@GetMapping("/item/{id}")
	Item getItem(@PathVariable Long id) {
		return itemService.getItem(id);
	}
	@DeleteMapping("/item/{id}")
	Boolean deleteItem(@PathVariable Long id) {
		itemService.deleteItem(id);
		return true;
	}
	@GetMapping("/percentages")
	public PortfolioPercentagesVO getGroupedPortfolioItems() {
		return portfolioItemService.getGroupedPortfolioItems();
	}
	
}
