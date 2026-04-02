package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglabs.utils.AbstractUtil;

public class HamburgerMenuPage {

    WebDriver driver;
    AbstractUtil util;

    public HamburgerMenuPage(WebDriver driver) {

        this.driver = driver;
        util = new AbstractUtil(driver);

        PageFactory.initElements(driver, this);
    } 

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBtn;

    public void openMenu() {

        util.waitForElementVisible(menuBtn);
        util.waitForElementClickable(menuBtn);

        menuBtn.click();

        util.waitForPageLoad();

        System.out.println("Hamburger menu opened");
    }
}
