package com.niit.BokayFloristBackEnd.test;



import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.UserDao;
import com.Model.User;


public class UserTestCase {

	static AnnotationConfigApplicationContext context;
	
	
	@BeforeClass
	public static void setup(){

		
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		
	}
	
	@Test
	public void testAddUser()
	{
		User user=(User)context.getBean("user");
		UserDao userDao=(UserDao)context.getBean("userDao");
		
		
		user.setEmail("lavuitplacid@gmail.com");
		user.setAddress("chennai");
		user.setCountry("india");
		user.setGender("female");
		user.setName("lavanya");
		user.setPassword("abc");
		user.setPhone("1234567890");
		
		assertEquals("Successfully added in the db",true,userDao.add(user));
	}
	
	@AfterClass
	public static void teardown(){
		context.close();
	}
	
}
	
	
	