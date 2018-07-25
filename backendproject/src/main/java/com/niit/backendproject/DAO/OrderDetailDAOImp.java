package com.niit.backendproject.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.OrderDetail;
@Repository("orderdetailDAO")
@Transactional
public class OrderDetailDAOImp implements OrderDetailDAO {
@Autowired
SessionFactory sessionFactory;
	@Override
	public boolean insertOrderDetail(OrderDetail orderdetail) {
		try
		{
			sessionFactory.getCurrentSession().save(orderdetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateOrderDetail(String username) {

try{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("update Cart set status='P' where username=:myusername and status='NA'");
	query.setParameter("myusername",username);
	int row_eff=query.executeUpdate();
	if(row_eff>0)
		return true;
	else
		return false;
			
}
catch(Exception e)
{
return false;
	}

}
}