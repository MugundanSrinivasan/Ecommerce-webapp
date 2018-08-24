package com.niit.backendproject.DAO;

import java.util.List;

import com.niit.backendproject.model.Product;

public interface ProductDAO {
public boolean addProduct(Product product);
public boolean updateProduct(Product product);
public boolean deleteProduct(Product product);
public Product getProduct(int productid);
public List<Product> listProduct();
public List<Product> listProductByCategory(int categoryid);
}
