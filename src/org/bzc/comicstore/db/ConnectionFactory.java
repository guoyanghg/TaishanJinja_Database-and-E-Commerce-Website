package org.bzc.comicstore.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private String driver = "";
	private String dbURL = "";
	private String user = "";
	private String password = "";
	private static ConnectionFactory factory = null;

	private ConnectionFactory() throws Exception {
		driver = "com.mysql.jdbc.Driver";
		dbURL = "jdbc:mysql://localhost:3306/comicstore?useUnicode=true&characterEncoding=UTF-8";
		user = "root";
		password = "root";
	}

	public static Connection getConnection() {
		Connection conn = null;
		if (factory == null) {
			try {
				factory = new ConnectionFactory();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		try {
			Class.forName(factory.driver);
			conn = DriverManager.getConnection(factory.dbURL, factory.user,
					factory.password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
