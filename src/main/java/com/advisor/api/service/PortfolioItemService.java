package com.advisor.api.service;

import java.util.List;

import com.advisor.api.entity.PortfolioItem;
import com.advisor.api.vo.PortfolioPercentagesVO;

public interface PortfolioItemService {
	List<PortfolioItem> getAllPortfolioItems();
	PortfolioItem getPortfolioItem(Long id);
	PortfolioItem savePortfolioItem(PortfolioItem portofolioItem);
	
	List<PortfolioItem> getPortfolioItemsByRisk(Integer risk);
	PortfolioPercentagesVO getGroupedPortfolioItems();
}
