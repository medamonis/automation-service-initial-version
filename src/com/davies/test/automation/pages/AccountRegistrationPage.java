/**
 * 
 */
package com.davies.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.davies.test.automation.data.AccountRegistrationData;

/**
 * @author Medamoni Swetha
 *
 */
public class AccountRegistrationPage {

	private WebDriver driver;
	private AccountRegistrationData dataObj;

	// Locate Elements
	private By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	private By emailField = By.id("email_create");
	private By createAnAccount = By.id("SubmitCreate");

	/**
	 * @param driver
	 * @param dataObj
	 */
	public AccountRegistrationPage(WebDriver driver, AccountRegistrationData dataObj) {
		this.driver = driver;
		this.dataObj = dataObj;
	}

	/**
	 * @throws InterruptedException
	 */
	private void navigateToCreateAnAccountForm() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(5000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);
	}

	// Automate First Name Field
	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateFirstNameValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		// Choose Title & Enter valid FirstName
		if (dataObj.getTitle().equalsIgnoreCase("Mr")) {
			driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		}
		if (dataObj.getTitle().equalsIgnoreCase("Mrs")) {
			driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		}

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateFirstNameWithSpecialCharacters() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateFirstNameWithOnlyNumerics() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateFirstNameWithAlphaNumeric() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid"));
	}

	public boolean validateFirstNameWithBlankData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is required"));
	}

	public boolean validateFirstNameWithOnlySpaces() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid")));
	}

