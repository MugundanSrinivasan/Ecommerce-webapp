package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Supplier;
@Repository("SupplierDAO")
@Transactional
public class SupplierDAOimp implements SupplierDAO {
@Autowired 
SessionFactory sf;
	public Supplier getSupplier(int supplierid) {
		try
		{
			Session session= sf.getCurrentSession();
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
			sf.getCurrentSession().save(supplier);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}
	}

	public boolean updateSupplier(Supplier supplier) {
		try
		{
			sf.getCurrentSession().update(supplier);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}	
	}

	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			sf.getCurrentSession().update(supplier);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}	
	}

	public List<Supplier> listSupplier() {
		
		try
		{
			Session session= sf.openSession();
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
