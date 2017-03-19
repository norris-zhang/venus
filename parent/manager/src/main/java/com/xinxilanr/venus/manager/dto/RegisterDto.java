/**
 * 
 */
package com.xinxilanr.venus.manager.dto;

/**
 * @author norris
 *
 */
public class RegisterDto {
	private String email;
	private String password;
	private String remoteIp;
	public String getEmail() {
		return email;
	}
	public RegisterDto setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public RegisterDto setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public RegisterDto setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
		return this;
	}
	
}
