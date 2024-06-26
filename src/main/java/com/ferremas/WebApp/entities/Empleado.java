package com.ferremas.WebApp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "empleado")
public class Empleado {

    @Id
    private String id_empleado;
    private String nombre;
    private String apellido;
    private String puesto;

    @DBRef
    private Sucursal nom_sucursal;

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Sucursal getNom_sucursal() {
        return nom_sucursal;
    }

    public void setNom_sucursal(Sucursal nom_sucursal) {
        this.nom_sucursal = nom_sucursal;
    }

}
