package com.xinxilanr.venus.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

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
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Long id;

	private String code;

	private String name;

	@Column(name = "\"order\"")
	private Integer order;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Category parent;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="parent")
	private List<Category> children;

	//bi-directional many-to-one association to Post
	@OneToMany(mappedBy="category")
	private List<Post> posts;

	public Category() {
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public Category setId(Long id) {
		this.id = id;
		return this;
	}

	public String getCode() {
		return this.code;
	}

	public Category setCode(String code) {
		this.code = code;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getOrder() {
		return this.order;
	}

	public Category setOrder(Integer order) {
		this.order = order;
		return this;
	}

	public Category getParent() {
		return this.parent;
	}

	public Category setParent(Category parent) {
		this.parent = parent;
		return this;
	}

	public List<Category> getChildren() {
		return this.children;
	}

	public Category setChildren(List<Category> children) {
		this.children = children;
		return this;
	}

	public Category addChild(Category child) {
		getChildren().add(child);
		child.setParent(this);

		return child;
	}

	public Category removeChild(Category child) {
		getChildren().remove(child);
		child.setParent(null);

		return child;
	}

	public List<Post> getPosts() {
		return this.posts;
	}

	public Category setPosts(List<Post> posts) {
		this.posts = posts;
		return this;
	}

	public Post addPost(Post post) {
		getPosts().add(post);
		post.setCategory(this);

		return post;
	}

	public Post removePost(Post post) {
		getPosts().remove(post);
		post.setCategory(null);

		return post;
	}

}