package com.ferremas.WebApp.repositories;

import com.ferremas.WebApp.entities.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> { // Cambiado a Integer
}
