package com.chainsys.fd.services.impl;

import java.util.ArrayList;
import com.chainsys.fd.dao.FindDAO;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.exception.SearchException;
import com.chainsys.fd.model.Restaurant;
import com.chainsys.fd.services.FindService;

public class FindServiceImpl implements FindService {
	FindDAO dao=new FindDAO();

	@Override
	public ArrayList<Restaurant> getRestaurant(String search) throws SearchException{
		ArrayList<Restaurant> restaurants = null;
		restaurants=dao.getRestaurant(search);
		return restaurants;
	}
}
