package com.Dao;

import java.util.List;

import com.Model.Supplier;

public interface SupplierDao {

	
	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplierById(int id);
	public List<Supplier> getAllSupplier();
	
}
