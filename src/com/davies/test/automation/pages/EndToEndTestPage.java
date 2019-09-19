/**
 * 
 */
package com.davies.test.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.davies.test.automation.data.EndToEndTestData;

/**
 * This Page class does the following:- - Launches the site & clicks on 'Sign
 * In'. - Enters an email & clicks on 'Create an account' button. - Fills the
 * form, clicks on 'Register' button and checks if successfully registered or
 * not. If it is successfully, then it tries to 'Sign Out' - Again it clicks on
 * 'Sign In', enters into site with registered email & password . - Selects an
 * item, add to cart and validates the item whether it is the same as the one
 * added.
 * 
 * 
 * @author Medamoni Swetha
 */
public class EndToEndTestPage {

	private WebDriver driver;
	private EndToEndTestData dataObj;

	/**
	 * @param driver
	 * @param dataObj
	 */
	public EndToEndTestPage(WebDriver driver, EndToEndTestData dataObj) {
		this.driver = driver;
		this.dataObj = dataObj;
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean endToEndTestWithValidData() throws InterruptedException {

		// Click on 'Sign In' in webpage
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(5000);
		// Scroll web page to webelement-email to operate it
		WebElement email = driver.findElement(By.id("email_create"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);
		// Enter 'email' in webpage & click on 'Create an account' button.
		email.sendKeys(dataObj.getEmail());
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		// In the next page if the text 'Authentication' is not displayed then don't
		// proceed further.
		if (!driver.findElement(By.xpath("//span[contains(text(),'Authentication')]")).isDisplayed()) {
			return false;
		}
		// Choose Title based on the data that exists in dataObj
		if (dataObj.getTitle().equalsIgnoreCase("Mr")) {
			driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		}
		if (dataObj.getTitle().equalsIgnoreCase("Mrs")) {
			driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		}
		// Enter valid FirstName
		driver.findElement(By.id("customer_firstname")).sendKeys(dataObj.getFisrtName());
		// Enter valid LastName
		driver.findElement(By.id("customer_lastname")).sendKeys(dataObj.getLastName());
		// Enter valid Password
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(dataObj.getPassword());
		// Get Date from dataObj & split into days,months & years and select 'Date Of
		// Birth' field
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
		// Access the check box 'SignUp for our newsletter!'
		if (dataObj.getSignUpForNewLetter().equalsIgnoreCase("check")) {
			driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		}
		// Access the check box 'Receive special offers from our partners!'
		if (dataObj.getReceiveSpecialOffers().equalsIgnoreCase("check")) {
			driver.findElement(By.xpath("//input[@id='optin']")).click();
		}
		// Input text in the 'Company' field
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(dataObj.getCompany());
		// Input text in the 'Address' field
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(dataObj.getAddressFirstLine());
		// Input text in the 'Address(Line 2)' field
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(dataObj.getAddressSecondLine());
		// Input text in the 'City' field
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(dataObj.getCity());
		// Select 'State' from dropdown
		Select state = new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByVisibleText(dataObj.getState());
		// Input Postalcode in the text box
		driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(dataObj.getPostalCode());
		// Input text in the Additional information
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(dataObj.getAdditionalInfo());
		// Input number in the Home Phone field
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(dataObj.getHomePhone());
		// Input number in the Mobile Phone field
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(dataObj.getMobilePhone());
		driver.findElement(By.id("submitAccount")).click();
		Thread.sleep(5000);
		if (!(driver.findElement(By.xpath(
				"//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]"))
				.isDisplayed())) {
			return false;
		}
		// Sign Out
		driver.findElement(By.xpath("//a[@title='Log me out']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		// Scroll web page to webelement 'email'to operate it
		WebElement email1 = driver.findElement(By.id("email"));
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("arguments[0].scrollIntoView(true)", email1);
		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys(dataObj.getEmail());
		driver.findElement(By.id("passwd")).sendKeys(dataObj.getPassword());
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(5000);

		int OccuranceOfItem = 0;
		driver.findElement(By.xpath("//a[@title='Women']")).click();
		driver.findElement(By.linkText(dataObj.getProduct())).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//div[@id='layer_cart']/div/div/h2")).getText()
				.equalsIgnoreCase("Product successfully added to your shopping cart")) {
			driver.findElement(By.xpath("//span[@title='Close window']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='View my shopping cart']")).click();
			Thread.sleep(2000);

			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='cart_summary']//tbody//tr"));

			for (int i = 0; i < rows.size(); i++) {
				List<WebElement> col = rows.get(i).findElements(By.tagName("td"));
				// navigate to second coloumn and check for the text displayed

				if (col.get(1).getText().contains(dataObj.getProduct())) {
					OccuranceOfItem = OccuranceOfItem + 1;
				}
			}
		}
		if (OccuranceOfItem != 0) {
			return true;
		}
		return false;
	}
}
