/**
 * 
 */
package com.xinxilanr.venus.manager.impl;


import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xinxilanr.venus.common.CodeUtil;
import com.xinxilanr.venus.dao.UserDao;
import com.xinxilanr.venus.datamodel.Activate;
import com.xinxilanr.venus.datamodel.User;
import com.xinxilanr.venus.datamodel.enums.UserStatus;
import com.xinxilanr.venus.manager.UserManager;
import com.xinxilanr.venus.manager.dto.RegisterDto;
import com.xinxilanr.venus.manager.exceptions.LoginNoIdException;
import com.xinxilanr.venus.manager.exceptions.WrongPasswordException;

/**
 * @author norris
 *
 */
@Component
@Transactional
public class UserManagerImpl implements UserManager {
	private UserDao userDao;
	public UserManagerImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public void register(RegisterDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(CodeUtil.sha256(dto.getPassword()));
		user.setActive(false);
		user.setStatus(UserStatus.INIT.getValue());
		user.setCreatedAt(Timestamp.from(Instant.now()));
		user.setCreateIp(dto.getRemoteIp());
		
		Activate activate = new Activate();
		activate.setUser(user);
		activate.setActivateCode(CodeUtil.randomString(8));
		activate.setCreatedAt(Timestamp.from(Instant.now()));
		
		user.setActivate(activate);
		
		userDao.insert(user);
		
	}
	@Override
	public boolean isDuplicateEmail(String email) {
		User user = userDao.getByEmail(email);
		return user != null;
	}
	@Override
	public User login(String email, String password) throws LoginNoIdException, WrongPasswordException {
		User userByEmail = userDao.getByEmail(email);
		if (userByEmail == null) {
			throw new LoginNoIdException();
		}
		if (!userByEmail.getPassword().equals(CodeUtil.sha256(password))) {
			throw new WrongPasswordException();
		}
		return userByEmail;
	}
	@Override
	public void updateUserLoginTime(Long id, String remoteIp) {
		User user = (User)userDao.get(User.class, id);
		user.setLastLoginAt(Timestamp.from(Instant.now()));
		user.setUpdatedAt(Timestamp.from(Instant.now()));
		user.setUpdateIp(remoteIp);
		userDao.update(user);
	}
}
