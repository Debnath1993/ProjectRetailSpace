package com.niit.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.niit.Backend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private String DATABASE_URL      = "jdbc:h2:tcp://localhost/~/niit";
	private String DATABASE_DRIVER   = "org.h2.Driver";
	private String DATABASE_DIALECT  = "org.hibernate.dialect.H2Dialect";
	private String DATABASE_USERNAME = "niitstudent";
	private String DATABASE_PASSWORD = "";

	// dataSource bean will be available
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
				
		
		return dataSource;
		
	}
	
	// sessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.niit.Backend.dto");
		
		return builder.buildSessionFactory();
		
	}

	
	
	// All the hibernate properties will be returned in this method	
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		
		return properties;
	}
	
	// transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
}