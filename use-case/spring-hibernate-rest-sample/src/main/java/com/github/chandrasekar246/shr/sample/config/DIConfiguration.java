
package com.github.chandrasekar246.shr.sample.config;

import java.util.Arrays;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.github.chandrasekar246.shr.sample" })
@EnableTransactionManagement
public class DIConfiguration {
	@Autowired
	private AppPropertiesConfiguration appPropertiesConfiguration;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(appPropertiesConfiguration.getDataSourceUrl(),
				appPropertiesConfiguration.getDataSourceUser(), appPropertiesConfiguration.getDataSourcePassword());

		dataSource.setDriverClassName(appPropertiesConfiguration.getDataSourceDriver());

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.github.chandrasekar246.shr.sample.entity");

		Properties hibernateProperties = new Properties(5);
		hibernateProperties.setProperty("hibernate.dialect", appPropertiesConfiguration.getHibernateDialect());
		hibernateProperties.setProperty("hibernate.show_sql", appPropertiesConfiguration.getHibernateShowSql());
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", appPropertiesConfiguration.getHibernateDdlAuto());
		hibernateProperties.setProperty("hibernate.validator.apply_to_ddl",
				appPropertiesConfiguration.getHibernateApplyValidatorToDdl());
		hibernateProperties.setProperty("hibernate.check_nullability",
				appPropertiesConfiguration.getHibernateCheckNullability());

		sessionFactoryBean.setHibernateProperties(hibernateProperties);

		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		return new HibernateTransactionManager(sessionFactory().getObject());
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}

	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
		requestMappingHandlerAdapter.setMessageConverters(Arrays.asList(mappingJackson2HttpMessageConverter()));
		return requestMappingHandlerAdapter;
	}

}
