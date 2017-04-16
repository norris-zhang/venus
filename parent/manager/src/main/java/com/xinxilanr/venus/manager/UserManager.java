package com.xinxilanr.venus.manager;

import com.xinxilanr.venus.datamodel.User;
import com.xinxilanr.venus.manager.dto.RegisterDto;
import com.xinxilanr.venus.manager.exceptions.LoginNoIdException;
import com.xinxilanr.venus.manager.exceptions.WrongPasswordException;

public interface UserManager {
	void register(RegisterDto dto);

	boolean isDuplicateEmail(String email);

	User login(String email, String password) throws LoginNoIdException, WrongPasswordException;

	void updateUserLoginTime(Long id, String remoteIp);
}
