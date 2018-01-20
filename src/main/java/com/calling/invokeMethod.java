package com.calling;

import java.util.List;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.Model.User;

public class invokeMethod {

	public static void main(String[] args) {
			
		UserDao im=new UserDaoImpl();
		List<User>dao=im.getUsers();
		System.out.println(dao.get(0).getName());
		

	}

}
