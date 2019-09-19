/**
 * 
 */
package com.davies.test.automation.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.davies.test.automation.data.UserLoginData;
import com.davies.test.automation.pages.UserLoginPage;

/**
 * @author Medamoni Swetha
 *
 */
public class UserLoginController {

	// Initialisation variable
	private WebDriver driver;
	private UserLoginPage pageObj;
	private UserLoginData dataObj;

	@BeforeMethod
	@Parameters({ "email", "password" })
	public void initializeData(String email, String password) throws InterruptedException {

		// 'email' & 'password' from suite file is sent to dataObj
		dataObj = new UserLoginData(email, password);

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/chrome-driver/chromedriver.exe");

		driver = new ChromeDriver();
		// Launch automationpractice site
		driver.get("http://automationpractice.com");
		Thread.sleep(10000);

		// Passing driver & data objects to UserLoginPage
		pageObj = new UserLoginPage(driver, dataObj);
	}

	@Test
	public void processValidateLoginWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLoginWithValidData(), true);
	}

	@Test
	public void processValidateLoginWithInvalidEmail() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLoginWithInvalidEmail(), true);
	}

	@Test
	public void processValidateLoginWithNonRegisteredEmail() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLoginWithNonRegisteredEmail(), true);
	}

	@Test
	public void processValidateLoginWithInvalidPassword() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLoginWithInvalidPassword(), true);
	}

	@Test
	public void processValidateForgotPasswordLink() throws InterruptedException {
		Assert.assertEquals(pageObj.validateForgotPasswordLink(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
