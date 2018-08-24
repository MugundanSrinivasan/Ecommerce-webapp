package com.niit.backendproject.DAO;

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
	
	public boolean insertOrderDetail(OrderDetail orderdetail) {
		
			
		
		return false;
	}


	public boolean updateOrderDetail(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
