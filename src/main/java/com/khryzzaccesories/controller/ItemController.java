package com.khryzzaccesories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.khryzzaccesories.entity.Item;
import com.khryzzaccesories.service.ItemService;


@Controller
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	
	 @RequestMapping("/")
	    public String viewHomePage(Model model) {
	        List<Item> listItems = service.listAll();
	        model.addAttribute("listItems", listItems);
	         
	        return "index";
	    }
	 
	 @RequestMapping("/new")
	    public String showNewItemPage(Model model) {
	        Item item = new Item();
	        model.addAttribute("item", item);
	         
	        return "new_item";
	    }
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveProduct(@ModelAttribute("item") Item item) {
	        service.save(item);
	         
	        return "redirect:/";
	    }
	    
	    @RequestMapping("/edit/{item_id}")
	    public ModelAndView showEditProductPage(@PathVariable(name = "item_id") int item_id) {
	        ModelAndView mav = new ModelAndView("edit_item");
	        Item item = service.get(item_id);
	        mav.addObject("item", item);
	         
	        return mav;
	    }
	    
	    @RequestMapping("/delete/{item_id}")
	    public String deleteProduct(@PathVariable(name = "item_id") int item_id) {
	        service.delete(item_id);
	        return "redirect:/";       
	    }

	    

}
