/**
 * 
 */
package com.davies.test.automation.controllers;

import static com.davies.test.automation.util.TestUtils.generateUniqueEmail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.davies.test.automation.data.EndToEndTestData;
import com.davies.test.automation.pages.EndToEndTestPage;

/**
 * @author Medamoni Swetha 'Controller' class gets the data from 'Suite' file
 *         and passes the data to 'Data' class. Also 'Controller' class passes
 *         the dataObj and driver objects to 'Pages' class. 'Controller'
 *         launches the site, calls the 'Page' class method (which has Selenium
 *         code for automation) & closes the browser.
 */
public class EndToEndTestController {

	// Initialisation of variables
	private WebDriver driver;
	private EndToEndTestPage pageObj;
	private EndToEndTestData dataObj;

	@BeforeMethod
	@Parameters({ "isNewEmailRequired", "title", "fisrtName", "lastName", "email", "password", "date",
			"signUpForNewLetter", "receiveSpecialOffers", "addressFisrtName", "addressLastName", "company",
			"addressFirstLine", "addressSecondLine", "city", "State", "postalCode", "Country", "AdditionalInfo",
			"homePhone", "mobilePhone", "addressAlias", "product" })
	public void initializeData(String isNewEmailRequired, String title, String fisrtName, String lastName, String email,
			String password, String date, String signUpForNewLetter, String receiveSpecialOffers,
			String addressFisrtName, String addressLastName, String company, String addressFirstLine,
			String addressSecondLine, String city, String State, String postalCode, String Country,
			String AdditionalInfo, String homePhone, String mobilePhone, String addressAlias, String product)
			throws InterruptedException {

		// The 'email' from suite file is converted as 'unique email' & kept in dataObj
		String generatedEmail = generateUniqueEmail(email, isNewEmailRequired);
		System.out.println("The email will be registered is " + generatedEmail + ", password: " + password);

		// Pass all the data from suite file to dataObj
		dataObj = new EndToEndTestData(title, fisrtName, lastName, generatedEmail, password, date, signUpForNewLetter,
				receiveSpecialOffers, addressFisrtName, addressLastName, company, addressFirstLine, addressSecondLine,
				city, State, postalCode, Country, AdditionalInfo, homePhone, mobilePhone, addressAlias, product);

		// To test the site on Chrome browser
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/chrome-driver/chromedriver.exe");
		driver = new ChromeDriver();

		// Launch automationpractice site
		driver.get("http://automationpractice.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Pass driver & data objects to Page class
		pageObj = new EndToEndTestPage(driver, dataObj);
	}

	@Test
	public void processEndToEndTestWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.endToEndTestWithValidData(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
