package com.ferremas.WebApp.repositories;

import com.ferremas.WebApp.entities.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VentaRepository extends MongoRepository<Venta, String> {
}
