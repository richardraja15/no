package com.chainsys.fd.services;

import java.util.ArrayList;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.exception.SearchException;
import com.chainsys.fd.model.Restaurant;

public interface FindService {
	public ArrayList<Restaurant> getRestaurant(String search) throws SearchException ;

}
