/**
 * 
 */
package com.xinxilanr.venus.common.image.picture;

import static java.io.File.separator;

import com.xinxilanr.venus.common.enums.PictureType;

/**
 * @author norris
 *
 */
public class PictureUtil {
	private static final int NUMBER_PER_DIR = 1000;
	public static String getRelativeDirFromPictureId(long id, PictureType pictureType) {
		return (id / NUMBER_PER_DIR) + separator + id + "." + pictureType.getExtension();
	}
}
