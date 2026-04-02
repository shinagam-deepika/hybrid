package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Productsortpage {
	
	public WebDriver driver;
	
	public Productsortpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".product_sort_container")
	WebElement dropdown;
	
	public void selectbyvisibletext(String optiontext)
	{
		Select select = new Select(dropdown);
		select.selectByVisibleText(optiontext);
	}
	
	public void selectbyvalue(String optionvalue)
	{
		Select select = new Select(dropdown);
		select.selectByValue(optionvalue);
	}
	
	public void selectbyindex(int index)
	{
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	} 
}
