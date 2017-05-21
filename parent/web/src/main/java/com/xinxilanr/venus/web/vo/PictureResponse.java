/**
 * 
 */
package com.xinxilanr.venus.web.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author norris
 *
 */
public class PictureResponse {
	private List<Picture> files = new ArrayList<>();

	public List<Picture> getFiles() {
		return files;
	}

	public void setFiles(List<Picture> files) {
		this.files = files;
	}

	public void addFile(Picture file) {
		this.files.add(file);
	}

	public static class Picture {
		private String name;
		private long size;
		private String url;
		private String thumbnailUrl;
		private String deleteUrl;
		private String deleteType = "DELETE";
		private String error;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getSize() {
			return size;
		}
		public void setSize(long size) {
			this.size = size;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getThumbnailUrl() {
			return thumbnailUrl;
		}
		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}
		public String getDeleteUrl() {
			return deleteUrl;
		}
		public void setDeleteUrl(String deleteUrl) {
			this.deleteUrl = deleteUrl;
		}
		public String getDeleteType() {
			return deleteType;
		}
		public void setDeleteType(String deleteType) {
			this.deleteType = deleteType;
		}
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
	}
}
