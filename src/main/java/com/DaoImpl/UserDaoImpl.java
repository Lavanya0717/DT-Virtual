package com.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import com.Dao.UserDao;
import com.Model.User;

public class UserDaoImpl implements UserDao {

	public List<User> getUsers() {
		User u1=new User("lavu","lavu@gmail.com");
		List<User> l=new ArrayList<User>();
		l.add(u1);
		return l;
		
		
		
	}
}

	
		

