package com.ferremas.WebApp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ferremas.WebApp.entities.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}
