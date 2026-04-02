package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aboutpage { 
	
	public WebDriver driver;
	
	public Aboutpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="about_sidebar_link")
	WebElement aboutbtn;
	
	public void about() throws InterruptedException
	{
		aboutbtn.click();
	}
}
