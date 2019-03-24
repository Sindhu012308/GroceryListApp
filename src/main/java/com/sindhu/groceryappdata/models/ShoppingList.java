package com.sindhu.groceryappdata.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShoppingList {
	
	@Id
	private int shoppingListId;
	private String title;

	public ShoppingList(String title) {
		this.title = title;
	}
	
	public ShoppingList() {
	
	}
	
	public ShoppingList(int shoppingListId, String title) {
		this.shoppingListId = shoppingListId;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(int shoppingListId) {
		this.shoppingListId = shoppingListId;
	}
	
}
