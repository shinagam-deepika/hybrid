package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Additemspage { 
	
	public WebDriver driver;
	
	public Additemspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement bag;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement light;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement jacket;
	
	public void additems()
	{
		bag.click();
		light.click();
		jacket.click();
	}
}
