package com.gc.model;

public interface DAOUser {

	abstract void createUser(User user);

	abstract void updateUser(User user);
	
	abstract User getUser(String email);
	
}