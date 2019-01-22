/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabbit;

/**
 *
 * @author thepu
 */
public class Receiver {
     public static final String RECEIVE_METHOD_NAME = "receiveMessage";
 
    public void receiveMessage(String message) {
        System.out.println("[Receiver] ha recibido el mensaje \"" + message + '"');
    }
}
