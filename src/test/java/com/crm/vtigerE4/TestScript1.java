package com.crm.vtigerE4;



import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass_Vtiger;

public class TestScript1 extends BaseClass_Vtiger
{

	
@Test
	public void verification() {
	
	String actual_url=driver.getCurrentUrl();
	
	if(expected_url.equals(actual_url))
	{
		System.out.println("Right Page");
		
	 }
	else
	{
		System.out.println("Not in Right Page");
	}
}
	
}
