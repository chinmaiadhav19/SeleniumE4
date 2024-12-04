package com.crm.BaseClass;




import java.io.IOException;
import java.time.Duration;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.java_utility.CommonData;
import com.crm.pom.LoginPom;
import com.crm.pom.LogoutPom;


public class BaseClass_Vtiger {

	public static WebDriver driver=null;
	public static CommonData browser1;
	public static String expected_url ;
	

	
   @BeforeSuite
   public void beforesuite()
   {
	   System.out.println("BeforeSuite");
	   
   }
   @BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest");
	}
	@BeforeClass
	 public static void preCondition() throws InterruptedException, IOException 
	  {
		browser1=new CommonData();
		String browser=browser1.data("browser");
		String url= browser1.data("url");
		expected_url = url;
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  driver= new ChromeDriver();
		  }
		  else if (browser.equalsIgnoreCase("edge") )
		 {
			  driver= new EdgeDriver();
		}
		  else if (browser.equalsIgnoreCase("firefox") )
			 {
				  driver= new FirefoxDriver();
			}
		  else 
		  {
			  driver=new ChromeDriver();
		  }
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get(url);
	  }
	
	@BeforeMethod
	public void login() throws IOException {
		
		String username=browser1.data("username");
		String password=browser1.data("password");
		LoginPom loginpom = new LoginPom(driver);
		loginpom.login(username, password);
	}
	
	@AfterMethod
	public static void logout()
	{
		LogoutPom lr = new LogoutPom(driver);
		lr.logout_icon().click();
		lr.logout().click();
	}
	
	@AfterClass
	public void postCondition() {
		driver.quit();
	}
	
	@AfterSuite
	public void  afterSuite()
	{
		System.out.println("AfterSuite");
	}
	


}
