package com.style.datastax.product.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
@EnableCassandraRepositories(basePackages = "com.style.datastax.product.model")
@PropertySource(value = { "classpath:application.conf" })
public class CassandraConfiguration {

    @Value("${cassandra.keyspaceName}")
    public String keyspaceName;

    @Bean
    public CqlIdentifier keyspace() {
        return CqlIdentifier.fromCql(keyspaceName);
    }

    @Bean
    public CqlSession cqlSession() {
        return CqlSession.builder().build();
    }

    public String getKeyspaceName() {
        return keyspaceName;
    }

    public void setKeyspaceName(String keyspaceName) {
        this.keyspaceName = keyspaceName;
    }
}
