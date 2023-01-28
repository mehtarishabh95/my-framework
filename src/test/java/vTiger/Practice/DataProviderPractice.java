package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider = "getdata")
public void addProductToCartTest(String phone,int price, String model)
{
	System.out.println(phone+" "+price+" "+model);
}
	
	
	@DataProvider
	public Object [][] getdata()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="Samsung";
		data[0][1]=1200;
		data[0][2]="s5222";
		
		data[1][0]="Nokia";
		data[1][1]=1500;
		data[1][2]="Nokia1200";
		
		return data;
		
	}

}
