package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DemoB 
{
	@Test
	public void TestA() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/schema";
		String username = "root";
		String password = "root";
		
		Connection con = DriverManager.getConnection(url, username, password);
		Statement statement = con.createStatement();
		String qu = "select * from ST_Data";
		ResultSet resulte = statement.executeQuery(qu);
		while(resulte.next())
		{
			int id = resulte.getInt(1);
			String name = resulte.getString(2);
			String place = resulte.getString(3);
			System.out.println("ST_ID "+id+"\t"+"ST_Name"+name+"\t"+"ST_place "+place);
		}
		
		con.close();
		
	}
}
