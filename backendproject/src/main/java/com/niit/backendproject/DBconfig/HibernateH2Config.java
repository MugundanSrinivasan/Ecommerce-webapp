package com.niit.backendproject.DBconfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backendproject.DAO.CartDAO;
import com.niit.backendproject.DAO.CartDAOImp;
import com.niit.backendproject.DAO.CategoryDAO;
import com.niit.backendproject.DAO.CategoryDAOImp;
import com.niit.backendproject.DAO.ProductDAO;
import com.niit.backendproject.DAO.ProductDAOImp;
import com.niit.backendproject.DAO.SupplierDAO;
import com.niit.backendproject.DAO.SupplierDAOImp;
import com.niit.backendproject.DAO.UserDAO;
import com.niit.backendproject.DAO.UserDAOImp;
import com.niit.backendproject.model.Cart;
import com.niit.backendproject.model.Category;
import com.niit.backendproject.model.Product;
import com.niit.backendproject.model.Supplier;
import com.niit.backendproject.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class HibernateH2Config {

	@Bean(name="ds")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:tcp://localhost/~/projectecommerce");
		ds.setUsername("sa");
		ds.setPassword("sa");
		System.out.println("data source ");
		return ds;

	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties pro= new Properties();
		pro.put("hibernate.hbm2ddl.auto", "update");
		pro.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder sfb= new LocalSessionFactoryBuilder(getH2DataSource());
		sfb.addAnnotatedClass(Category.class);
		sfb.addAnnotatedClass(Supplier.class);
		sfb.addAnnotatedClass(Product.class);
		sfb.addAnnotatedClass(User.class);
		sfb.addAnnotatedClass(Cart.class);
		System.out.println("session factory");
		sfb.addProperties(pro);
		SessionFactory sessionFactory= sfb.buildSessionFactory();
		return sessionFactory;
		
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("data source object");
		return new HibernateTransactionManager(sessionFactory);
	}
	@Bean(name="categoryDAO")
	
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("Category bean created");
	     return new CategoryDAOImp();
	}
@Bean(name="supplierDAO")
	
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("Supplier bean created");
	     return new SupplierDAOImp();
	}
@Bean(name="productDAO")

public ProductDAO getProductDAO()
{
	System.out.println("Product bean created");
     return new ProductDAOImp();
}
@Bean(name="userDAO")

public UserDAO getUserDAO()
{
	System.out.println("User bean created");
     return new UserDAOImp();
}
@Bean(name="cartDAO")

public CartDAO getCartDAO()
{
	System.out.println("User bean created");
     return new CartDAOImp();
}
}


