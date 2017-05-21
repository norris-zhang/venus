/**
 * 
 */
package com.xinxilanr.venus.manager.impl;

import static com.xinxilanr.venus.datamodel.enums.PictureStatus.INIT;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xinxilanr.venus.common.ImageUtil;
import com.xinxilanr.venus.common.image.ImageDimension;
import com.xinxilanr.venus.dao.PictureDao;
import com.xinxilanr.venus.datamodel.Picture;
import com.xinxilanr.venus.datamodel.Post;
import com.xinxilanr.venus.datamodel.User;
import com.xinxilanr.venus.manager.PictureManager;
import com.xinxilanr.venus.manager.dto.PictureDto;

/**
 * @author norris
 *
 */
@Component
@Transactional
public class PictureManagerImpl implements PictureManager {
	private PictureDao dao;
	public PictureManagerImpl(PictureDao dao) {
		this.dao = dao;
	}
	/* (non-Javadoc)
	 * @see com.xinxilanr.venus.manager.PictureManager#save(com.xinxilanr.venus.manager.dto.PictureDto)
	 */
	@Override
	public PictureDto save(PictureDto pictureDto) throws IOException {
		long pictureId = savePictureEntity(pictureDto);
		pictureDto.setPictureId(pictureId);
		return pictureDto;
	}
	private long savePictureEntity(PictureDto pictureDto) throws IOException {
		User user = (User)dao.get(User.class, pictureDto.getUserId());
		Picture picture = new Picture();
		picture.setUser(user);
		if (pictureDto.getPostId() != null) {
			picture.setPost((Post)dao.get(Post.class, pictureDto.getPostId()));
		}
		picture.setPicStatus(INIT.getValue());
		picture.setCreatedAt(Timestamp.from(Instant.now()));
		picture.setOriginalFileName(pictureDto.getOriginalFileName());
		picture.setOriginalFileExt(pictureDto.getOriginalFileExt());
		ImageDimension imageDim = ImageUtil.getImageDimension(pictureDto.getData());
		picture.setOriginalDimWidth(imageDim.width);
		picture.setOriginalDimHeight(imageDim.height);

		dao.insert(picture);

		return (long)picture.getId();
	}

}
