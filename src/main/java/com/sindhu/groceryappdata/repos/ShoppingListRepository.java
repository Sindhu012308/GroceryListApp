package com.sindhu.groceryappdata.repos;

import org.springframework.data.repository.CrudRepository;

import com.sindhu.groceryappdata.models.ShoppingList;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Integer>{
	
	//getAllShoppingLists
	//getShoppingList(int ShoppingListId)
	//updateShoppingList(ShoppingList shoppingList
	
	
}
