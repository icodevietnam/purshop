package com.icoding.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ AppConstant.APP_PACKAGE })
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { AppConstant.APP_PACKAGE_DOMAIN });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(DatabaseConstant.DATABASE_DRIVER);
		datasource.setUrl(DatabaseConstant.DATABASE_URL);
		datasource.setUsername(DatabaseConstant.DATABASE_USERNAME);
		datasource.setPassword(DatabaseConstant.DATABASE_PASSWORD);
		return datasource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DatabaseConstant.DATABASE_DIALECT);
		properties.put("hibernate.show_sql", DatabaseConstant.DATABASE_SHOW_SQL);
		properties.put("hibernate.hbm2ddl.auto", DatabaseConstant.DATABASE_HBM2DLL_AUTO);
		properties.put("hibernate.flushmode", DatabaseConstant.DATABASE_FLUSHMODE);
		properties.put("hibernate.connection.CharSet", DatabaseConstant.DATABASE_CONNECTION_CHARSET);
		properties.put("hibernate.connection.characterEncoding",
				DatabaseConstant.DATABASE_CONNECTION_CHARACTER_ENCODING);
		properties.put("hibernate.enable_lazy_load_no_trans", DatabaseConstant.DATABASE_ENABLE_LAZY_LOAD);
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
