package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orderconfirmationpage {
	
	public WebDriver driver;
	
	public Orderconfirmationpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".complete-header")
	WebElement ordercnfmsg;
	
	public void ordercnftext()
	{
		String text=ordercnfmsg.getText();
		System.out.println(text);
	}  
}
