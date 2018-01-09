package com.krabdev.multitenancy.api;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class JerseyFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String tenantId = requestContext.getHeaderString("X-TENANT-ID");
		TenantUtils.setCurrentTenantIdentifier(tenantId);
	}

}
