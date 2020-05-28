package com.style.datastax.product.dao;

import com.style.datastax.product.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface IProductRepository extends CassandraRepository<Product, String> {

    void deleteById(UUID Id);

    @Cacheable("product-id")
    Product findById(UUID Id);

    @Cacheable("products")
    List<Product> findAll();

    void save(String productName);
}
