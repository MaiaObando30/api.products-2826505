package com.api.java.api_products_2826505.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.java.api_products_2826505.entities.Product;
import com.api.java.api_products_2826505.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //metodos 
    //READ
    public List<Product> findAll(){
        return (List<Product>) 
            repository.findAll();
        
    }

    //read by id

    public Product findById (long id){
        return repository.findById(id)
            .get();
    }
    //insertar:
    public Product create(Product productoAGrabar){
        return repository.save(productoAGrabar);
    }

    //eliminar
    public Product borrar (Long id){
        //selecionar el producto por id 
        Product pBorrar = this.findById(id);
        //borrar
        repository.delete(pBorrar);
        return pBorrar;
    }
    //actualizar
    public Product actualizar(Long id , 
                                 Product pUpdate){
    //1. ENCONTAR EL PRODUCTO A ACTUALIZAR
    Product p = this.findById(id);
    // 2. actualizar atributos del payload 
    p.setName(pUpdate.getName());
    p.setDescription(pUpdate.getDescription());
    p.setPrice(pUpdate.getPrice());
    //3. grabar cambios 
    return repository.save(p);
    }

}
