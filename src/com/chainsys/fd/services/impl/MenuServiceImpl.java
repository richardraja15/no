package com.chainsys.fd.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.fd.dao.MenuDAO;
import com.chainsys.fd.exception.MenuException;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.model.Menu;
import com.chainsys.fd.model.Restaurant;
import com.chainsys.fd.services.MenuService;

public class MenuServiceImpl implements MenuService {

	@Override
	public ArrayList<Menu> getMenuItems() throws MenuException {
		MenuDAO menuDAO = new MenuDAO();
		ArrayList<Menu> menus = null;
		menus = menuDAO.getMenuItems();
		return menus;
	}

	@Override
	public ArrayList<Restaurant> getRestaurantByCategory(int categoryId) throws RestaurantException {
		ArrayList<Restaurant> restaurants = null;
		MenuDAO menuDAO = new MenuDAO();
		restaurants = menuDAO.getRestaurantByCategory(categoryId);
		return restaurants;
	}

	@Override
	public ArrayList<Menu> getMenu(int categoryId) throws MenuException {
		ArrayList<Menu> menus = null;
		MenuDAO menuDAO = new MenuDAO();
		menus = menuDAO.getMenu(categoryId);
		return menus;
	}
}
