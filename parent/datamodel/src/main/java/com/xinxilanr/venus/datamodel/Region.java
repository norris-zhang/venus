package com.xinxilanr.venus.datamodel;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the regions database table.
 * 
 */
@Entity
@Table(name="regions")
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String abbreviation;

	@Column(name="cn_name")
	private String cnName;

	private String level;

	private String name;

	private Integer order;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="region")
	private List<Post> posts;

	//bi-directional many-to-one association to Region
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Region region;

	//bi-directional many-to-one association to Region
	@OneToMany(mappedBy="region")
	private List<Region> regions;

	public Region() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getCnName() {
		return this.cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setRegion(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setRegion(null);

		return post;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Region addRegion(Region region) {
		getRegions().add(region);
		region.setRegion(this);

		return region;
	}

	public Region removeRegion(Region region) {
		getRegions().remove(region);
		region.setRegion(null);

		return region;
	}

}