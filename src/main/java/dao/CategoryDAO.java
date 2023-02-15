package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DBUtil;
import entity.Category;


public class CategoryDAO {

	public List<Category> getAllCategories() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Category category = null;
		List<Category> list = new ArrayList<Category>();
		
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();
			// table category
			// Select * from category
			ps = conn.prepareStatement("SELECT * FROM category");

			// execute query and get result SET
			rs = ps.executeQuery();

			// MAPPING data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS (USER)
			// IF more than 1 row (DATA), then use WHILE instead of IF
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int priority = rs.getInt("priority");
				boolean isShow = rs.getBoolean("is_show");
				category = new Category(id, name, priority, isShow);
				list.add(category);

			}
			// --> if exist --> return User(id, username, password, status)
			// --> not exist --> return null
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}
}
