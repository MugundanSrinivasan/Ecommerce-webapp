package com.niit.backendproject.DAO;

import com.niit.backendproject.model.UserDetail;

public interface UserDetailDAO {
	public boolean registerUser(UserDetail user);
	public boolean updateDetail(UserDetail user);
	public UserDetail getUserDetail(String username);
}
