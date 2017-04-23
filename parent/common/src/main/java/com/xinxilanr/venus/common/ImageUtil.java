/**
 * 
 */
package com.xinxilanr.venus.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.xinxilanr.venus.common.image.ImageDimension;

/**
 * @author norris
 *
 */
public class ImageUtil {
	public static ImageDimension getImageDimension(byte[] data) throws IOException {
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(data));
		return new ImageDimension(image.getWidth(), image.getHeight());
	}
}
