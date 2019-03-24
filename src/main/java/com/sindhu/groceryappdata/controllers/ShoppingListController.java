package com.sindhu.groceryappdata.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.groceryappdata.models.ShoppingList;
import com.sindhu.groceryappdata.services.ShoppingListService;

@RestController
public class ShoppingListController {
	private List<ShoppingList> shoppingLists = Arrays.asList(
			new ShoppingList("HEB"),
			new ShoppingList("WALMART"),
			new ShoppingList("ALDI"),
			new ShoppingList("HYVEE")
	);
	
	@Autowired
	private ShoppingListService service;
	
	@RequestMapping(value= "/shoppinglist", method=RequestMethod.POST)
	public void addShoppingList(@RequestBody ShoppingList shoppingList) {
		 service.addShoppingList(shoppingList);
	}
	
	@RequestMapping("/shoppinglist/{id}")
	public ShoppingList getShoppingList(@PathVariable int id) {
		return service.getShoppingListById(id);
	}
	
	@RequestMapping("/shoppinglists")
	public List<ShoppingList> getShoppingList() {
		return service.getAllShoppingLists();
	}
	
	@RequestMapping("/")
	public String Hello() {
		return "Hello World";
	}
	
	@RequestMapping(value="/shoppinglist", method= RequestMethod.DELETE)
	public void deleteShoppingList(@RequestBody ShoppingList shoppingList) {
		service.deleteShoppingList(shoppingList.getShoppingListId());
	}
	
	@RequestMapping(value="/shoppinglist", method = RequestMethod.PUT)
	public void updateShoppingList(@RequestBody ShoppingList shoppingList) {
		service.updateShoppingList(shoppingList);
	}
}
