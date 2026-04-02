package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	
	public WebDriver driver;
	
	public Cartpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".shopping_cart_link")
	WebElement cartpage;
	
	public void crtpage()
	{
		cartpage.click();
	} 
}
