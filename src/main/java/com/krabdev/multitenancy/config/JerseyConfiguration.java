package com.krabdev.multitenancy.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.krabdev.multitenancy.api.JerseyFilter;
import com.krabdev.multitenancy.api.ProductEndPoint;

@Configuration
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration () {
		registerEndPoints();
	}

	private void registerEndPoints() {
		register(ProductEndPoint.class);
		register(JerseyFilter.class);
	}
}
