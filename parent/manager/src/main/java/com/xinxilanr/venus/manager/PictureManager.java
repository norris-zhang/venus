/**
 * 
 */
package com.xinxilanr.venus.manager;

import java.io.IOException;

import com.xinxilanr.venus.manager.dto.PictureDto;

/**
 * @author norris
 *
 */
public interface PictureManager {
	PictureDto save(PictureDto pictureDto) throws IOException;
}
