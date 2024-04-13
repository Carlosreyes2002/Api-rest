package com.miempresa.tiendaenlinea;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private String descripcion;
    private double precio;

    // Constructor, Getters y Setters
}


