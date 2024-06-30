package com.ferremas.WebApp.repositories;

import com.ferremas.WebApp.entities.Empleado;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
}