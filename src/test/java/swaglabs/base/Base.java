package swaglabs.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    public WebDriver driver;
    public Properties prop;
    @BeforeClass
    public void setup() throws IOException {
    	

        prop = new Properties();
        FileInputStream fis = new FileInputStream(
            System.getProperty("user.dir") +
            "/src/main/java/resources/config.properties"
        );

        prop.load(fis);

        String browsername = prop.getProperty("browser");

        if (browsername.equalsIgnoreCase("Chrome")) {

            driver = new ChromeDriver();

        } else if (browsername.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browsername.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        }else {
        	
            throw new RuntimeException("Browser not supported");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    } 
}
