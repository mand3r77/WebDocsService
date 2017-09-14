package com.uscs.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = { "classpath:uatJdbc.properties" })
public class UatConfiguration {

	private static final String CONNECT_TEST_QUERY = "SELECT 1 FROM SYSIBM.SYSDUMMY1";
	
	private @Value("${jdbc.uatdb2.driverClassName}") String uatdb2DriverClassName;
	private @Value("${jdbc.uatdb2.db.url}") String uatdb2JdbcUrl;
	private @Value("${jdbc.uatdb2.db.user}") String uatdb2Username;
	private @Value("${jdbc.uatdb2.db.pwd}") String uatdb2Password;
	
	private @Value("${jdbc.utstdb2.driverClassName}") String utstdb2DriverClassName;
	private @Value("${jdbc.utstdb2.db.url}") String utstdb2JdbcUrl;
	private @Value("${jdbc.utstdb2.db.user}") String utstdb2Username;
	private @Value("${jdbc.utstdb2.db.pwd}") String utstdb2Password;

	private @Value("${jdbc.devdb2.driverClassName}") String devdb2DriverClassName;
	private @Value("${jdbc.devdb2.db.url}") String devdb2JdbcUrl;
	private @Value("${jdbc.devdb2.db.user}") String devdb2Username;
	private @Value("${jdbc.devdb2.db.pwd}") String devdb2Password;
	
	/*@Bean
	public DataSource uatdb2() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(uatdb2DriverClassName);
		config.setJdbcUrl(uatdb2JdbcUrl);
		config.setUsername(uatdb2Username);
		config.setPassword(uatdb2Password);
		config.setConnectionTestQuery(CONNECT_TEST_QUERY);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}*/

	/*@Bean
	public DataSource utstdb2() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(utstdb2DriverClassName);
		config.setJdbcUrl(utstdb2JdbcUrl);
		config.setUsername(utstdb2Username);
		config.setPassword(utstdb2Password);
		config.setConnectionTestQuery(CONNECT_TEST_QUERY);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}*/

	@Bean
	public DataSource devdb2() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(devdb2DriverClassName);
		config.setJdbcUrl(devdb2JdbcUrl);
		config.setUsername(devdb2Username);
		config.setPassword(devdb2Password);
		config.setConnectionTestQuery(CONNECT_TEST_QUERY);
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}
}
