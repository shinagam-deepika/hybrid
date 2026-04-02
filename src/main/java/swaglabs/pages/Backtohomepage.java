package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Backtohomepage {
	
	public WebDriver driver; 
	
	public Backtohomepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="back-to-products")
	WebElement backtohomebtn;
	
	public void backhome()
	{
		backtohomebtn.click();
	}
}
