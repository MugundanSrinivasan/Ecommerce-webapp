package com.niit.techbazaar.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.backendproject.DAO.CartDAO;
import com.niit.backendproject.DAO.OrderDetailDAO;
import com.niit.backendproject.model.Cart;
import com.niit.backendproject.model.OrderDetail;

@Controller
public class OrderController {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	OrderDetailDAO orderdetailDAO;
@RequestMapping(value="/checkout")
public String checkoutprocess(Model m,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	List<Cart> cartitems=cartDAO.listCart(username);
	m.addAttribute("cartitems",cartitems);
	m.addAttribute("totalpurchaseamount",this.calcTotalPurchaseAmount(cartitems));
	return "MyOrder";
}
@RequestMapping("/payment")
public String paymentprocess(Model m,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	List<Cart> cartitems=cartDAO.listCart(username);
	m.addAttribute("cartitems",cartitems);
	m.addAttribute("totalpurchaseamount",this.calcTotalPurchaseAmount(cartitems));
	return "Payment";
}
@RequestMapping(value="/paymentprocess",method=RequestMethod.POST)
public String paymentProcessing(@RequestParam("paymenttype")String paymode,Model m,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	List<Cart> cartitems=cartDAO.listCart(username);
	m.addAttribute("cartitems",cartitems);
	double totalpurchaseamount=this.calcTotalPurchaseAmount(cartitems);
	m.addAttribute("totalpurchaseamount", totalpurchaseamount);
	OrderDetail orderdetail=new OrderDetail();
	orderdetail.setPaymentmode(paymode);
	orderdetail.setUsername(username);
orderdetail.setTotalpurchaseamount(totalpurchaseamount);
	orderdetail.setOrderdate(new java.util.Date());
	orderdetailDAO.insertOrderDetail(orderdetail);
	orderdetailDAO.updateOrderDetail(username);
	
	return "Receipt";
}
public double calcTotalPurchaseAmount(List<Cart> cartitems)
{
	double totalpurchaseamount=0;
	int count=0;
	while(count<cartitems.size())
	{
		Cart cart=cartitems.get(count);
		totalpurchaseamount=totalpurchaseamount+(cart.getQuantity()*cart.getPrice());
		count++;	
	}
	return totalpurchaseamount;
}

}
