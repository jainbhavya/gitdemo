package multipletests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.loginObjects;
import resources.base;

public class dataprovider extends base {
	Logger log=LogManager.getLogger(dataprovider.class.getName());
	
	@Test
	public void browserstart() throws IOException {
		driver = initialisedriver();
		log.info("Browser has started");
		driver.get(prop.getProperty("url"));
		log.info("Navigated facebook");
		
        log.debug("opening website");
	}

	@Test
	public void initiallogin() throws InterruptedException {
		loginObjects lo = new loginObjects(driver);
		lo.getUsername().sendKeys("incorrect");
		lo.getPassword().sendKeys("incorrect");
		lo.getLogsubmit().submit();
		log.info("First Login");
		System.out.println("This is passed");
	}

	@Test
	public void hometest()
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div[3]/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div/ul/li/div/a/div[1]/div[2]/div/div/div/div/span/div")).sendKeys("ascasc");
		log.info("Home Textbox test");
	}
	
//	@DataProvider(name = "getDataFromProvider")
//	public static Object[][] fromDataProvider() throws InterruptedException {
//		Object[][] data = new Object[2][2];
//		// 0th row
//		data[0][0] = "nonrestricteduser@qw.com";
//		data[0][1] = "123456";
//		//Thread.sleep(20000);
//		// 1st row
//		data[1][0] = "******";
//		data[1][1] = "*******";
//
//		return data;
//	}
//
//	@Test(dataProvider = "getDataFromProvider")
//	public void loginuserdataprovider(String username, String password) throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
//		loginObjects l = new loginObjects(driver);
//		l.getUsername().sendKeys(username);
//		l.getPassword().sendKeys(password);
//		l.getLogsubmit().click();
//		Thread.sleep(20000);
//		l.getUsername().clear();
//		l.getPassword().clear();
//		Assert.assertTrue(true);
//	}

	@AfterTest
	public void finishtest() {
		driver.close();
		driver = null;
		log.debug("Finishing test");
	}

}
