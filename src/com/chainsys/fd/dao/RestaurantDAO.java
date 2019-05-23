package com.chainsys.fd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.apache.log4j.Logger;

import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.model.Category;
import com.chainsys.fd.model.Restaurant;
import com.chainsys.fd.util.ConnectionUtil;
import com.chainsys.fd.util.IFoodConstants;

public class RestaurantDAO {
	static final Logger log = Logger.getLogger(RestaurantDAO.class);
	/**
	 * This method is used to get all restaurants.
	 * 
	 * @return
	 * @throws UnableToFind
	 * @throws SQLException
	 */
	public ArrayList<Restaurant> getRestaurant() throws  RestaurantException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		try {
			String sql = "SELECT r.restaurant_id as restid, r.restaurant_name as restname,ct.category_id as categoryid FROM restaurant  r INNER JOIN category ct  ON r.category_id = ct.category_id";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantId(resultSet.getInt("restid"));
				restaurant.setRestaurantName(resultSet.getString("restname"));
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("categoryid"));
				restaurant.setCategory(category);
				restaurants.add(restaurant);
			}
		} catch (SQLException e) {
			log.error("Exception caught"+e.getMessage());
			throw new RestaurantException(IFoodConstants.NO_REST_FOUND);
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return restaurants;
	}

	/**
	 * This method is used to get categoryId using restaurantId
	 * 
	 * @param restaurantId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	public int getCategoryByRestaurant(int restaurantId) throws  SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int categoryId = 0;
		log.debug("MenuDAO :: getCategoryByRestaurant :: restaurantId :> "+restaurantId);
		try {
			String sql = "select category_id from restaurant where restaurant_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, restaurantId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				categoryId = resultSet.getInt("category_id");
			}
		} catch (Exception e) {
			log.error("Exception caught"+e.getMessage());
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		log.debug("MenuDAO :: getCategoryByRestaurant :: categoryId :> "+categoryId);
		return categoryId;
	}

	/**
	 * This method is used to get restaurant details for specific restaurantId.
	 * 
	 * @param restaurantId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	public Restaurant getRestaurantById(int restaurantId) throws RestaurantException  {

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Restaurant restaurant = null;
		log.debug("MenuDAO :: getRestaurantById :: restaurantId :> "+restaurantId);
		try {
			String sql = "select restaurant_name from restaurant where restaurant_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, restaurantId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				restaurant = new Restaurant();
				restaurant.setRestaurantName(resultSet.getString("restaurant_name"));
			}
		} catch (SQLException e) {
			log.error("Exception caught"+e.getMessage());
			throw new RestaurantException(IFoodConstants.NO_REST_FOUND);
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		log.debug("MenuDAO :: getRestaurantById :: restaurant :> "+restaurant);
		return restaurant;
	}
}
