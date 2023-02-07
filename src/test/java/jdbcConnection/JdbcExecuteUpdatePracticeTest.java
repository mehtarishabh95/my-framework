package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcExecuteUpdatePracticeTest 
{
	@Test
	public void jdbcUpdate() throws SQLException
	{
		//resister the driver
		Driver driverref = new Driver();
		
		//get connection with driver--> database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsdatabase","root","root");
		
		//issue create statement
		Statement stat = con.createStatement();
		
		//update the querry
		String querry = "insert into candidateinfo values('batman',3,'Newyork');";
		int up = stat.executeUpdate(querry);//it will return rowno
		//for confirmation if this is added or not
		if(up==1)
		{
			System.out.println("data added successfully");
		}
		
		//just checking table datas
		ResultSet result = stat.executeQuery("select * from candidateinfo;");
		//to print table using while loop
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		
		//close the database
		con.close();
		System.out.println("db closed");
		
	}
}
