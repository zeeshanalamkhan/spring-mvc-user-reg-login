package com.zeeshan.dao;

import com.zeeshan.model.User;

public interface UserDAO {

	public int registerUser(User user);

	public String loginUser(User user);
}
