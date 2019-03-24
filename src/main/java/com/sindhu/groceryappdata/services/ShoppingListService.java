package com.sindhu.groceryappdata.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindhu.groceryappdata.models.ShoppingList;
import com.sindhu.groceryappdata.repos.ShoppingListRepository;


@Service
public class ShoppingListService {
	
	@Autowired
	private ShoppingListRepository repository;
	
	private List<ShoppingList> shoppingLists ;
	
	public ShoppingListService(){
		shoppingLists = new ArrayList<ShoppingList>();
		shoppingLists.add(new ShoppingList(1, "HEB"));
		shoppingLists.add(new ShoppingList(2, "WALMART"));
		shoppingLists.add(new ShoppingList(3, "ALDI"));
		shoppingLists.add(new ShoppingList(4, "HYVEE"));
	}
	
	public ShoppingList getShoppingListById(int id) {
		return repository.findById(id).get();
		//return shoppingLists.stream().filter(x -> x.getShoppingListId() == id).findFirst().get();
	}
	
	public List<ShoppingList> getAllShoppingLists() {
		List<ShoppingList> shoppingLists = new ArrayList<>();
		 repository.findAll().forEach(x -> shoppingLists.add(x));
		 return shoppingLists;
	}
	
	public void deleteShoppingList(int shoppingListId) {
		//ShoppingList shoppingList = getShoppingListById(shoppingListId);
		//shoppingLists.remove(shoppingList);
		ShoppingList shoppingList = repository.findById(shoppingListId).get();
		repository.delete(shoppingList);
	}
	
	public void addShoppingList(ShoppingList shoppingList) {
		repository.save(shoppingList);
		// shoppingLists.add(shoppingList);
	}
	
	public void updateShoppingList(ShoppingList shoppingList) {
		ShoppingList persistedShoppingList = getShoppingListById(shoppingList.getShoppingListId());
		persistedShoppingList.setTitle(shoppingList.getTitle());
		repository.save(persistedShoppingList);
	}

}
