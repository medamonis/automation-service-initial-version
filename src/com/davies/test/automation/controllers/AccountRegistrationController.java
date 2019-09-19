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

import com.davies.test.automation.data.AccountRegistrationData;
import com.davies.test.automation.pages.AccountRegistrationPage;

/**
 * @author Medamoni Swetha
 *
 */
public class AccountRegistrationController {

	// Initialisation variable
	private WebDriver driver;
	private AccountRegistrationPage pageObj;
	private AccountRegistrationData dataObj;

	@BeforeMethod
	@Parameters({ "isNewEmailRequired", "title", "fisrtName", "lastName", "email", "password", "date",
			"signUpForNewLetter", "receiveSpecialOffers", "addressFisrtName", "addressLastName", "company",
			"addressFirstLine", "addressSecondLine", "city", "State", "postalCode", "Country", "AdditionalInfo",
			"homePhone", "mobilePhone", "addressAlias" })
	public void initializeData(String isNewEmailRequired, String title, String fisrtName, String lastName, String email,
			String password, String date, String signUpForNewLetter, String receiveSpecialOffers,
			String addressFisrtName, String addressLastName, String company, String addressFirstLine,
			String addressSecondLine, String city, String State, String postalCode, String Country,
			String AdditionalInfo, String homePhone, String mobilePhone, String addressAlias)
			throws InterruptedException {

		// The 'email' from suite file is converted as 'unique email' & kept in
		// CreateAccountData class object
		String generatedEmail = generateUniqueEmail(email, isNewEmailRequired);

		// Pass all the data from suite file to dataObj
		dataObj = new AccountRegistrationData(title, fisrtName, lastName, generatedEmail, password, date,
				signUpForNewLetter, receiveSpecialOffers, addressFisrtName, addressLastName, company, addressFirstLine,
				addressSecondLine, city, State, postalCode, Country, AdditionalInfo, homePhone, mobilePhone,
				addressAlias);

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/chrome-driver/chromedriver.exe");

		driver = new ChromeDriver();
		// Launch automationpractice site
		driver.get("http://automationpractice.com");
		Thread.sleep(10000);

		// Pass driver & data objects to CreateAccountPage
		pageObj = new AccountRegistrationPage(driver, dataObj);
	}

	// Validations for First Name Field

