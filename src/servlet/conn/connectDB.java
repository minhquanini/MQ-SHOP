package servlet.conn;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {
	public static Connection getConnection() throws ClassNotFoundException, IOException{
		Connection conn=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL="jdbc:mysql://localhost:3306/mqshop";
		conn=DriverManager.getConnection(connectionURL,"root","admin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		Connection con=connectDB.getConnection();
		System.out.println("Connection to "+con);
	}
	*/
}
