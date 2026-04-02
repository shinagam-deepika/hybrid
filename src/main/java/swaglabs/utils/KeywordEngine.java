package swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeywordEngine {

    WebDriver driver;
    AbstractUtil util;

    public KeywordEngine(WebDriver driver) {

        this.driver = driver;
        util = new AbstractUtil(driver);
    }

    private By getLocator(
            String locatorType,
            String locatorValue) {

        switch(locatorType.toLowerCase()) {

            case "id":
                return By.id(locatorValue);

            case "css":
                return By.cssSelector(locatorValue);

            case "xpath":
                return By.xpath(locatorValue);

            case "name":
                return By.name(locatorValue);

            case "class":
                return By.className(locatorValue);

            default:
                throw new RuntimeException("Invalid Locator Type");
        }
    }

    public void performAction(
            String keyword,
            String locatorType,
            String locatorValue,
            String data) {

        By locator = getLocator(locatorType, locatorValue);

        WebElement element =
                util.waitForElementPresent(locator);

        switch(keyword.toLowerCase()) {

            case "click":

                util.waitForElementClickable(element);
                element.click();
                break;

            case "type":

                util.waitForElementVisible(element);
                element.clear();
                element.sendKeys(data);
                break;

            case "addproduct":

                util.waitForElementClickable(element);
                element.click();
                break;

            case "clear":

                util.waitForElementVisible(element);
                element.clear();
                break;

            case "verifytext":

                util.waitForText(element, data);
                System.out.println("Text Verified: " + data);
                break;

            case "waitforurl":

                util.waitForURL(data);
                break;

            default:

                System.out.println("Keyword not supported: " + keyword);
        }

        util.waitForPageLoad();
    } 
}
