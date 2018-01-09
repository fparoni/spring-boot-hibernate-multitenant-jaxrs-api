package com.krabdev.multitenancy.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.krabdev.multitenancy.CurrentTenantIdentifierResolverImpl;
import com.krabdev.multitenancy.DataSourceBasedMultiTenantConnectionProviderImpl;

@Configuration
@EnableConfigurationProperties(MultitenancyConfigurationProperties.class)
public class MultitenancyConfiguration {

	@Autowired
	private MultitenancyConfigurationProperties multitenancyProperties;

	@Bean(name = "multitenantProvider")
	public DataSourceBasedMultiTenantConnectionProviderImpl dataSourceBasedMultiTenantConnectionProvider() {
		HashMap<String, DataSource> dataSources = new HashMap<>();

		multitenancyProperties.getTenants().stream().forEach(
				tc -> dataSources.put(tc.getName(), DataSourceBuilder.create().driverClassName(tc.getDriverClassName())
						.username(tc.getUsername()).password(tc.getPassword()).url(tc.getUrl()).build()));

		return new DataSourceBasedMultiTenantConnectionProviderImpl(multitenancyProperties.getDefaultTenant().getName(),
				dataSources);
	}

	@Bean
	@DependsOn("multitenantProvider")
	public DataSource defaultDataSource() {
		return dataSourceBasedMultiTenantConnectionProvider().getDefaultDataSource();
	}

	@Bean
	public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
		return new CurrentTenantIdentifierResolverImpl();
	}

}