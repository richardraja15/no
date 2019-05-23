package com.chainsys.fd.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.fd.dao.MenuDAO;
import com.chainsys.fd.dao.RestaurantDAO;
import com.chainsys.fd.exception.MenuException;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.model.Menu;
import com.chainsys.fd.model.Restaurant;
import com.chainsys.fd.services.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {

	@Override
	public int getCategoryByRestaurant(int restaurantId) throws SQLException {
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		int categoryId = 0;
		categoryId = restaurantDAO.getCategoryByRestaurant(restaurantId);
		return categoryId;
	}

	@Override
	public ArrayList<Menu> getMenu(int categoryId) throws MenuException {
		MenuDAO menuDAO = new MenuDAO();
		ArrayList<Menu> list = null;
		list = menuDAO.getMenu(categoryId);
		return list;
	}

	@Override
	public ArrayList<Restaurant> getRestaurant() throws RestaurantException {
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		ArrayList<Restaurant> list = null;
		list = restaurantDAO.getRestaurant();
		return list;
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) throws RestaurantException {
		Restaurant restaurant = null;
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		restaurant = restaurantDAO.getRestaurantById(restaurantId);
		return restaurant;
	}
}
