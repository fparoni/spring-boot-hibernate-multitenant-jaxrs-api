package com.krabdev.multitenancy.data;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Products, Long> {

}
