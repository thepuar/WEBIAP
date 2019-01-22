/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

/**
 *
 * @author thepu
 */

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String designacion;
    private double precio;

    public Producto() {
        super();
    }

    public Producto(int id, String designacion, double precio) {
        super();
        this.id = id;
        this.designacion = designacion;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignacion() {
        return designacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
