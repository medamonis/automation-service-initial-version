/**
 * 
 */
package com.davies.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.davies.test.automation.data.UserLoginData;

/**
 * @author Medamoni Swetha
 *
 */
public class UserLoginPage {

	private WebDriver driver;
	private UserLoginData dataObj;

	// Locate Elements
	private By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	private By emailField = By.id("email");
	private By password = By.id("passwd");
	private By login = By.id("SubmitLogin");
	private By Forgotpassword = By.xpath("//a[contains(text(),'Forgot your password?')]");

	/**
	 * @param driver
	 * @param dataObj
	 */
	public UserLoginPage(WebDriver driver, UserLoginData dataObj) {
		this.driver = driver;
		this.dataObj = dataObj;
	}

	/**
	 * @throws InterruptedException
	 */
	private void navigateToAlreadyRegisteredField() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(5000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLoginWithValidData() throws InterruptedException {
		this.navigateToAlreadyRegisteredField();
		driver.findElement(emailField).sendKeys(dataObj.getEmail());
		driver.findElement(password).sendKeys(dataObj.getPassword());
		driver.findElement(login).click();
		Thread.sleep(5000);
		return (driver.findElement(By.xpath(
				"//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]"))
				.isDisplayed());
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLoginWithInvalidEmail() throws InterruptedException {
		this.navigateToAlreadyRegisteredField();
		driver.findElement(emailField).sendKeys(dataObj.getEmail());
		driver.findElement(password).sendKeys(dataObj.getPassword());
		driver.findElement(login).click();
		Thread.sleep(5000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("Invalid email address.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLoginWithNonRegisteredEmail() throws InterruptedException {
		this.navigateToAlreadyRegisteredField();
		driver.findElement(emailField).sendKeys(dataObj.getEmail());
		driver.findElement(password).sendKeys(dataObj.getPassword());
		driver.findElement(login).click();
		Thread.sleep(5000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("Authentication failed")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLoginWithInvalidPassword() throws InterruptedException {
		this.navigateToAlreadyRegisteredField();
		driver.findElement(emailField).sendKeys(dataObj.getEmail());
		driver.findElement(password).sendKeys(dataObj.getPassword());
		driver.findElement(login).click();
		Thread.sleep(5000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("Authentication failed")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateForgotPasswordLink() throws InterruptedException {
		this.navigateToAlreadyRegisteredField();
		driver.findElement(Forgotpassword).click();
		Thread.sleep(5000);
		return (driver.findElement(By.xpath("//span[contains(text(),'Retrieve Password')]")).isDisplayed());
	}
}
