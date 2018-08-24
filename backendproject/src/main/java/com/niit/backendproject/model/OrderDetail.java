package com.niit.backendproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderDetail {
@Id
@GeneratedValue
int orderid;
Date orderdate;
String username;
String paymentmode;
Double totalpurchaseamount;
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public Date getOrderdate() {
	return orderdate;
}
public void setOrderdate(Date orderdate) {
	this.orderdate = orderdate;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPaymentmode() {
	return paymentmode;
}
public void setPaymentmode(String paymentmode) {
	this.paymentmode = paymentmode;
}
public Double getTotalpurchaseamount() {
	return totalpurchaseamount;
}
public void setTotalpurchaseamount(Double totalpurchaseamount) {
	this.totalpurchaseamount = totalpurchaseamount;
}
	
}
