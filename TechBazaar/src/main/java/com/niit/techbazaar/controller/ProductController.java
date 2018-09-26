package com.niit.techbazaar.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.backendproject.DAO.CategoryDAO;
import com.niit.backendproject.DAO.ProductDAO;
import com.niit.backendproject.model.Category;
import com.niit.backendproject.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@RequestMapping(value="product")
	public String showProductPage(Model m)
	{
		Product product=new Product();
		m.addAttribute(product);
		m.addAttribute("categorylist", this.getCategory());
		m.addAttribute("productlist",productDAO.listProduct());
		return "Product";
	}
	@RequestMapping(value="InsertProduct", method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage") MultipartFile filedet,Model m)
	{
		productDAO.addProduct(product);
		m.addAttribute("categorylist", this.getCategory());
		
		Product product1=new Product();
		m.addAttribute(product1);
		m.addAttribute("productlist",productDAO.listProduct());
		String path="E:\\project\\workspace\\TechBazaar\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductid())+".jpg";
		File file=new File(path);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte[] buffer=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(file);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("errorInfo","Exception Arised:"+e.getMessage());
			}
		}
		else
		{
			m.addAttribute("errorInfo","There is System Problem No Image Insertion");
		}
		return "Product";
	}
	@RequestMapping(value="deleteproduct/{productid}")
	public String deleteProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProduct(productid);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute(product1);
		m.addAttribute("categorylist", this.getCategory());
		m.addAttribute("productlist",productDAO.listProduct());
		
		return "Product";
	}
	@RequestMapping(value="editproduct/{productid}")
	public String editProduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProduct(productid);
		m.addAttribute(product);
		m.addAttribute("categorylist", this.getCategory());
		/*m.addAttribute("product",productDAO.listProduct());*/
		
		return "EditProduct";
	}
	@RequestMapping(value="updateproduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
	{
		System.out.println("product controller update product");
		productDAO.updateProduct(product);
	/*	Product product1= new Product();
	
		m.addAttribute(product1);
		m.addAttribute("categorylist", this.getCategory());
		m.addAttribute("productlist",productDAO.listProduct());*/
		System.out.println("after commeting the binding code");
		return "redirect:/product";
	}
	@RequestMapping("productdisplay")
	public String displayproduct(Model m)
	{/*
		Product product=new Product();
		m.addAttribute(product);
		m.addAttribute("categorylist", this.getCategory());*/
		m.addAttribute("productlist",productDAO.listProduct());
		return "ProductDisplay";
	}
	@RequestMapping("/continueshopping")
	public String displaycartproduct(Model m)
	{/*
		Product product=new Product();
		m.addAttribute(product);
		m.addAttribute("categorylist", this.getCategory());*/
		m.addAttribute("productlist",productDAO.listProduct());
		return "ProductDisplay";
	}
	@RequestMapping("totalproduct/{productid}")
	public String totalproduct(@PathVariable("productid")int productid,Model m)
	{
		Product product=productDAO.getProduct(productid);
		
		m.addAttribute("product",product);
		return "TotalProduct";
	}
	public LinkedHashMap<Integer,String> getCategory()
	{
		List<Category> listCategory=categoryDAO.listCategory();
		LinkedHashMap<Integer,String> categoryData= new LinkedHashMap<Integer,String>();
		for(Category category:listCategory)
		{
			categoryData.put(category.getCategoryid(),category.getCategoryname());
		}
		return categoryData;
	}

}
