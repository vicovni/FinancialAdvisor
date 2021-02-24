package com.advisor.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.advisor.api.entity.PortfolioItem;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
	
	@Query("from PortfolioItem where risk = ?1")
	List<PortfolioItem> getPortfolioItemsByRisk(Integer risk);
}
