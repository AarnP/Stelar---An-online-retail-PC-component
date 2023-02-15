package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.util.DBUtil;
import entity.User;

public class UserDAO {
	// Connect entity with DB
	// Data Access Object --> A layer to connect DB table and entity
	public User getUserByUsernameAndPassword(String username, String password) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();
			// set query + parameter
			ps = conn.prepareStatement("SELECT * \n" + "FROM user\n" + "WHERE username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			// execute query and get result SET
			rs = ps.executeQuery();
			
			// MAPPING data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS (USER)
			// IF more than 1 row (DATA), then use WHILE instead of IF
			if(rs.next()) {
				int id = rs.getInt("id");
				String status = rs.getString("status");
				user = new User(id, username, password, status);
				
			}
			// --> if exist --> return User(id, username, password, status)
			// --> not exist --> return null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return user;
	}
}