	@Test
	public void processValidateFirstNameValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateFirstNameValidData(), true);
	}

	@Test
	public void processValidateFirstNameWithSpecialCharacters() throws InterruptedException {
		Assert.assertEquals(pageObj.validateFirstNameWithSpecialCharacters(), true);
	}

	@Test
	public void processValidateFirstNameWithOnlyNumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validateFirstNameWithOnlyNumerics(), true);
	}

	@Test
	public void processValidateFirstNameWithAlphaNumeric() throws InterruptedException {
		Assert.assertEquals(pageObj.validateFirstNameWithAlphaNumeric(), true);
	}

	@Test
	public void processValidateFirstNameWithBlankData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateFirstNameWithBlankData(), true);
	}

	@Test
	public void processValidateFirstNameWithOnlySpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validateFirstNameWithOnlySpaces(), true);
	}

	// Validations for Last Name Field

	@Test
	public void processValidateLastNameValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLastNameValidData(), true);
	}

	@Test
	public void processValidateLastNameWithSpecialCharacters() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLastNameWithSpecialCharacters(), true);
	}

	@Test
	public void processValidateLastNameWithOnlyNumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLastNameWithOnlyNumerics(), true);
	}

	@Test
	public void processValidateLastNameWithAlphaNumeric() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLastNameWithAlphaNumeric(), true);
	}

	@Test
	public void processValidateLastNameWithBlankData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLastNameWithBlankData(), true);
	}

	@Test
	public void processValidateLastNameWithOnlySpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validateLastNameWithOnlySpaces(), true);
	}

	// Validations for Email Field
	@Test
	public void processValidateEmail() throws InterruptedException {
		Assert.assertEquals(pageObj.validateEmail(), true);
	}

	// Validations for Password Field
	@Test
	public void processValidatePasswordValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePasswordValidData(), true);
	}

	@Test
	public void processValidatePasswordInvalidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePasswordInvalidData(), true);
	}

	@Test
	public void processValidatePasswordBlankData() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePasswordBlankData(), true);
	}

	// Validate 'First name' field under 'Your Address'
	@Test
	public void processValidateAddressFirstNameAutoPopulate() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameAutoPopulate(), true);
	}

	@Test
	public void processValidateAddressFirstNameEditableData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameEditableData(), true);
	}

	@Test
	public void processValidateAddressFirstNameOverwrittenData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameOverwrittenData(), true);
	}

	@Test
	public void processValidateAddressFirstNameWithSpecialCharacters() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameWithSpecialCharacters(), true);
	}

	@Test
	public void processValidateAddressFirstNameWithOnlyNumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameWithOnlyNumerics(), true);
	}

	@Test
	public void processValidateAddressFirstNameWithAlphaNumeric() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameWithAlphaNumeric(), true);
	}

	@Test
	public void processValidateAddressFirstNameWithBlankData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameWithBlankData(), true);
	}

	@Test
	public void processValidateAddressFirstNameWithOnlySpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressFirstNameWithOnlySpaces(), true);
	}

	// Validate 'Last name' field under 'Your Address'
	@Test
	public void processValidateAddressLastNameAutoPopulate() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameAutoPopulate(), true);
	}

	@Test
	public void processValidateAddressLastNameEditableData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameEditableData(), true);
	}

	@Test
	public void processValidateAddressLastNameOverwrittenData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameOverwrittenData(), true);
	}

	@Test
	public void processValidateAddressLastNameWithSpecialCharacters() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameWithSpecialCharacters(), true);
	}

	@Test
	public void processValidateAddressLastNameWithOnlyNumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameWithOnlyNumerics(), true);
	}

	@Test
	public void processValidateAddressLastNameWithAlphaNumeric() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameWithAlphaNumeric(), true);
	}

	@Test
	public void processValidateAddressLastNameWithBlankData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameWithBlankData(), true);
	}

	@Test
	public void processValidateAddressLastNameWithOnlySpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLastNameWithOnlySpaces(), true);
	}

	// Validate 'Address' field under 'Your Address'

	@Test
	public void processValidateAddressWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressWithValidData(), true);
	}

	@Test
	public void processValidateAddressWithoutData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressWithoutData(), true);
	}

	@Test
	public void processValidateAddressLengthyData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressLengthyData(), true);
	}

	@Test
	public void processValidateAddressInvalidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressInvalidData(), true);
	}

	// Validate 'City' field under 'Your Address'

	@Test
	public void processValidateCityWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCityWithValidData(), true);
	}

	@Test
	public void processValidateCityWithoutData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCityWithoutData(), true);
	}

	@Test
	public void processValidateCityLengthyData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCityLengthyData(), true);
	}

	@Test
	public void processValidateCityInvalidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCityInvalidData(), true);
	}

	// Validate 'State' field under 'Your Address'

	@Test
	public void processValidateStateSelectingOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateStateSelectingOption(), true);
	}

	@Test
	public void processValidateStateWithoutSelectingOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateStateWithoutSelectingOption(), true);
	}

	@Test
	public void processValidateStateSelectingNonexistingOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateStateSelectingNonexistingOption(), true);
	}

	// Validate 'PostalCode' field under 'Your Address'

	@Test
	public void processValidatePostalCodeWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePostalCodeWithValidData(), true);
	}

	@Test
	public void processValidatePostalCodeWithoutData() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePostalCodeWithoutData(), true);
	}

	@Test
	public void processValidatePostalCodeWithSpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePostalCodeWithSpaces(), true);
	}

	@Test
	public void processValidatePostalCodeWithAlphanumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePostalCodeWithAlphanumerics(), true);
	}

	@Test
	public void processValidatePostalCodeWithLessDigits() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePostalCodeWithLessDigits(), true);
	}

	@Test
	public void processValidatePostalCodeWithMoreDigits() throws InterruptedException {
		Assert.assertEquals(pageObj.validatePostalCodeWithMoreDigits(), true);
	}

	// Validate 'Country' dropdown under 'Your Address'

	@Test
	public void processValidateCountryDefaultOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCountryDefaultOption(), true);
	}

	@Test
	public void processValidateCountryValidOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCountryValidOption(), true);
	}

	@Test
	public void processValidateCountryInvalidOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCountryInvalidOption(), true);
	}

	@Test
	public void processValidateCountryNonExistingOption() throws InterruptedException {
		Assert.assertEquals(pageObj.validateCountryNonExistingOption(), true);
	}

	// Validate 'Mobile Phone' field under 'Your Address'

	@Test
	public void processValidateMobilePhoneWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateMobilePhoneWithValidData(), true);
	}

	@Test
	public void processValidateMobilePhoneAndHomePhoneWithoutData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateMobilePhoneAndHomePhoneWithoutData(), true);
	}

	@Test
	public void processValidateMobilePhoneWithoutDataAndHomePhoneWithData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateMobilePhoneWithoutDataAndHomePhoneWithData(), true);
	}

	@Test
	public void processValidateMobilePhoneWithLenghtyData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateMobilePhoneWithLenghtyData(), true);
	}

	@Test
	public void processValidateMobilePhoneWithAlphaNumeric() throws InterruptedException {
		Assert.assertEquals(pageObj.validateMobilePhoneWithAlphaNumeric(), true);
	}

	@Test
	public void processValidateMobilePhoneWithSpecialCharacters() throws InterruptedException {
		Assert.assertEquals(pageObj.validateMobilePhoneWithSpecialCharacters(), true);
	}

	// Validate 'Address Alias' field under 'Your Address'

	@Test
	public void processValidateAddressAliasDefaultValue() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasDefaultValue(), true);
	}

	@Test
	public void processValidateAddressAliasWithDefaultData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithDefaultData(), true);
	}

	@Test
	public void processValidateAddressAliasWithEdittedData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithEdittedData(), true);
	}

	@Test
	public void processValidateAddressAliasWithoutData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithoutData(), true);
	}

	@Test
	public void processValidateAddressAliasWithLengthyData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithLengthyData(), true);
	}

	@Test
	public void processValidateAddressAliasWithOnlySpaces() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithWithOnlySpaces(), true);
	}

	@Test
	public void processValidateAddressAliasWithSpecialCharacters() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithSpecialCharacters(), true);
	}

	@Test
	public void processValidateAddressAliasWithAlphaNumerics() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithAlphaNumerics(), true);
	}

	@Test
	public void processValidateAddressAliasWithOnlyNumbers() throws InterruptedException {
		Assert.assertEquals(pageObj.validateAddressAliasWithOnlyNumbers(), true);
	}

	// Validate 'Registration Form' with all valid data
	@Test
	public void processValidateRegistrationWithValidData() throws InterruptedException {
		Assert.assertEquals(pageObj.validateRegistrationWithValidData(), true);
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
