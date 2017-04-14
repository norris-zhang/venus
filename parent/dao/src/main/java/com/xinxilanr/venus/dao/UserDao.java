/**
 * 
 */
package com.xinxilanr.venus.dao;

import com.xinxilanr.venus.datamodel.User;

/**
 * @author norris
 *
 */
public interface UserDao extends Dao {

	User getByEmail(String email);

}
