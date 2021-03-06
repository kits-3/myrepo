package com.booking.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.booking.configuration.ConnectionFactory;
import com.booking.entity.AccountEntity;
import com.booking.repository.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository{
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public AccountEntity checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		String query = "select * from acc where user_name = ? and pass_word = ?";
		AccountEntity acc = new AccountEntity();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1 , username);
			stmt.setString(2 , password);
			rs = stmt.executeQuery();
//			rs.next();
			while(rs.next()) {
				acc.setIdUser(rs.getInt("id_user"));
				acc.setUsername(rs.getString("user_name"));
				acc.setPassword(rs.getString("pass_word"));
				acc.setRole(rs.getString("role"));
				acc.setNameOfUser(rs.getString("name_of_user"));
				acc.setAge(rs.getInt("age"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
				
			}
		}
		return acc;
	}

}
