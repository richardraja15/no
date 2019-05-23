package com.chainsys.fd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.exception.SearchException;
import com.chainsys.fd.model.Category;
import com.chainsys.fd.model.City;
import com.chainsys.fd.model.Restaurant;
import com.chainsys.fd.util.ConnectionUtil;
import com.chainsys.fd.util.IFoodConstants;

public class FindDAO {
static final Logger log=Logger.getLogger(FindDAO.class);

	/**
	 * This method is used to get restaurant details using search keyword.
	 * 
	 * @param search
	 * @return
	 * @throws SQLException 
	 * @throws RestaurantException 
	 * @throws Exception
	 */
	public ArrayList<Restaurant> getRestaurant(String search) throws SearchException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		try {
			String sql = "SELECT r.restaurant_id as restid, r.restaurant_name as restname,r.phone_number as phone,r.address as address,c.city_name as city,ct.category_id as categoryid,ct.NAME as name FROM ((restaurant  r  INNER JOIN city c  ON r.city_id = c.city_id)INNER JOIN category ct  ON r.category_id = ct.category_id) where r.restaurant_name LIKE ?";
			log.debug("FindDAO :: getRestaurant :: search :> "+search);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, search + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantId(resultSet.getInt("restid"));
				restaurant.setRestaurantName(resultSet.getString("restname"));
				restaurant.setPhoneNumber(resultSet.getLong("phone"));
				restaurant.setAddress(resultSet.getString("address"));
				City city = new City();
				city.setCityName(resultSet.getString("city"));
				restaurant.setCity(city);
				Category category = new Category();
				category.setCategoryName(resultSet.getString("name"));
				category.setCategoryId(resultSet.getInt("categoryid"));
				restaurant.setCategory(category);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			log.error("Exception caught"+e.getMessage());
			throw new SearchException(IFoodConstants.NO_REST_FOUND);
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		log.debug("FindDAO :: getRestaurant :: restaurants:> "+restaurants.toArray().toString());
		return restaurants;
	}
}
