package com.style.datastax.product.services;



import com.style.datastax.product.dao.IProductRepository;
import com.style.datastax.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> findAll() {
        //System.out.println("productRepository = " + productRepository);
        return (List<Product>) productRepository.findAll();

        
    }

    public void save(Product product) {

        productRepository.save(product);
    }

    public void deleteById(UUID productId) {
        productRepository.deleteById(productId);
    }

    public Product findById(UUID productId) {
        return productRepository.findById(productId);
    }

}