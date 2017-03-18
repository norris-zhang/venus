/**
 * 
 */
package com.xinxilanr.venus.service;

/**
 * @author norris
 *
 */
public interface HttpService {

	boolean verifyRecaptcha(String recaptchaResponse);
	boolean verifyRecaptcha(String recaptchaResponse, String endUserIp);

}
