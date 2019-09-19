/**
 * 
 */
package com.davies.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.davies.test.automation.data.CreateAccountData;

/**
 * @author Medamoni Swetha
 *
 */
public class CreateAccountPage {

	private WebDriver driver;
	private CreateAccountData dataObj;

	// Locate Elements
	private By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	private By emailField = By.id("email_create");
	private By createAnAccount = By.id("SubmitCreate");

	public CreateAccountPage(WebDriver driver, CreateAccountData dataObj) {
		this.driver = driver;
		this.dataObj = dataObj;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailValidData() throws InterruptedException {
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

		// In the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//span[contains(text(),'Authentication')]")).isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailUppercaseData() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//span[contains(text(),'Authentication')]")).isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailIncorrectFormat() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//div[@id='create_account_error']")).getText()
				.contains("Invalid email address")) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailWithSpaces() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//div[@id='create_account_error']")).getText()
				.contains("Invalid email address")) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailEmptyString() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//div[@id='create_account_error']")).getText()
				.contains("Invalid email address")) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailExistingData() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).getText()
				.contains("An account using this email address has already been registered")) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailSpecialSymbols() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//div[@id='create_account_error']")).getText()
				.contains("Invalid email address")) {
			return true;
		}
		return false;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateEmailNumerics() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(3000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(createAnAccount).click();
		Thread.sleep(5000);

		// If in the next page if the text 'Authentication' is displayed then the test
		// case is passed
		if (driver.findElement(By.xpath("//span[contains(text(),'Authentication')]")).isDisplayed()) {
			return true;
		}
		return false;
	}
}
