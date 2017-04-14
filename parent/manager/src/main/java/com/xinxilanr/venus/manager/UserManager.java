package com.xinxilanr.venus.manager;

import com.xinxilanr.venus.manager.dto.RegisterDto;

public interface UserManager {
	void register(RegisterDto dto);

	boolean isDuplicateEmail(String email);
}
