/**
 * 
 */
package com.xinxilanr.venus.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author norris
 *
 */
public class FileUtil {
	public static void writeToFile(String filePath, byte[] fileContent) throws IOException {
		Files.write(Paths.get(filePath), fileContent, StandardOpenOption.CREATE);
	}

	public static String getExtensionFromFileName(String filename) {
		int position = filename.lastIndexOf(".");
		if (position < 0) {
			return null;
		}
		return filename.substring(position + 1);
	}
}
