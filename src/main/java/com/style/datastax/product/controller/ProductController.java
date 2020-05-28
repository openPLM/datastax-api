package com.style.datastax.product.controller;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.style.datastax.product.model.Product;
import com.style.datastax.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 */

@Controller
@RequestMapping("/api/v1/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<String> test() {

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> products(@ModelAttribute("model") ModelMap model) {

    //    CacheControl cacheControl = CacheControl.maxAge(30, TimeUnit.MINUTES);
        List<Product> ls = productService.findAll();
        return new ResponseEntity<List<Product>>(ls, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> findProductsByName(@PathVariable UUID productId) {
        Product productRetreived = productService.findById(productId);
        return new ResponseEntity<Product>(productRetreived, HttpStatus.OK);
    };

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> delete(@PathVariable UUID productId) {
        productService.deleteById(productId);
        return new ResponseEntity<String>(String.valueOf(productId), HttpStatus.OK);
    }

    @PostMapping("/product/{productName}")
    public ResponseEntity<String> add(@PathVariable String productName) {
        productService.save(new Product(productName));
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
