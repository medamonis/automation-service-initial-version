/**
 * 
 */
package com.davies.test.automation.data;

/**
 * @author Medamoni Swetha
 *
 */
public class AddToCartData {
	private String email;
	private String password;
	private String product;

	/**
	 * @param email
	 * @param password
	 * @param product
	 */
	public AddToCartData(String email, String password, String product) {
		super();
		this.email = email;
		this.password = password;
		this.product = product;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

}
