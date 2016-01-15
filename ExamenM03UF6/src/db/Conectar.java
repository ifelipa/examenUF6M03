package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conectar {
	
	
	private static Conectar instance = null;
		public static final String URL = "jdbc:mysql://localhost/feedback?";
		public static final String USER = "root";//"sqluser";
		public static final String PASSWORD = "jupiter";//"sqluserpw";
		public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

		private Conectar() {
			try {
				Class.forName(DRIVER_CLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public static Conectar getInstance() {
			if (instance == null) {
				instance = new Conectar();
			}
			return instance;
		}

		public static Connection createConnection() {
			Connection connection = null;
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("ERROR: Unable to Connect to Database.");
			}
			return connection;
		}

	}
