package com.api.java.api_products_2826505.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.java.api_products_2826505.entities.Product;

@Repository
public interface  ProductRepository 
       extends  CrudRepository <Product , Long>{
    //repositorio por cada entidad 

}
