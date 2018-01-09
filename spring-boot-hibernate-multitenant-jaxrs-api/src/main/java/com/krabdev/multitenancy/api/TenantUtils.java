package com.krabdev.multitenancy.api;

public class TenantUtils {
    
   private static final String DEFAULT_TENANT_ID = "tenant_1";
   
   private static ThreadLocal<String> tenantThreadLocal = new ThreadLocal<>();

   public static final String getCurrentTenantIdentifier() {
       return tenantThreadLocal.get() != null ? tenantThreadLocal.get() : DEFAULT_TENANT_ID;
   }
   
   public static final void setCurrentTenantIdentifier(String tenantId) {
	   tenantThreadLocal.set(tenantId);
   }

}
