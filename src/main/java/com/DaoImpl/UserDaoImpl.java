package com.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDao;
import com.Model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	
	
	
	public boolean addUserDetails(User userDetails) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(userDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	public boolean validateUser(String username, String password) {
		Session session = sessionFactory.openSession();
		Query<User> query=session.createQuery("from UserDetails where name=:user and password=:pass");
		query.setParameter("user", username);
		query.setParameter("pass",password);
		List<User> list=query.list();
		session.close();
		for(User user:list)
			if (username.equals(user.getName()) && password.equals(user.getPassword()))
					return true;
		return false;
	}

}



	
		

