package com.niit.backendproject.DAO;

import java.util.List;

import com.niit.backendproject.model.Supplier;



public interface SupplierDAO {
	public Supplier getSupplier( int supplierid);
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> listSupplier();
}
