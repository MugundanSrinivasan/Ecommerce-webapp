package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Product;
@Repository("ProductDAO")
@Transactional
public class ProductDAOimp implements ProductDAO {
@Autowired
SessionFactory sf;
	public Product getProduct(int productid) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
