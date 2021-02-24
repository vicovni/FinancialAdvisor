package com.advisor.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advisor.api.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
