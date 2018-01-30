package com.config;

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

import com.Model.User;


@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class hibernateConfig {
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("sa");
		datasource.setPassword("");
		return datasource;
	}
	
	@Bean(name="sessionfact")
	public SessionFactory getSessionFactory(){
		Properties prop = new Properties();
		prop.put("hibernate.hbm2ddl.auto","update");
		prop.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		prop.put("hibernate.show_sql","true");
		LocalSessionFactoryBuilder sessionFactBuilder = new LocalSessionFactoryBuilder(getDataSource());
		sessionFactBuilder.addProperties(prop);
		/*sessionFactBuilder.addAnnotatedClass(User.class);*/
		sessionFactBuilder.scanPackages("com");
		
		return sessionFactBuilder.buildSessionFactory();
	}
    
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(){
		HibernateTransactionManager txm = new HibernateTransactionManager(getSessionFactory());
		return txm;	
	}
}