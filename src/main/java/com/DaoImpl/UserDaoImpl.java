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

/*@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<User> users=new ArrayList<User>();
	
	static{
		User user=new User();
		user.setEmail("lavuitplacid@gmail.com");
		user.setAddress("chennai");
		user.setCountry("india");
		user.setGender("female");
		user.setName("lavanya");
		user.setPassword("abc");
		user.setPhone("1234567890");
		
		users.add(user);
		
		
	}
	
	
	
	public List<User> list() {
		// TODO Auto-generated method stub
		return users;
	}



	@Transactional
	public boolean add(User user) {
		// TODO Auto-generated method stub
		
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	

}
*/

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
	
		

