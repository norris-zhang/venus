/**
 * 
 */
package com.xinxilanr.venus.dao;

import java.io.Serializable;

import com.xinxilanr.venus.datamodel.BaseEntity;

/**
 * @author norris
 *
 */
public interface Dao {
	void insert(BaseEntity entity);
	int delete(BaseEntity c);
	BaseEntity get(Class<? extends BaseEntity> clazz, Serializable id);
	void update(BaseEntity entity);
}
