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
public class RegisterForm {
	@NotNull
	@Email
	@Size(min=5, max=100)
	private String email;
	@NotNull
	@Size(min=6)
	private String password;
	private String passwordRepeat;
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
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	@Override
	public String toString() {
		return "email = " + this.email + ", password = " + password;
	}
}
