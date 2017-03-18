/**
 * 
 */
package com.xinxilanr.venus.dao.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author norris
 *
 */
@Configuration
@EnableTransactionManagement
public class HibernateConfigure {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.xinxilanr.venus.datamodel");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
		
	}
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("show_sql", "true");
		properties.setProperty("dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
		
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory.getObject());
		return transactionManager;
	}
}
