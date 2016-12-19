package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.CustomerDao;
import util.JdbcUtil;

public class CustomerDaoImpl implements CustomerDao {

	public int findCustomerByFirst_name(String name) {
	    Connection connection=JdbcUtil.getConnection();
	    int id=0;
	    try {
			PreparedStatement preparedStatement=connection.prepareStatement("select * from customer where first_name=?");
		    preparedStatement.setString(1, name);
		    ResultSet resultSet=preparedStatement.executeQuery();
		    if (resultSet.next()) {
		    	id=resultSet.getInt(1);
			}
		    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
		return id;
	}

}
