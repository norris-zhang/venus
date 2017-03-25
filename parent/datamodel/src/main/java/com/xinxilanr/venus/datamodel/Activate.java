/**
 * 
 */
package com.xinxilanr.venus.datamodel;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author norris
 *
 */
@Entity
@Table(name="activate")
public class Activate implements BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@OneToOne(cascade=ALL)
	private User user;
	@Column(name="activate_code")
	private String activateCode;
	@Column(name="created_at")
	private Timestamp createdAt;
	@Column(name="activated_at")
	private Timestamp activatedAt;

	/* (non-Javadoc)
	 * @see com.xinxilanr.venus.datamodel.BaseEntity#getId()
	 */
	@Override
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getActivatedAt() {
		return activatedAt;
	}

	public void setActivatedAt(Timestamp activatedAt) {
		this.activatedAt = activatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
