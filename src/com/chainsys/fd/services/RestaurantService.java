package com.chainsys.fd.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.fd.exception.MenuException;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.model.Menu;
import com.chainsys.fd.model.Restaurant;

public interface RestaurantService {
	public int getCategoryByRestaurant(int restaurantId)throws  SQLException;
	public ArrayList<Menu> getMenu(int categoryId)throws MenuException;
	public ArrayList<Restaurant> getRestaurant()throws RestaurantException;
	public Restaurant getRestaurantById(int restaurantId)throws RestaurantException;
}
