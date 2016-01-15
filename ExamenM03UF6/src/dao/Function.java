package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import db.Conectar;
import db.DbUtil;

public class Function {
	private Connection conexion;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public void createAlgoxStatement(){
		
		String sql = "select * from comments";
		try {
			conexion= Conectar.getInstance().createConnection();
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			writeResultSet(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.close(conexion);
			DbUtil.close(statement);
		}
		
		
	}
	
	public void createAlgoxPreparedStatement(){
		
		String sql = "INSERT INTO feedback.comments" + "(MYUSER, EMAIL, WEBPAGE,DATUM, SUMMARY, COMMENTS) VALUES"
				+ "(?,?,?,CURRENT_TIMESTAMP,?,?)";
		
		try {
			conexion=Conectar.getInstance().createConnection();
			preparedStatement = conexion.prepareStatement(sql);
			/*
			 * todos los datos a ingresar de acuerdo al numeor de parametros
			 */
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(conexion);
			DbUtil.close(preparedStatement);
		}
		
		
	}
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		
		try {
			while (resultSet.next()) {

				String user = resultSet.getString("MYUSER");
				String website = resultSet.getString("WEBPAGE");
				String summary = resultSet.getString("SUMMARY");
				Date date = resultSet.getDate("DATUM");
				String comment = resultSet.getString("comments");
				System.out.println("User: " + user);
				System.out.println("Website: " + website);
				System.out.println("Summary: " + summary);
				System.out.println("Date: " + date);
				System.out.println("Comment: " + comment);
				System.out.println("*************************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(resultSet);
		}
	}
}
