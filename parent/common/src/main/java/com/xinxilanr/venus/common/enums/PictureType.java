/**
 * 
 */
package com.xinxilanr.venus.common.enums;

/**
 * @author norris
 *
 */
public enum PictureType {
	JPG("jpg"),
	JPEG("jpeg"),
	PNG("png"),
	GIF("gif");

	private String extension;
	PictureType(String extension) {
		this.extension = extension;
	}
	public String getExtension() {
		return extension;
	}
	public static PictureType fromExtension(String originalFileExt) {
		switch (originalFileExt.toLowerCase()) {
			case "jpg":
				return JPG;
			case "jpeg":
				return JPEG;
			case "png":
				return PNG;
			case "gif":
				return GIF;
			default:
				return JPG;
		}
	}
}
