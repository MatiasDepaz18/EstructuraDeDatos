/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import servidor.controlador.Servidor;

/**
 *
 * @author matu_
 */
public class TP6Main {
    public static void main(String[] args) {
        Servidor server = Servidor.crearServidor(2000);
        server.procesar();
        System.out.println("Cantidad de Peticiones Atendidas: " + (server.getPeticionaPrioritariaAtendidas() + server.getPeticionaComunesAtendidas()));
        
        System.out.println("Cantidad de Peticiones Prioritarias Atendidas: " + server.getPeticionaPrioritariaAtendidas());
        System.out.println("Cantidad de Peticiones Comunes Atendidas: " + server.getPeticionaComunesAtendidas());
        System.out.println("Cantidad de Peticiones Prioritarias sin Atender: " + server.getFilaPrioridad().cantidad());
        System.out.println("Cantidad de Peticiones Comunes sin Atender: " + server.getFilaComun().cantidad());
        System.out.println("Tiempo Maximo de Espera Prioritaria: " + server.getFilaPrioridad().esperaMaxima());
        System.out.println("Tiempo Maximo de Espera Comun: " + server.getFilaComun().esperaMaxima());
        System.out.println("Tiempo total del servidor inactivo: " + server.getTiempoInactivo());
        System.out.println("Tamano Maximo Prioritario: " + server.getFilaPrioridad().longitudMaxima());
        System.out.println("Tamano Maximo Comun: " + server.getFilaComun().longitudMaxima());
  
    }
}
