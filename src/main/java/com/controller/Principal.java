/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.Pedido;
import com.rabbit.RabbitMqConfig;
import com.repository.PedidoRepository;
import com.repository.ProductoRepository;
import com.service.ProductoService;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thepu
 */
@Controller
public class Principal {

    // @Autowired
    // ProductoRepository productorepo;
    @Autowired
    ProductoService productoserv;

    @Autowired
    ProductoRepository productorep;

    @Autowired
    PedidoRepository pedidorep;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public Principal(ProductoRepository rep, ProductoService serv, PedidoRepository pedrep, RabbitTemplate rabbit) {
        this.productorep = rep;
        this.productoserv = serv;
        this.pedidorep = pedrep;
        this.rabbitTemplate = rabbit;

    }

    @RequestMapping("/")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView("hola");
        Map<String, String> tipostransportes = new HashMap<String, String>();
        tipostransportes.put("correos", "CORREOS - Normal");
        tipostransportes.put("dhl", "DHL - Urgente");
        mav.addObject("tipostransportes", tipostransportes);
        mav.addObject("productos", this.productoserv.poblate());
        mav.addObject("pedido", new Pedido());
        return mav;
    }

    @RequestMapping("/pedidos")
    public ModelAndView pedidos() {
        ModelAndView mav = new ModelAndView("success");
        List<Pedido> lpedidos = this.pedidorep.findAll();
        mav.addObject("pedidos", lpedidos);

        return mav;
    }

    @RequestMapping(value = "/pedidos/add", method = RequestMethod.POST)
    public ModelAndView pedidoAdd(@ModelAttribute("pedido") Pedido pedido) {
        pedido.setEstado("Creado");
        pedido = this.pedidorep.save(pedido);
        ModelAndView mav = new ModelAndView("success");
        List<Pedido> lpedidos = this.pedidorep.findAll();
        mav.addObject("pedidos", lpedidos);
        
          //JSON
        Gson gson = new Gson();
        Type type = new TypeToken<Pedido>() {}.getType();
        String json = gson.toJson(pedido,type);
        
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, RabbitMqConfig.ROUTING_KEY, json);

        return mav;
    }
}
