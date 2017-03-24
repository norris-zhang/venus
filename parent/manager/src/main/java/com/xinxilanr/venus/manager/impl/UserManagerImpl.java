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
import com.xinxilanr.venus.datamodel.User;
import com.xinxilanr.venus.datamodel.enums.UserStatus;
import com.xinxilanr.venus.manager.UserManager;
import com.xinxilanr.venus.manager.dto.RegisterDto;

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
		
		userDao.insert(user);
		
	}
}
