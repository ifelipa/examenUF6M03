package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import db.Conectar;

public class Function {
	private Connection conexion;
	private Statement statement;
	
	public void createAlgoxStatement(){
		conexion= Conectar.getInstance().createConnection();
		String sql = "INSERT INTO feedback.comments" + "(MYUSER, EMAIL, WEBPAGE,DATUM, SUMMARY, COMMENTS) VALUES"
				+ "(?,?,?,CURRENT_TIMESTAMP,?,?)";
		try {
			statement = conexion.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		
		while (resultSet.next()) {

			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
			System.out.println("User: " + user);
			System.out.println("Website: " + website);
			System.out.println("Summary: " + summary);
			System.out.println("Date: " + date);
			System.out.println("Comment: " + comment);
			System.out.println("*************************");
		}
	}
}
