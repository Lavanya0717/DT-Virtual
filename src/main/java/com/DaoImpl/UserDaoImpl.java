package com.DaoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.Model.User;



@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean addUserDetails(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean validateUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query<User> query=session.createQuery("from User where username=:user and password=:pass");
		query.setParameter("user", username);
		query.setParameter("pass",password);
		List<User> list=query.list();
		for(User user:list)
			if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
					return true;
		return false;
	}
}
	
		

