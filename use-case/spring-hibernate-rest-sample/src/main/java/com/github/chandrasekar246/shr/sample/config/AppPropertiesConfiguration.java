package com.github.chandrasekar246.shr.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@Data
public class AppPropertiesConfiguration {

	@Value("${test.string}")
	private String testString;
	
	@Value("${datasource.driver}")
	private String dataSourceDriver;
	
	@Value("${datasource.url}")
	private String dataSourceUrl;
	
	@Value("${datasource.user}")
	private String dataSourceUser;
	
	@Value("${datasource.password}")
	private String dataSourcePassword;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateDdlAuto;
	
	@Value("${hibernate.validator.apply_to_ddl}")
	private String hibernateApplyValidatorToDdl;
	
	@Value("${hibernate.check_nullability}")
	private String hibernateCheckNullability;
}
