package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
	
    public WebDriver driver;
	
	public Logoutpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="logout_sidebar_link")
	WebElement logoutbtn;
	
	public void logout()
	{
		logoutbtn.click();
	}
} 
