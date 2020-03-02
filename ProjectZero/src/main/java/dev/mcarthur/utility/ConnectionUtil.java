package dev.mcarthur.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {

//	public static void main(String[] args) {
//		
//		
//		String connDetails = "jdbc:mariadb://mountianeerdb.cb7ii8q3pav4.us-east-1.rds.amazonaws.com:3306/Project0?user=anthony&password=password";
//		
//		
//		try {
//			Connection conn = DriverManager.getConnection(connDetails);
//			
//			System.out.println(conn);
//			
//			conn.close();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		private static Connection connection = null;
		
		// we only have one connection object in the application ever!!
		public static Connection getConnection() {
			
			if(connection == null) {
				return createConnection();
			}else {
				return connection;
			}
			
		}
		
		private static Connection createConnection() {
			
			Properties props = new Properties();
			FileInputStream in;
			try {
				in = new FileInputStream("src/main/resources/connection.properties");
				props.load(in);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			String connectDetails = props.getProperty("connectInfo");
			
			try {
				Connection conn = DriverManager.getConnection(connectDetails);
				connection = conn;
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			
			
		}
	
		
		
		
		
	}
//}
