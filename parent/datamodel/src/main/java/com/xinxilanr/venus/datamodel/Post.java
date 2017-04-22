package com.xinxilanr.venus.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Long id;

	private String address;

	@Column(name="cate_aware_info")
	private String cateAwareInfo;

	@Column(name="contact_email")
	private String contactEmail;

	@Column(name="contact_facebook")
	private String contactFacebook;

	@Column(name="contact_linkedin")
	private String contactLinkedin;

	@Column(name="contact_number")
	private String contactNumber;

	@Column(name="contact_person")
	private String contactPerson;

	@Column(name="contact_qq")
	private String contactQq;

	@Column(name="contact_twitter")
	private String contactTwitter;

	@Column(name="contact_wechat")
	private String contactWechat;

	private String description;

	private String pictures;

	@Column(name="posted_at")
	private Timestamp postedAt;

	private Integer status;

	private String title;

	@Column(name="website_url")
	private String websiteUrl;

	private String zipcode;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="cate_id")
	private Category category;

	//bi-directional many-to-one association to Region
	@ManyToOne
	private Region region;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	@OneToMany(mappedBy="post")
	private List<Picture> pictureList;

	public Post() {
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCateAwareInfo() {
		return this.cateAwareInfo;
	}

	public void setCateAwareInfo(String cateAwareInfo) {
		this.cateAwareInfo = cateAwareInfo;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactFacebook() {
		return this.contactFacebook;
	}

	public void setContactFacebook(String contactFacebook) {
		this.contactFacebook = contactFacebook;
	}

	public String getContactLinkedin() {
		return this.contactLinkedin;
	}

	public void setContactLinkedin(String contactLinkedin) {
		this.contactLinkedin = contactLinkedin;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactQq() {
		return this.contactQq;
	}

	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}

	public String getContactTwitter() {
		return this.contactTwitter;
	}

	public void setContactTwitter(String contactTwitter) {
		this.contactTwitter = contactTwitter;
	}

	public String getContactWechat() {
		return this.contactWechat;
	}

	public void setContactWechat(String contactWechat) {
		this.contactWechat = contactWechat;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPictures() {
		return this.pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public Timestamp getPostedAt() {
		return this.postedAt;
	}

	public void setPostedAt(Timestamp postedAt) {
		this.postedAt = postedAt;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWebsiteUrl() {
		return this.websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Picture> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<Picture> pictureList) {
		this.pictureList = pictureList;
	}

}