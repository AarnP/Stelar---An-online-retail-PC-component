package db.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil implements Serializable {

	public static Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Stelar?serverTimezone=Australia/Sydney", "aaron.phan",
					"Tony3007@");
			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
