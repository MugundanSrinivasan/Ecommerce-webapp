package com.niit.backendproject.DAO;

import java.util.List;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.Cart;
@Repository("cartDAO")
@Transactional
public class CartDAOImp implements CartDAO {
	@Autowired
	SessionFactory sessionFactory;

	public Cart getCart(int cartid) {
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Cart cart=(Cart)session.get(Cart.class, cartid);
			return cart;
		}
		catch (Exception e)
		{
		return null;
	}
	}

	
	public boolean addCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	
	public boolean updateCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	
	public boolean deleteCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	
	public List<Cart> listCart(String username) {
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:myusername and status=:'NA'");
			query.setParameter("myusername", username);
			List<Cart> listCart=(List<Cart>)query.getResultList();
			session.close();
			return listCart;
		}
		catch(Exception e)
		{
		return null;
	}

}
}