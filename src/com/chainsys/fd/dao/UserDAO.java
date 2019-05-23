package com.chainsys.fd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.chainsys.fd.model.Menu;
import com.chainsys.fd.model.User;
import com.chainsys.fd.util.ConnectionUtil;

public class UserDAO {
	static final Logger log = Logger.getLogger(RestaurantDAO.class);
	public boolean validateLogin(User user) throws  SQLException {
		boolean isValid = false;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		log.debug("UserDAO :: validateLogin :: user :> "+user);
		try {
			String sql = "select user_id,password from userlogin";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			while (resultSet.next()) {
				if (resultSet.getString("user_id").contentEquals(user.getUserId())
						&& resultSet.getString("password").contentEquals(user.getPassword())) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			log.error("Exception caught"+e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		log.debug("UserDAO :: validateLogin :: user :> "+isValid);
		return isValid;
	}
	public String getUserName(String userId) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String userName = null;
		log.debug("UserDAO :: getUserName :: userId :> "+userId);
		try {
			String sql = "select user_name from userlogin where user_id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
			userName=resultSet.getString("user_name");	
			}
		} catch (Exception e) {
			log.error("Exception caught"+e.getMessage());
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		log.debug("UserDAO :: validateLogin :: user :> "+userName);
		return userName;
	}

}
