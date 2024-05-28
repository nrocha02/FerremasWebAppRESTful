package com.ferremas.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ferremas.entidades.Producto;

public interface ProductoInterface extends MongoRepository<Producto, String> {

}
