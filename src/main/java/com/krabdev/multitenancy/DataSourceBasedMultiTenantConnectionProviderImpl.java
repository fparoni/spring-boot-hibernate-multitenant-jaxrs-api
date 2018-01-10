package com.krabdev.multitenancy;

import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;

public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final long serialVersionUID = 1L;

    private String defaultTenant;

    private Map<String, DataSource> map;

    public DataSourceBasedMultiTenantConnectionProviderImpl(String defaultTenant, Map<String, DataSource> map) {
        super();
        this.defaultTenant = defaultTenant;
        this.map = map;
    }

    @Override
    protected DataSource selectAnyDataSource() {
     return map.get(defaultTenant);
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
     return map.get(tenantIdentifier);
    }

    public DataSource getDefaultDataSource() {
        return map.get(defaultTenant);
    }

    
}
