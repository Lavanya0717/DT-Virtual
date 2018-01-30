package com.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDao;
import com.Model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public boolean addSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean deleteSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean updateSupplier(Supplier supplier) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(supplier);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Supplier getSupplierById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Supplier supplier=session.get(Supplier.class,id);
			session.close();
			return supplier;
		} catch (Exception e) {
			session.close();
			return null;
		}
		
	}
	@Override
	public List<Supplier> getAllSupplier() {
		Session session = sessionFactory.openSession();
		List<Supplier> list=session.createQuery("from Supplier").list();
		return list;
	}
}
