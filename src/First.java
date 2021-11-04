import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;

public class First {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registration Completed");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=false");
			System.out.println("Connection Established SuccessFully");
			Statement st=cn.createStatement();
			System.out.println("statement is created");
			String qu="insert into employe.student values(4,'Jagadeesh',60000)";
			System.out.println(st.execute(qu));
			System.out.println("Data inserted");
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}

	}

}
