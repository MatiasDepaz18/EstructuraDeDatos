/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import servidor.controlador.ServidorLC;
/**
 *
 * @author matu_
 */
public class TP7main {
    public static void main(String[] args){
        ServidorLC server = ServidorLC.crearServidor(2000, 10);
        server.procesar();
        System.out.println("Cantidad de Peticiones Atendidas: " + (server.getPeticionesAtendidas()));
        System.out.println("Cantidad de Peticiones sin Atender: " + server.getListaC().cantidad());
        System.out.println("Tiempo Maximo de Espera: " + server.getListaC().esperaMax());
        System.out.println("Tiempo total del servidor inactivo: " + server.getTiempoInactivo());
        System.out.println("Tamano Maximo: " + server.getListaC().longitudMax());
    }
}
