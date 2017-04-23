/**
 * 
 */
package com.xinxilanr.venus.datamodel.enums;

/**
 * @author norris
 *
 */
public enum PictureStatus {
	INIT(0);
	private int value;
	PictureStatus(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
