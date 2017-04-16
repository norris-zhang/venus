/**
 * 
 */
package com.xinxilanr.venus.web.session;

import java.io.Serializable;
import java.time.Instant;
import java.util.Optional;

import com.xinxilanr.venus.datamodel.User;

/**
 * @author norris
 *
 */
public class SessionUser implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String SESSION_USER_KEY = "sessionUserKey";
	private Long userId;
	private String userName;
	private String loginEmail;
	private Instant lastLoginTime;
	public SessionUser(User user) {
		this.userId = user.getId();
		this.userName = getDisplayName(user);
		this.loginEmail = user.getEmail();
		this.lastLoginTime = user.getLastLoginAt() == null ? null : user.getLastLoginAt().toInstant();
	}
	private String getDisplayName(User user) {
		return Optional.ofNullable(user.getName())
					   .orElse(getNameFromEmail(user.getEmail()));
	}
	private String getNameFromEmail(String email) {
		return email.substring(0, email.indexOf('@'));
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginEmail() {
		return loginEmail;
	}
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}
	public Instant getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Instant lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
