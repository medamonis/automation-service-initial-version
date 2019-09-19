/**
 * 
 */
package com.davies.test.automation.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Medamoni Swetha
 *
 */
public class TestUtils {

	public static String generateUniqueEmail(String oldEmail, String isNewEmailRequired) {

		if (Boolean.parseBoolean(isNewEmailRequired)) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (oldEmail.contains("@")) {
				return oldEmail.split("@")[0].concat(sdf.format(date)).concat("@").concat(oldEmail.split("@")[1]);
			} else {
				return oldEmail.concat(sdf.format(date));
			}
		}
		return oldEmail;
	}
}
