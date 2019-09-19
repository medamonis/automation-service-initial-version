/**
 * 
 */
package com.davies.test.automation.controllers;

import static com.davies.test.automation.util.TestUtils.generateUniqueEmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.davies.test.automation.data.CreateAccountData;
import com.davies.test.automation.pages.CreateAccountPage;

/**
 * @author Medamoni Swetha
 *
 */
public class CreateAccountController {

	// Initialisation variable
	private WebDriver driver;
	private CreateAccountPage pageObj;
	private CreateAccountData dataObj;

	@BeforeMethod
	@Parameters({ "email", "isNewEmailRequired" })
	public void initializeData(String email, String isNewEmailRequired) throws InterruptedException {

		// The 'email' from suite file is converted as 'unique email' & kept in
		// CreateAccountData class object
		String generatedEmail = generateUniqueEmail(email, isNewEmailRequired);
		dataObj = new CreateAccountData(generatedEmail);

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/chrome-driver/chromedriver.exe");

		driver = new ChromeDriver();
		// Launch automationpractice site
		driver.get("http://automationpractice.com");
		Thread.sleep(10000);

		// Pass driver & data objects to CreateAccountPage
		pageObj = new CreateAccountPage(driver, dataObj);
	}

	@Test
	public void processValidateEmailValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailValidData(), true);
	}

	@Test
	public void processValidateEmailUppercaseData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailUppercaseData(), true);
	}

	@Test
	public void processValidateEmailIncorrectFormat() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailIncorrectFormat(), true);
	}

	@Test
	public void processValidateEmailWithSpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailWithSpaces(), true);
	}

	@Test
	public void processValidateEmailEmptyString() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailEmptyString(), true);
	}

	@Test
	public void processValidateEmailExistingData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailExistingData(), true);
	}

	@Test
	public void processValidateEmailSpecialSymbols() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailSpecialSymbols(), true);
	}

	@Test
	public void processValidateEmailNumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmailNumerics(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
