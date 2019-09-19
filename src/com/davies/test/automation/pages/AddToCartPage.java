/**
 * 
 */
package com.davies.test.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.davies.test.automation.data.AddToCartData;

/**
 * @author Medamoni Swetha
 *
 */
public class AddToCartPage {

	private WebDriver driver;
	private AddToCartData dataObj;

	// Locate Elements
	private By signIn = By.xpath("//a[contains(text(),'Sign in')]");
	private By emailField = By.id("email");
	private By password = By.id("passwd");
	private By login = By.id("SubmitLogin");

	/**
	 * @param driver
	 * @param dataObj
	 */
	public AddToCartPage(WebDriver driver, AddToCartData dataObj) {
		super();
		this.driver = driver;
		this.dataObj = dataObj;
	}

	/**
	 * @throws InterruptedException
	 */
	private void login() throws InterruptedException {
		// Click on 'Sign In' in webpage
		driver.findElement(signIn).click();
		Thread.sleep(5000);

		// Scroll web page to webelement 'email'to operate it
		WebElement email = driver.findElement(emailField);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", email);
		Thread.sleep(2000);

		driver.findElement(emailField).sendKeys(dataObj.getEmail());
		driver.findElement(password).sendKeys(dataObj.getPassword());
		driver.findElement(login).click();
		Thread.sleep(5000);
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public boolean validateAddToCart() throws InterruptedException {
		this.login();
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
