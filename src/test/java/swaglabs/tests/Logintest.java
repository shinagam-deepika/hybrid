package swaglabs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import deepika.swaglabs.Cartpage;
import swaglabs.base.Base;
import swaglabs.pages.Aboutpage;
import swaglabs.pages.Additemspage;
import swaglabs.pages.Backtohomepage;
import swaglabs.pages.HamburgerMenuPage;
import swaglabs.pages.Loginpage;
import swaglabs.pages.Logoutpage;
import swaglabs.pages.Orderconfirmationpage;
import swaglabs.pages.Productsortpage;
import swaglabs.pages.Removeitemspage;
import swaglabs.utils.ExcelUtil;
import swaglabs.utils.ExtentTestListener;
import swaglabs.utils.KeywordEngine;

@Listeners(ExtentTestListener.class)
public class Logintest extends Base { 

    static boolean loginSuccess = false;

    Loginpage lp;

    @Test(dataProvider="testcases")
    public void login(String username, String password) {

        if(loginSuccess) {
            return;
        }

        lp = new Loginpage(driver);

        System.out.println("Trying login with: " + username + " | " + password);

        lp.enterusername(username);
        lp.enterpassword(password);
        lp.clickloginbtn();

        if(lp.isLoginSuccess()) {

            System.out.println("Login Successful: " + username);
            loginSuccess = true;

        } else {

            System.out.println("Login Failed: " + username);
            driver.navigate().refresh();
        }
    }

    @DataProvider(name="testcases")
    public Object[][] getdata() {
        return ExcelUtil.getLoginData("Sheet1");
    }

    @Test(dataProvider = "keyworddata", dependsOnMethods = "login")
    public void executeSteps(String testCase,
                             String step,
                             String keyword,
                             String locatorType,
                             String locator,
                             String value) {

        if(!loginSuccess) {
            System.out.println("Skipping keyword execution because login failed");
            return;
        }

        KeywordEngine engine = new KeywordEngine(driver);

        System.out.println(
                testCase + " | " +
                step + " | " +
                keyword
        );

        engine.performAction(
                keyword,
                locatorType,
                locator,
                value
        );
    }

    @DataProvider(name = "keyworddata")
    public Object[][] getData() {

        return ExcelUtil.getKeywordData("Sheet2");
    }
    
    @Test(dependsOnMethods = "executeSteps")
	public void orderconfirmation() throws InterruptedException
	{
		Orderconfirmationpage ocp = new Orderconfirmationpage(driver);
		ocp.ordercnftext();
		Thread.sleep(2000);
		System.out.println("order placed");
	}
	
    @Test(dependsOnMethods = "orderconfirmation")
	public void backtohome() throws InterruptedException
	{
		Backtohomepage bhp = new Backtohomepage(driver);
		bhp.backhome();
		Thread.sleep(2000);
		System.out.println("back to home");
	}
	
    @Test(dependsOnMethods = "backtohome")
	public void addproducts() throws InterruptedException
	{
		Additemspage aip = new Additemspage(driver);
		aip.additems();
		Thread.sleep(2000);
		System.out.println("products addedd");
	}
    
	@Test(dependsOnMethods = "addproducts")
	public void addtocartbutton() throws InterruptedException
	{
		Cartpage cp = new Cartpage(driver);
		cp.crtpage();
		Thread.sleep(2000);
		System.out.println("cart page opened");
	}
	
    @Test(dependsOnMethods = "addtocartbutton")
	public void removeproducts() throws InterruptedException
	{
		Removeitemspage rip = new Removeitemspage(driver);
		rip.remitems();
		Thread.sleep(1000);
		System.out.println("products removed");
		Assert.assertEquals(rip.cartproductscount(), 1, "products are not removed correctly");
		driver.navigate().back();
		Thread.sleep(1000);
	}
	
    @Test(dependsOnMethods = "removeproducts")
	public void hamburgermenu() throws InterruptedException
	{
    	HamburgerMenuPage hm = new HamburgerMenuPage(driver);
    	hm.openMenu();
		Thread.sleep(1000);
	}
	
    @Test(dependsOnMethods = "hamburgermenu")
	public void aboutpage() throws InterruptedException
	{
		Aboutpage ap = new Aboutpage(driver);
		ap.about();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		System.out.println("navigated to back");
	}
	
    @Test(dependsOnMethods = "aboutpage")
	public void prodsorting() throws InterruptedException
	{
		Productsortpage psp = new Productsortpage(driver);
		psp.selectbyvisibletext("Price (high to low)");
		Thread.sleep(1000);
		psp.selectbyvalue("lohi");
		Thread.sleep(1000);
		psp.selectbyindex(1);
		Thread.sleep(1000);
		System.out.println("sorted successfully");
		hamburgermenu();
		
	} 
	
    @Test(dependsOnMethods = "prodsorting")
	public void logoutthepage() throws InterruptedException
	{
		Logoutpage lp = new Logoutpage(driver);
		lp.logout();
		Thread.sleep(1000);
		System.out.println("logout successfull");
	}
}