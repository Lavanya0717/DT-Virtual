package com.DaoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.Model.User;



@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean add(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
	
		

