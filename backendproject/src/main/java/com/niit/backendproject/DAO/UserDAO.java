package com.niit.backendproject.DAO;

import com.niit.backendproject.model.User;

public interface UserDAO {
public boolean registerUser(User user);
public boolean updateUser(User user);
public User getUser(String username);
}
