package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JdbcExecuteQuerryPracticeTest 
{
	@Test
	public void sampleJdbc() throws SQLException 
	{
		Driver driverref=new Driver() ;
		
		//resister the driver
		DriverManager.registerDriver(driverref);
		
		//get connection with driver --> database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adsdatabase","root","root");
		
		//issue create statement
		Statement stat = con.createStatement();
		
		//execute the querry
		ResultSet result = stat.executeQuery("select * from candidateinfo;");//we can not print it directly because 
		//it is a table so we use while loop to print it
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2));
			//here we use coloumn not rows
		
		}
		//close the 
		con.close();
		System.out.println("db closed");
		
	}
} 