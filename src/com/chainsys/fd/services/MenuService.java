package com.chainsys.fd.services;

import java.util.ArrayList;

import com.chainsys.fd.exception.MenuException;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.model.Menu;
import com.chainsys.fd.model.Restaurant;

public interface MenuService {
	public ArrayList<Menu> getMenuItems() throws MenuException ;
	public ArrayList<Restaurant> getRestaurantByCategory(int categoryId)throws RestaurantException;
	public ArrayList<Menu> getMenu(int categoryId) throws MenuException;
}
