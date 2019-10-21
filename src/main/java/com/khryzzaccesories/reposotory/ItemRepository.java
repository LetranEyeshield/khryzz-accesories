package com.khryzzaccesories.reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khryzzaccesories.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
