import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
public class PropertiesFile {

	public static void main(String[] args) {
		try {
			FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
			Properties p=new Properties();
			p.load(ab);
			Class.forName(p.getProperty("driver"));
			Connection cn=DriverManager.getConnection(p.getProperty("url"));
			Statement st=cn.createStatement();
			String qu="select * from employe.student";
			ResultSet rs=st.executeQuery(qu);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String na=rs.getString(2);
				Double sa=rs.getDouble(3);
				System.out.println(id+" "+na+" "+sa);
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
