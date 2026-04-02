package swaglabs.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractUtil {
	
	public WebDriver driver;
	public WebDriverWait wait;
	 
	public AbstractUtil(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// wait for element visible
    public WebElement waitForElementVisible(WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    // wait for element clickable
    public WebElement waitForElementClickable(WebElement element) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }

    // wait for element present
    public WebElement waitForElementPresent(By locator) {

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(locator));
    }

    // wait for page load
    public void waitForPageLoad() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        wait.until(webDriver ->
                js.executeScript(
                        "return document.readyState"
                ).equals("complete"));
    }

    // wait for URL
    public void waitForURL(String url) {

        wait.until(
                ExpectedConditions.urlContains(url));
    }

    // wait for text
    public void waitForText(WebElement element, String text) {

        wait.until(
                ExpectedConditions.textToBePresentInElement(element, text));
    }  
}
