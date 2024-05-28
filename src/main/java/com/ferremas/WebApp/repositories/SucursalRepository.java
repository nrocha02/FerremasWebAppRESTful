package com.ferremas.WebApp.repositories;

import com.ferremas.WebApp.entities.Sucursal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SucursalRepository extends MongoRepository<Sucursal, String> {
}
