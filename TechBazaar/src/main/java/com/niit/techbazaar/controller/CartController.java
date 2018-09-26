package com.niit.techbazaar.controller;




import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.backendproject.DAO.CartDAO;
import com.niit.backendproject.DAO.ProductDAO;
import com.niit.backendproject.model.Cart;
import com.niit.backendproject.model.Product;

@Controller
public class CartController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
@RequestMapping(value="totalproduct/addtocart/{productid}")
public String addcartitem(@RequestParam("quantity")int quantity,@PathVariable("productid")int productid,HttpSession session,Model m)
{
	System.out.println("Quantity "+quantity);
	Product product= productDAO.getProduct(productid);
	String username=(String)session.getAttribute("username");
	Cart cart= new Cart();
	int qunt=0;
	qunt=product.getStock();
	qunt-=quantity;
	cart.setUsername(username);
	cart.setPrice(product.getPrice());
	cart.setProductname(product.getProductname());
	cart.setStatus("NP");
	cart.setQuantity(quantity);
	cartDAO.addCart(cart);
	product.setStock(qunt);
	productDAO.updateProduct(product);
	List<Cart> cartitems=cartDAO.listCart(username);
	List<Product> products=productDAO.listProduct();
	m.addAttribute("cartitems",cartitems);
	m.addAttribute("products",products);
	m.addAttribute("totalpurchaseamount",this.calcTotalPurchaseAmount(cartitems));
	return "Cart";
}
@RequestMapping(value="/updatecartitem/{cartid}")
public String updatecartitem(@RequestParam("quantity") int quantity,@PathVariable("cartid") int cartid,HttpSession session,Model m,@RequestParam int productid)
{
	Cart cart=cartDAO.getCart(cartid);
	String username=(String)session.getAttribute("username");
	Product product=productDAO.getProduct(productid);
	product.setStock(product.getStock()+cart.getQuantity());
	productDAO.updateProduct(product);
	cart.setQuantity(quantity);
	product.setStock(product.getStock()-quantity);
	cartDAO.updateCart(cart);
	productDAO.updateProduct(product);
	List<Cart> cartitems=cartDAO.listCart(username);
	List<Product> products=productDAO.listProduct();
	m.addAttribute(username);
	m.addAttribute("cartitems",cartitems);
	m.addAttribute("products",products);
	m.addAttribute("totalpurchaseamount",this.calcTotalPurchaseAmount(cartitems));
	return "Cart";
}
@RequestMapping(value="/deletecartitem/{cartid}")
public String deletecartitem(@PathVariable("cartid")int cartid,HttpSession session,Model m,@RequestParam int id)
{
	Cart cart=cartDAO.getCart(cartid);
	String username=(String)session.getAttribute("username");
	int qunt=cart.getQuantity();
	Product product=productDAO.getProduct(id);
	product.setStock(product.getStock()+qunt);
	productDAO.updateProduct(product);
	cartDAO.deleteCart(cart);
	List<Cart> cartitems=cartDAO.listCart(username);
	List<Product> products=productDAO.listProduct();
	m.addAttribute("cartitems",cartitems);
	m.addAttribute("products",products);
	m.addAttribute("totalpurchaseamount",this.calcTotalPurchaseAmount(cartitems));
	return "Cart";
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
