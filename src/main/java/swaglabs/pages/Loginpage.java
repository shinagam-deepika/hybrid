package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage{

    public WebDriver driver;

    public Loginpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    } 

    @FindBy(id="user-name")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginbtn;

    @FindBy(id="inventory_container")
    WebElement inventoryPage;

    public void enterusername(String uname)
    {
    	username.clear();
        username.sendKeys(uname);
    }

    public void enterpassword(String pass)
    {
    	password.clear();
        password.sendKeys(pass);
    }

    public void clickloginbtn()
    {
        loginbtn.click();
    }

    public boolean isLoginSuccess()
    {
        return driver.getCurrentUrl().contains("inventory");
    }
}
