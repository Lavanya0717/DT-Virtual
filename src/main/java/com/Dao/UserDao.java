package com.Dao;


import java.util.List;

import com.Model.User;

public interface UserDao {

		
	public boolean addUserDetails(User user);
	public boolean validateUser(String username,String password);
	
}