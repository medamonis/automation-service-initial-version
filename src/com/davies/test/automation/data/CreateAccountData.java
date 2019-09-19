/**
 * 
 */
package com.davies.test.automation.data;

/**
 * @author Medamoni Swetha
 *
 */
public class CreateAccountData {

	/**
	 * @param email
	 */
	public CreateAccountData(String email) {
		this.email = email;
	}

	private String email;

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;

	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;

	}

}
