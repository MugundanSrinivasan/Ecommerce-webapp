package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Supplier;



public interface SupplierDAO {
	
		public Supplier getSupplier( int supplierid);
		public boolean addSupplier(Supplier supplier);
		public boolean updateSupplier(Supplier supplier);
		public boolean deleteSupplier(Supplier supplier);
		public List<Supplier> listSupplier();
	
}
