/*package com.niit.BokayFloristBackEnd.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.SupplierDao;
import com.Model.Supplier;

public class SupplierTestCase {

static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setup(){
		context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
	}
	@Test
	public void testAddSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		supplier.setSid(1);
		supplier.setSupplierName("lavanya");
		assertEquals(true, supplierDao.addSupplier(supplier));
	}
	@Test
	public void testUpdateSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		supplier.setSid(11);
		supplier.setSupplierName("Vignesh");
		assertEquals(true, supplierDao.updateSupplier(supplier));
	}
	@Test
	public void testDeleteSupplier() {
		Supplier supplier=(Supplier)context.getBean("supplier");
		SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
		supplier.setSid(12);
		assertEquals(true, supplierDao.deleteSupplier(supplier));
	}
	@AfterClass
	public static void tearDown(){
		context.close();
	}
	
}
	

*/