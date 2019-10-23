package com.nishu.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConnectionTest {

	
	
	
	
	public static void main(String[] args) {

		
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.nishu.db");
		context.refresh();

		DBConnection dbConnection = context.getBean(DBConnection.class);
		try(Connection con = dbConnection.getConnection();){
			
			System.out.println(con.getMetaData().getDatabaseProductName());
			System.out.println(con.getMetaData().getDatabaseProductVersion());
		
		}catch(SQLException e) {

		}

		// close the spring context
		context.close();
	}

}
