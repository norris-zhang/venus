/**
 * 
 */
package com.xinxilanr.venus.datamodel.enums;

/**
 * @author norris
 *
 */
public enum UserStatus {
	INIT(0, "init"),
	PROFILE_INCOMPLETE(1, "profile_incomplete"),
	PROFILE_COMPLETE(2, "profile_complete"),
	DEACTIVATED(3, "deactivated");
	private int value;
	private String name;
	private UserStatus(int value, String name) {
		this.value = value;
		this.name = name;
	}
	public int getValue() {
		return this.value;
	}
	public String getName() {
		return this.name;
	}
	
}
