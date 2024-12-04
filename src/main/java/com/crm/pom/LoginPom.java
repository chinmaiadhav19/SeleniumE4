package com.crm.pom;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPom {

	 WebDriver driver; 
	 public LoginPom(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
	    
	 @FindBy(name="user_name")
		private WebElement username;
		
		@FindBy(name="user_password")
		private WebElement password;
		
		@FindBy(id="submitButton")
		private WebElement loginbutton;
	
		
		
		public void login(String un, String pswd) throws IOException 
		{
			
		this.username.sendKeys(un);
		this.password.sendKeys(pswd);
		this.loginbutton.click();
		  
}
}
