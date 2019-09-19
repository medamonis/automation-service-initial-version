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

import com.davies.test.automation.data.AddToCartData;
import com.davies.test.automation.pages.AddToCartPage;

/**
 * @author Medamoni Swetha
 *
 */
public class AddToCartController {

	// Initialisation variable
	private WebDriver driver;
	private AddToCartPage pageObj;
	private AddToCartData dataObj;

	@BeforeMethod
	@Parameters({ "email", "password", "product" })
	public void initializeData(String email, String password, String product) throws InterruptedException {

		// 'email' & 'password' from suite file is sent to dataObj
		dataObj = new AddToCartData(email, password, product);

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/chrome-driver/chromedriver.exe");

		driver = new ChromeDriver();
		// Launch automationpractice site
		driver.get("http://automationpractice.com");
		Thread.sleep(10000);

		// Passing driver & data objects to UserLoginPage
		pageObj = new AddToCartPage(driver, dataObj);
	}

	@Test
	public void processValidateAddToCart() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddToCart(), true);
	}

	@AfterMethod
	public void browserClose() {
		driver.close();
	}
}
