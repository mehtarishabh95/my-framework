package vTiger.Practice;

import vTiger.GenericUtilities.JavaUtility;

public class RandomNumberPractice {

	public static void main(String[] args) 
	{
		JavaUtility jutil = new JavaUtility();
		int rand = jutil.getRandomNumber();
		System.out.println(rand);

	}

}
