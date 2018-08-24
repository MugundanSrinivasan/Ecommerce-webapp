package com.niit.backendproject.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.Category;
import com.niit.backendproject.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImp implements SupplierDAO {
@Autowired
SessionFactory sessionFactory;
	
	public Supplier getSupplier(int supplierid) {
		try
		{
			Session session= sessionFactory.getCurrentSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, supplierid);
			return supplier;
		}
		catch(Exception e)
		{
			return null;
		}
	}


	public boolean addSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}


	public boolean updateSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	public List<Supplier> listSupplier() {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> listSupplier=query.list();
			session.close();
			return listSupplier;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	}


