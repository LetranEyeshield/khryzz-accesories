package com.khryzzaccesories.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khryzzaccesories.entity.Item;
import com.khryzzaccesories.reposotory.ItemRepository;

@Service
@Transactional
public class ItemService {
	
	@Autowired
	private ItemRepository repo;
	
	public List<Item> listAll() {
        return repo.findAll();
    }
     
    public void save(Item item) {
        repo.save(item);
    }
     
    public Item get(int item_id) {
        return repo.findById(item_id).get();
    }
     
    public void delete(int item_id) {
        repo.deleteById(item_id);
    }

}
