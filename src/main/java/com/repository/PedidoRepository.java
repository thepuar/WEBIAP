/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository;

import com.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author thepu
 */
public interface PedidoRepository extends JpaRepository<Pedido,Long>{
    
}
