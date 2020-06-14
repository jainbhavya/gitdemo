package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginObjects {
	public WebDriver driver;

	By username = By.xpath("//*[@id=\"email\"]");
	By password = By.xpath("//*[@id=\"pass\"]");
	By logsubmit = By.xpath("//*[@id=\"loginbutton\"]");

	public loginObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogsubmit() {
		return driver.findElement(logsubmit);
	}

}
