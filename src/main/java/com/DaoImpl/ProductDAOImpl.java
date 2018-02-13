package com.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.Dao.ProductDAO;
import com.Model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
 	SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	    @Override
		public void insertOrUpdateProduct(Product product) 
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(product);
		}

	    @Override
		public Product getProduct(int prod_id) {
		Session session=sessionFactory.getCurrentSession();
		try{
		Product product=session.get(Product.class,prod_id);
			return product;
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct() {
		Session session=sessionFactory.getCurrentSession();
		List<Product> list=session.createQuery("from Product",Product.class).list();
			return list;
	}

	
	@Override
	public void deleteProduct(Product product) {
		
		sessionFactory.getCurrentSession().delete(product);
		
	}

}
