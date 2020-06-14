package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialisedriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Vikram Jain\\eclipse-workspace\\Fuckbook\\src\\main\\java\\resources\\data.properties");
		prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		System.out.println("Url is "+url);
		System.out.println("browser is "+ browser);
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			/*System.getProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver=new ChromeDriver();*/
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			/*System.getProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver=new InternetExplorerDriver();*/
		}
		
		return driver;
	}

	public void getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		//To be saved in computer
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testCaseName + ".png";
		FileUtils.copyFile(source,new File(destinationfile));
	}
}
