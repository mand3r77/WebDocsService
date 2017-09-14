package com.uscs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration
@ImportResource({ "classpath:META-INF/spring/configurationBean.xml" })
@PropertySource(value = { "classpath:uatJdbc.properties" })
public class UatConfiguration {

	private static final String CONNECT_TEST_QUERY = "SELECT 1 FROM SYSIBM.SYSDUMMY1";
	
	private @Value("${jdbc.uat.driverClassName}") String driverClassName;
	private @Value("${jdbc.uat.db.url}") String jdbcUrl;
	private @Value("${jdbc.uat.db.user}") String username;
	private @Value("${jdbc.uat.db.pwd}") String password;
	
	
	
	@Bean
	public DataSource uatDataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(driverClassName);
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.setConnectionTestQuery(CONNECT_TEST_QUERY);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}

}
