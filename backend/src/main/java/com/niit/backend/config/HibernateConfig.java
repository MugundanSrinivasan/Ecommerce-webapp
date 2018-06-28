package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.niit.backend.model.Category;

@Configuration
public class HibernateConfig {
@Bean
public DataSource getH2DataSource()
{
	DriverManagerDataSource ds= new DriverManagerDataSource();
	ds.setDriverClassName("org.h2.Driver");
	ds.setUrl("jdbc:h2:tcp://localhost/~/project");
	ds.setUsername("sa");
	ds.setPassword("sa");
	System.out.println("data source ");
	return ds;

}
@Bean(name="SessionFactory")
public SessionFactory getSessionFactory()
{
	Properties pro= new Properties();
	pro.put("hibernate.hbm2ddl.auto", "update");
	pro.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	LocalSessionFactoryBuilder sfb= new LocalSessionFactoryBuilder(getH2DataSource());
	sfb.addAnnotatedClass(Category.class);
	sfb.addProperties(pro);
	SessionFactory sf= sfb.buildSessionFactory();
	System.out.println("session factory");
	return sf;
	
}
@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sf)
{
	System.out.println("data source object");
	return new HibernateTransactionManager(sf);
}

	
}
