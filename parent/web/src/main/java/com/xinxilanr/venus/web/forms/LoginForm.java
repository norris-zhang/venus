/**
 * 
 */
package com.xinxilanr.venus.web.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author norris
 *
 */
public class LoginForm {
	@NotNull
	@Email
	@Size(min=5, max=100)
	private String email;
	@NotNull
	@Size(min=6)
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
