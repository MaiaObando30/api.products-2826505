package com.api.java.api_products_2826505.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.java.api_products_2826505.entities.Product;
import com.api.java.api_products_2826505.services.ProductService;




@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired

    private ProductService servicio;

    //primer endpoint
    //traes todos los productos
    //Traer: peticiones de GET 
    @GetMapping("/productos")
    public List<Product> findAllProducts () {

       // Utilizar el servcio para 
       //traer los productos 
       //Necesitamos una instancia
       //del servicio en el controller 
       return servicio.findAll();

    }

    //Segundo enpoint
    //Traer un producto por id
    //Metodo Http:GET
    @GetMapping("/productoporid/{id}")
    public Product findProductById(
           @PathVariable Long id) {
        return servicio.findById(id);
    }
    
    //Tercer endpoint
    //grabar un nuevo producto
    //que llegue por el body de la request(payload)

    @PostMapping("/nuevoproducto")
    public Product newProduct (@RequestBody Product p) {
        return servicio.create(p);

    }

    //cuarto endpoint
    //borrar un producto por id
    //Method Http:delete
    @DeleteMapping("/borrarporid/{id}")
    public Product deleteProductById(@PathVariable Long id){
        return servicio.borrar(id);
    }
    
    //quinto endpoint
    @PutMapping("actualizarporid/{id}")
    public Product updateProduct (
        @PathVariable Long id, 
        @RequestBody Product p) {
        
            return servicio.actualizar(id, p);
}

}
