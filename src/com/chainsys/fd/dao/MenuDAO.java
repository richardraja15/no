package com.chainsys.fd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.chainsys.fd.exception.MenuException;
import com.chainsys.fd.exception.RestaurantException;
import com.chainsys.fd.model.Category;
import com.chainsys.fd.model.City;
import com.chainsys.fd.model.Menu;
import com.chainsys.fd.model.Restaurant;
import com.chainsys.fd.util.ConnectionUtil;
import com.chainsys.fd.util.IFoodConstants;

public class MenuDAO {
	static final Logger log = Logger.getLogger(MenuDAO.class);

	/**
	 * This method is used to all menu items name and category name
	 * 
	 * @return
	 * @throws MenuException
	 */
	public ArrayList<Menu> getMenuItems() throws MenuException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Menu> menuName = new ArrayList<>();
		try {
			String sql = "select category_id,menu_name from trn_menu";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Menu menu = new Menu();
				menu.setName(resultSet.getString("menu_name"));
				Category category = new Category();
				category.setCategoryId(resultSet.getInt("category_id"));
				menu.setCategory(category);
				menuName.add(menu);
			}
		} catch (SQLException e) {
			log.error("Exception caught"+e.getMessage());
			throw new MenuException(IFoodConstants.NO_MENU_FOUND);
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuName;
	}

	/**
	 * This method is used to get restaurant details using categoryId
	 * 
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<Restaurant> getRestaurantByCategory(int categoryId) throws RestaurantException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Restaurant> restaurants = new ArrayList<>();
		log.debug("MenuDAO :: getRestaurantByCategory :: categoryId :> "+categoryId);
		try {
			if (categoryId == 2) {
				String sql = "SELECT r.restaurant_id as restid, r.restaurant_name as restname,r.phone_number as phone,r.address as address,c.city_name as city,ct.category_id as categoryid,ct.NAME as name FROM ((restaurant  r  INNER JOIN city c  ON r.city_id = c.city_id)INNER JOIN category ct  ON r.category_id = ct.category_id) where ct.category_id=2 or category_id=4";
				preparedStatement = connection.prepareStatement(sql);
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
			} else {
				String sql = "SELECT r.restaurant_id as restid, r.restaurant_name as restname,r.phone_number as phone,r.address as address,c.city_name as city,ct.category_id as categoryid,ct.NAME as name FROM ((restaurant  r  INNER JOIN city c  ON r.city_id = c.city_id)INNER JOIN category ct  ON r.category_id = ct.category_id) where ct.category_id=?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, categoryId);
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
		log.debug("MenuDAO :: getRestaurantByCategory :: categoryId :> "+restaurants);
		return restaurants;
	}

	/**
	 * This method is used to get menu details using menuId
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Menu getMenuById(int menuId) throws MenuException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Menu menu = null;
		log.debug("MenuDAO :: getMenuById :: menuId :> "+menuId);
		try {
			String sql = "select menu_name,price from trn_menu where menu_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, menuId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				menu = new Menu();
				menu.setName(resultSet.getString("menu_name"));
				menu.setPrice(resultSet.getLong("price"));
			}
		} catch (SQLException e) {
			log.error("Exception Caught"+e.getMessage());
			throw new MenuException(IFoodConstants.NO_MENU_FOUND);
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		log.debug("MenuDAO :: getMenuById :: menu :> "+menu);
		return menu;
	}

	public ArrayList<Menu> getMenu(int categoryId) throws MenuException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Menu> menuName = new ArrayList<>();
		log.debug("MenuDAO :: getMenu :: categoryId :> "+categoryId);
		try {
			if (categoryId == 4) {
				String sql = "select menu_id,menu_name,price,image from trn_menu where category_id=1 or category_id=2";
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Menu menu = new Menu();
					menu.setMenuId(resultSet.getInt("menu_id"));
					menu.setName(resultSet.getString("menu_name"));
					menu.setPrice(resultSet.getLong("price"));
					menu.setImage(resultSet.getString("image"));
					menuName.add(menu);
				}
			} else {
				String sql = "select menu_id,menu_name,price,image from trn_menu where category_id=? ";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, categoryId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					Menu menu = new Menu();
					menu.setMenuId(resultSet.getInt("menu_id"));
					menu.setName(resultSet.getString("menu_name"));
					menu.setPrice(resultSet.getLong("price"));
					menu.setImage(resultSet.getString("image"));
					menuName.add(menu);
				}
			}
		} catch (SQLException e) {
			log.error("Exception Caught"+e.getMessage());
			throw new MenuException(IFoodConstants.NO_MENU_FOUND);
		} finally {
			try {
				ConnectionUtil.close(connection, preparedStatement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		log.debug("MenuDAO :: getMenu :: categoryId :> "+menuName);
		return menuName;
	}
}
