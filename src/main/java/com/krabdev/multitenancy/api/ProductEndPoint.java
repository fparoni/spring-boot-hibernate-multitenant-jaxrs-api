package com.krabdev.multitenancy.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.krabdev.multitenancy.data.ProductRepository;
import com.krabdev.multitenancy.data.Products;

@Component
@Path("/api")
public class ProductEndPoint {
	
	@Autowired
	private ProductRepository productRepository;

	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Products> products() {
		List<Products> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

}
