package com.gc.model;

import java.util.ArrayList;

public interface DAOItem {
	
	void addItem(Item item);
	
	ArrayList<Item> getClosetItems(User user);
	
	void deleteItem(Item item);
	
	ArrayList<Item> getOutfit();
	
	void changeHampStatus(Item item);
	
	ArrayList<Item> getHamperItems(User user);

	Item getItem(int itemId);

}
