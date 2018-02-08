package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CategoryDAO;
import com.Model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public boolean addCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

	@Override
	public boolean deleteCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Category category=session.get(Category.class,id);
				return category;
		} catch (Exception e) {
				return null;
		}
		
	}


	@Override
	public List<Category> getAllCategory() {
		Session session = sessionFactory.getCurrentSession();
		List<Category> list=session.createQuery("from Category",Category.class).list();
		return list;
	}
}
