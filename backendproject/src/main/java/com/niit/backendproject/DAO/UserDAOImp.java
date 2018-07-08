package com.niit.backendproject.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.User;
@Repository("userDAO")
@Transactional
public class UserDAOImp implements UserDAO {
@Autowired
SessionFactory sessionFactory;
	@Override
	public boolean registerUser(User user){
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		}

	@Override
	public User getUser(String username) {
		try
		{
			Session session= sessionFactory.getCurrentSession();
			User user=(User)session.get(User.class,username);
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