//Automate Last Name Field

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLastNameValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLastNameWithSpecialCharacters() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLastNameWithOnlyNumerics() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLastNameWithAlphaNumeric() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLastNameWithBlankData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is required"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateLastNameWithOnlySpaces() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid")));

	}

	/**
	 * Automate Email Field
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmail() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		// Check for the email populated is same as the email with which user has
		// entered
		return (driver.findElement(By.xpath("//input[@id='email']")).getAttribute("value").equals(dataObj.getEmail()));
	}

	/**
	 * Automate Password Field
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePasswordValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataObj.getPassword());
		driver.findElement(By.id("submitAccount")).click();

		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("password")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePasswordInvalidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataObj.getPassword());
		driver.findElement(By.id("submitAccount")).click();

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("passwd is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePasswordBlankData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataObj.getPassword());
		driver.findElement(By.id("submitAccount")).click();

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("passwd is required")));
	}

	/**
	 * Validate 'First Name' field under 'Your Address'
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameAutoPopulate() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(dataObj.getFisrtName());

		return (driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value")
				.equals(dataObj.getFisrtName()));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameEditableData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(dataObj.getFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(dataObj.getAddressFisrtName());
		Thread.sleep(5000);

		return ((driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value")
				.equals(dataObj.getAddressFisrtName()))
				&& (driver.findElement(By.xpath("//input[@id='customer_firstname']")).getAttribute("value")
						.equals(dataObj.getFisrtName())));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameOverwrittenData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(dataObj.getFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(dataObj.getAddressFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@id='customer_firstname']"))
				.sendKeys("Edit FirstName again to overwrite data in addressFirstName Field");
		Thread.sleep(5000);

		return (driver.findElement(By.xpath("//input[@id='firstname']")).getAttribute("value")
				.equals("Edit FirstName again to overwrite data in addressFirstName Field"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameWithSpecialCharacters() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(dataObj.getFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(dataObj.getAddressFisrtName());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameWithOnlyNumerics() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(dataObj.getAddressFisrtName());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameWithAlphaNumeric() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(dataObj.getAddressFisrtName());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid"));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameWithBlankData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(dataObj.getAddressFisrtName());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is required"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressFirstNameWithOnlySpaces() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.id("submitAccount")).click();

		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("firstname is invalid")));
	}

	/**
	 * Validate 'Last Name' field under 'Your Address'
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameAutoPopulate() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(dataObj.getLastName());

		return (driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value")
				.equals(dataObj.getLastName()));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameEditableData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(dataObj.getLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(dataObj.getAddressLastName());
		Thread.sleep(5000);

		return ((driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value")
				.equals(dataObj.getAddressLastName()))
				&& (driver.findElement(By.xpath("//input[@id='customer_lastname']")).getAttribute("value")
						.equals(dataObj.getLastName())));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameOverwrittenData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(dataObj.getLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(dataObj.getAddressLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.findElement(By.xpath("//input[@id='customer_lastname']"))
				.sendKeys("Edit lastname again to overwrite data in addressLastName Field");
		Thread.sleep(5000);

		return (driver.findElement(By.xpath("//input[@id='lastname']")).getAttribute("value")
				.equals("Edit lastname again to overwrite data in addressLastName Field"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameWithSpecialCharacters() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(dataObj.getLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(dataObj.getAddressLastName());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameWithOnlyNumerics() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(dataObj.getAddressLastName());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameWithAlphaNumeric() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(dataObj.getAddressLastName());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid"));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameWithBlankData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(dataObj.getAddressLastName());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);

		return (driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is required"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLastNameWithOnlySpaces() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		driver.findElement(By.id("submitAccount")).click();

		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("lastname is invalid")));
	}

	/**
	 * Validate 'Address' field under 'Your Address'
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressWithValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(dataObj.getAddressFirstLine());
		driver.findElement(By.id("submitAccount")).click();

		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("address1")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressWithoutData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(dataObj.getAddressFirstLine());
		driver.findElement(By.id("submitAccount")).click();

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("address1 is required.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressLengthyData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(dataObj.getAddressFirstLine());
		driver.findElement(By.id("submitAccount")).click();

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("address1 is too long. Maximum length: 128")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressInvalidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(dataObj.getAddressFirstLine());
		Thread.sleep(3000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("address1 is invalid.")));
	}

	/**
	 * Validate 'City' field under 'Your Address'
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCityWithValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(dataObj.getCity());
		driver.findElement(By.id("submitAccount")).click();

		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("city")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCityWithoutData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(dataObj.getCity());
		driver.findElement(By.id("submitAccount")).click();

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("city is required.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCityLengthyData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(dataObj.getCity());
		driver.findElement(By.id("submitAccount")).click();

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("city is too long. Maximum length: 64")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCityInvalidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(dataObj.getCity());
		Thread.sleep(3000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);

		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("city is invalid.")));
	}

	// Validate 'State' field under 'Your Address'

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateStateSelectingOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		s.selectByVisibleText(dataObj.getState());

		driver.findElement(By.id("submitAccount")).click();

		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("state")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateStateWithoutSelectingOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		s.selectByVisibleText(dataObj.getState());
		Thread.sleep(3000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("This country requires you to choose a State.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateStateSelectingNonexistingOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		try {
			Select s = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
			s.selectByVisibleText(dataObj.getState());
			Thread.sleep(3000);
			driver.findElement(By.id("submitAccount")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			return true;
		}
		return false;

	}

	// Validate 'PostalCode' field under 'Your Address'

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePostalCodeWithValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePostalCodeWithoutData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePostalCodeWithSpaces() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePostalCodeWithAlphanumerics() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePostalCodeWithLessDigits() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validatePostalCodeWithMoreDigits() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000")));
	}

	// Validate 'Country' dropdown under 'Your Address'

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCountryDefaultOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		return (s.getFirstSelectedOption().getText().equals("United States"));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCountryValidOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		s.selectByVisibleText(dataObj.getCountry());
		Thread.sleep(3000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("Country is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCountryInvalidOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		s.selectByVisibleText(dataObj.getCountry());
		Thread.sleep(3000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(3000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("Country is invalid")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateCountryNonExistingOption() throws InterruptedException {
		this.navigateToCreateAnAccountForm();

		try {
			Select s = new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
			s.selectByVisibleText(dataObj.getCountry());
			Thread.sleep(3000);
			driver.findElement(By.id("submitAccount")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			return true;
		}
		return false;

	}

	// Validate 'Mobile Phone' field under 'Your Address'

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateMobilePhoneWithValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("phone_mobile")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateMobilePhoneAndHomePhoneWithoutData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(dataObj.getHomePhone());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("You must register at least one phone number.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateMobilePhoneWithoutDataAndHomePhoneWithData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(dataObj.getHomePhone());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("You must register at least one phone number.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateMobilePhoneWithLenghtyData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("phone_mobile is too long. Maximum length: 32")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateMobilePhoneWithAlphaNumeric() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("phone_mobile is invalid.")));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateMobilePhoneWithSpecialCharacters() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		Thread.sleep(2000);
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(2000);
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("phone_mobile is invalid.")));
	}

	// Validate 'Address Alias' field under 'Your Address'

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasDefaultValue() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		return (driver.findElement(By.xpath("//input[@id='alias']")).getAttribute("value").equals("My address"));
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithDefaultData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		if (driver.findElement(By.xpath("//input[@id='alias']")).getAttribute("value").equals("My address")) {
			driver.findElement(By.id("submitAccount")).click();
			return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("alias")));

		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithEdittedData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("alias")));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithoutData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("alias is required")));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithLengthyData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return ((driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("alias is too long. Maximum length: 32")));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithWithOnlySpaces() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText()
				.contains("alias is required")));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithSpecialCharacters() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("alias")));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithAlphaNumerics() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("alias")));

	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddressAliasWithOnlyNumbers() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(dataObj.getAddressAlias());
		driver.findElement(By.id("submitAccount")).click();
		return (!(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText().contains("alias")));

	}

	// Complete Registration check with data in all the fields

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateRegistrationWithValidData() throws InterruptedException {
		this.navigateToCreateAnAccountForm();
		if (dataObj.getTitle().equalsIgnoreCase("Mr")) {
			driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
		}
		if (dataObj.getTitle().equalsIgnoreCase("Mrs")) {
			driver.findElement(By.xpath("//label[@for='id_gender2']")).click();
		}

		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(dataObj.getFisrtName());
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(dataObj.getLastName());
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataObj.getPassword());
		String date[] = dataObj.getDate().split("-");

		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue(date[0]);
		Thread.sleep(2000);

		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByValue(date[1]);
		Thread.sleep(2000);

		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByValue(date[2]);
		Thread.sleep(2000);

		if (dataObj.getSignUpForNewLetter().equalsIgnoreCase("check")) {
			driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		}

		if (dataObj.getReceiveSpecialOffers().equalsIgnoreCase("check")) {
			driver.findElement(By.xpath("//input[@id='optin']")).click();
		}

		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(dataObj.getCompany());
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(dataObj.getAddressFirstLine());
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(dataObj.getAddressSecondLine());
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(dataObj.getCity());
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByVisibleText(dataObj.getState());
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(dataObj.getAdditionalInfo());
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(dataObj.getHomePhone());
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(5000);
		return (driver.findElement(By.xpath(
				"//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]"))
				.isDisplayed());
	}

}
