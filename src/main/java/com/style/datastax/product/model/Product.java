package com.style.datastax.product.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.CassandraType.Name;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;

@Table(value = "product")
@Data
public class Product implements Serializable {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = Name.UUID)
    private UUID id;

    public Product(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.created = new Date();
    }

    @CassandraType(type = Name.VARCHAR)
    private String name;

    @CassandraType(type = Name.VARCHAR)
    private String description;

    @CassandraType(type = Name.VARCHAR)
    private String brand;

    @CassandraType(type = Name.VARCHAR)
    private String category;

    @CassandraType(type = Name.DECIMAL)
    private Float price;

    @CassandraType(type = Name.TIMESTAMP)
    private Date created;

}
