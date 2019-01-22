/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author thepu
 */
@Entity
public class Pedido {
     @Id
    @GeneratedValue
    private long id;
    private String calle;
    private String estado;
    private int uds;
    private String empresa;

    public Pedido(long id, String calle, String estado, int uds, String empresa) {
        this.id = id;
        this.calle = calle;
        this.estado = estado;
        this.uds = uds;
        this.empresa = empresa;
    }
    
    public Pedido(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getUds() {
        return uds;
    }

    public void setUds(int uds) {
        this.uds = uds;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    
    
    
    
}
