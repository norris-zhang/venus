/**
 * 
 */
package com.xinxilanr.venus.dao;

import com.xinxilanr.venus.datamodel.BaseEntity;

/**
 * @author norris
 *
 */
public interface Dao {
	void insert(BaseEntity entity);
	int delete(BaseEntity c);
}
