/**
 * 
 */
package com.xinxilanr.venus.web.utils;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinxilanr.venus.common.CodeUtil;

/**
 * @author norris
 *
 */
public class CookieHandler {
	private static final String SESSION_COOKIE_NAME = "jsessiontoken";
	private HttpServletRequest request;
	private HttpServletResponse response;
	public CookieHandler(HttpServletRequest request, HttpServletResponse response) {
		this.request  = request;
		this.response = response;
	}
	public String getClusteredSessionId() {
		String sessionId = getCookie(SESSION_COOKIE_NAME).orElse(CodeUtil.generateToken());
		setCookie(SESSION_COOKIE_NAME, sessionId);
		return sessionId;
	}
	public Optional<String> getCookie(String name) {
		Cookie[] cookies = Optional.ofNullable(request.getCookies()).orElse(new Cookie[0]);
		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return Optional.of(cookie.getValue());
			}
		}
		return Optional.empty();
	}
	public void setCookie(String name, String value) {
		setCookie(name, value, 0);
	}
	public void setCookie(String name, String value, int maxAge) {
		if (name == null || name.trim().length() == 0) {
			return;
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
}
