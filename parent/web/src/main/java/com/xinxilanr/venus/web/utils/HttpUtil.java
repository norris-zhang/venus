/**
 * 
 */
package com.xinxilanr.venus.web.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author norris
 *
 */
public class HttpUtil {

	public static String getRemoteIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
