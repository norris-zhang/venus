/**
 * 
 */
package com.xinxilanr.venus.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author norris
 *
 */
@Entity
@Table(name="pictures")
@NamedQuery(name="Picture.findAll", query="SELECT p FROM Picture p")
public class Picture implements BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Post post;
	@Column(name="pic_status")
	private int picStatus;
	@Column(name="created_at")
	private Timestamp createdAt;
	@Column(name="original_file_name")
	private String originalFileName;
	@Column(name="original_file_ext")
	private String originalFileExt;
	@Column(name="original_dim_width")
	private int originalDimWidth;
	@Column(name="original_dim_height")
	private int originalDimHeight;
	@Override
	public Serializable getId() {
		return null;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public int getPicStatus() {
		return picStatus;
	}
	public void setPicStatus(int picStatus) {
		this.picStatus = picStatus;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getOriginalFileExt() {
		return originalFileExt;
	}
	public void setOriginalFileExt(String originalFileExt) {
		this.originalFileExt = originalFileExt;
	}
	public int getOriginalDimWidth() {
		return originalDimWidth;
	}
	public void setOriginalDimWidth(int originalDimWidth) {
		this.originalDimWidth = originalDimWidth;
	}
	public int getOriginalDimHeight() {
		return originalDimHeight;
	}
	public void setOriginalDimHeight(int originalDimHeight) {
		this.originalDimHeight = originalDimHeight;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
