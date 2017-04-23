/**
 * 
 */
package com.xinxilanr.venus.manager.dto;

import com.xinxilanr.venus.common.enums.PictureType;

/**
 * @author norris
 *
 */
public class PictureDto {
	private long userId;
	private Long postId;
	private String originalFileName;
	private String originalFileExt;
	private PictureType pictureType;
	private byte[] data;
	public long getUserId() {
		return userId;
	}
	public PictureDto setUserId(long userId) {
		this.userId = userId;
		return this;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public PictureDto setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
		return this;
	}
	public String getOriginalFileExt() {
		return originalFileExt;
	}
	public PictureDto setOriginalFileExt(String originalFileExt) {
		this.originalFileExt = originalFileExt;
		return this;
	}
	public PictureType getPictureType() {
		return pictureType;
	}
	public PictureDto setPictureType(PictureType pictureType) {
		this.pictureType = pictureType;
		return this;
	}
	public byte[] getData() {
		return data;
	}
	public PictureDto setData(byte[] data) {
		this.data = data;
		return this;
	}
	public Long getPostId() {
		return postId;
	}
	public PictureDto setPostId(Long postId) {
		this.postId = postId;
		return this;
	}
	
}
