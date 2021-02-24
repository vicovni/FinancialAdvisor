package com.advisor.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advisor.api.entity.PortfolioItem;
import com.advisor.api.repository.PortfolioItemRepository;
import com.advisor.api.vo.PortfolioPercentagesVO;

@Service
public class PortfolioItemServiceImpl implements PortfolioItemService {

	@Autowired
	private PortfolioItemRepository portfolioItemRepository;
	
	@Override
	public List<PortfolioItem> getAllPortfolioItems() {
		return portfolioItemRepository.findAll();
	}

	@Override
	public PortfolioItem getPortfolioItem(Long id) {
		return portfolioItemRepository.getOne(id);
	}

	@Override
	public PortfolioItem savePortfolioItem(PortfolioItem portofolioItem) {
		return portfolioItemRepository.save(portofolioItem);
	}

	@Override
	public List<PortfolioItem> getPortfolioItemsByRisk(Integer risk) {
		return portfolioItemRepository.getPortfolioItemsByRisk(risk);
	}

	@Override
	public PortfolioPercentagesVO getGroupedPortfolioItems() {
		List<PortfolioItem> portfolioItemList = this.getAllPortfolioItems();
		PortfolioPercentagesVO response = new PortfolioPercentagesVO();
		List<Map<String, String>> params = new ArrayList<>();
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0; i< portfolioItemList.size(); i++) {
			if(i == 0 || !portfolioItemList.get(i).getRisk().equals(portfolioItemList.get(i-1).getRisk())) {
				if(i!=0) {params.add(map);}
				map = new HashMap<String, String>();
				map.put("Risk", portfolioItemList.get(i).getRisk().toString());
				map.put(portfolioItemList.get(i).getItem().getName(), portfolioItemList.get(i).getPercentage().toString());
				
			} else {
				map.put(portfolioItemList.get(i).getItem().getName(), portfolioItemList.get(i).getPercentage().toString());
			}
		}
		params.add(map);
		response.setParams(params);
		return response;
	}

}
