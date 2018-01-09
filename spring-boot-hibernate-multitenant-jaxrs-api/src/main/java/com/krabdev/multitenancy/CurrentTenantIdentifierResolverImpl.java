package com.krabdev.multitenancy;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import com.krabdev.multitenancy.api.TenantUtils;

public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
    
     @Override
     public String resolveCurrentTenantIdentifier() {
         return TenantUtils.getCurrentTenantIdentifier();
     }
    
     @Override
     public boolean validateExistingCurrentSessions() {
         return true;
     }
}
