package com.krabdev.multitenancy.config;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "datasources")
public class MultitenancyConfigurationProperties {
    
    private Tenant defaultTenant;

    private List<Tenant> tenants = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        List<Tenant> tcs = tenants.stream().filter(tc -> tc.isDefault()).collect(Collectors.toCollection(ArrayList::new));
        if (tcs.size() > 1) {
            throw new IllegalStateException("Only can be configured as default one data source. Review your configuration");
        }
        this.defaultTenant = tcs.get(0);
    }
       
    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public Tenant getDefaultTenant() {
        return defaultTenant;
    }

    public static class Tenant {
        
        private String name;
        
        private boolean isDefault;
        
        private String driverClassName;

        private String url;

        private String username;

        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isDefault() {
            return isDefault;
        }

        public void setDefault(boolean isDefault) {
            this.isDefault = isDefault;
        }

    }

}
