/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.ArrayList;
import java.util.List;
import com.model.Producto;
import org.springframework.stereotype.Service;

/**
 *
 * @author thepu
 */
@Service
public class ProductoService {
    
    public  ProductoService(){
        
    }
    
    public List<Producto> poblate(){
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Raqueta", 12.50));
        productos.add(new Producto(2, "Ventana PVC", 199));
        productos.add(new Producto(3, "Plancha", 29.95));
        productos.add(new Producto(4, "Teclado", 9.95));
        productos.add(new Producto(5, "Flexo", 8.50));
        
        return productos;
    }
}
