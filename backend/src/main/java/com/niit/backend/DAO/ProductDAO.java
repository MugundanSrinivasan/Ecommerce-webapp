package com.niit.backend.DAO;

import java.util.List;

import com.niit.backend.model.Product;

public interface ProductDAO {
	public Product getProduct(int productid);
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	public List<Product> listProduct();
}
