package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException
	{
		//step1 read the file in java readable format using file input stream
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2 create object of properties class from java.util 
		
		Properties pObj=new Properties();
		
		//step3 Load the file input stream
		
		pObj.load(fis); /*properties class me data load kiya*/
		
		//step4 provide the key and read the value
		
		String URL = pObj.getProperty("url"); /*url is string and to differentiate btw key and value capital letter me liki key*/
		//extra
		System.out.println(URL);
		
		String USERNAME = pObj.getProperty("username");
		//extra
		System.out.println(USERNAME);
		
		String PASSWORD = pObj.getProperty("password");
		//extra
		System.out.println(PASSWORD);
		
	}

}
