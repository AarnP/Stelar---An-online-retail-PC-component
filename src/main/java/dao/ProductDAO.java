package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DBUtil;
import entity.Product;

public class ProductDAO {
	public List<Product> getAllProducts() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> list = new ArrayList<Product>();

		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();
			// table category
			// Select * from category
			ps = conn.prepareStatement("SELECT * FROM product");

			// execute query and get result SET
			rs = ps.executeQuery();

			// MAPPING data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS (USER)
			// IF more than 1 row (DATA), then use WHILE instead of IF
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryId = rs.getInt("category_id");
				int stock = rs.getInt("stock");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String img = rs.getString("img");
				product = new Product(id, name, categoryId, stock, description, price, img);
				list.add(product);

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

	// Function get PRODUCT BY ID
	public Product getProductById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Product product = null;
		try {
			// make connection to mysql
			conn = DBUtil.makeConnection();
			// set query + parameter
			ps = conn.prepareStatement("SELECT * FROM product where id = ?");
			ps.setInt(1, id);

			// execute query and get result SET
			rs = ps.executeQuery();

			// MAPPING data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS (USER)
			// IF more than 1 row (DATA), then use WHILE instead of IF
			if (rs.next()) {
				String name = rs.getString("name");
				int category_id = rs.getInt("category_id");
				int stock = rs.getInt("stock");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				String img = rs.getString("img");
				product = new Product(id, name, category_id, stock, description, price, img);

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
		return product;
	}
	
	// Function get PRODUCT BY CATEGORY ID
		public List<Product> getProductByCategoryId(int id) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Product product = null;
			List<Product> list = new ArrayList<Product>();;
			try {
				// make connection to mysql
				conn = DBUtil.makeConnection();
				// set query + parameter
				ps = conn.prepareStatement("SELECT * FROM product where category_id = ?");
				ps.setInt(1, id);

				// execute query and get result SET
				rs = ps.executeQuery();

				// MAPPING data in result set (IF RESULT SET HAS DATA) into ENTITY CLASS (USER)
				// IF more than 1 row (DATA), then use WHILE instead of IF
				while (rs.next()) {
					String name = rs.getString("name");
					int category_id = rs.getInt("category_id");
					int stock = rs.getInt("stock");
					String description = rs.getString("description");
					double price = rs.getDouble("price");
					String img = rs.getString("img");
					product = new Product(id, name, category_id, stock, description, price, img);
					list.add(product);

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
