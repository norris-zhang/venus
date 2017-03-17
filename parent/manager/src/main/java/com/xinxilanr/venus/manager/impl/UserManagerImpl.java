/**
 * 
 */
package com.xinxilanr.venus.manager.impl;

import org.springframework.stereotype.Component;

import com.xinxilanr.venus.dao.UserDao;
import com.xinxilanr.venus.manager.UserManager;
import com.xinxilanr.venus.manager.dto.RegisterDto;

/**
 * @author norris
 *
 */
@Component
public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	public UserManagerImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void register(RegisterDto dto) {
		System.out.println("user manager");
		userDao.insert(null);
	}
}
