package swaglabs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Removeitemspage {
	
	public WebDriver driver;
	
	public Removeitemspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="remove-sauce-labs-fleece-jacket")
	WebElement remjacket;
	
	@FindBy(id="remove-sauce-labs-bike-light")
	WebElement remlight;
	
	@FindBy(css=".shopping_cart_link")
	List<WebElement> cartitems;
	
	public void remitems()
	{
		remjacket.click();
		remlight.click();
	}
	
	public int cartproductscount()
	{
		return cartitems.size();
	} 
}
