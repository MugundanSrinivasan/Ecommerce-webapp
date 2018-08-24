package com.niit.backendproject.DAO;

import java.util.List;

import com.niit.backendproject.model.Cart;


public interface CartDAO {

	public Cart getCart(int cartid);
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> listCart(String username);
}
