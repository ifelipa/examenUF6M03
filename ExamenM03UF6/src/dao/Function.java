package dao;

import java.sql.Connection;
import java.sql.Statement;

import db.Conectar;

public class Function {
	private Connection conexion;
	private Statement statement;
	
	public void createAlgoxStatement(){
		conexion= Conectar.getInstance().createConnection();
		
	}
}
