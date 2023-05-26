/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import calculadora.controlador.Calculadora;
import calculadora.controlador.Pila;
import listaEnlazada.controlador.ListaEnlazada;
import operando.controlador.Operandos;
import redSocial.controlador.RedSocial;
import usuario.controlador.Usuario;

/**
 *
 * @author matu_
 */
public class TP4main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Usuario user=new Usuario("Matias","Depaz");
//        Usuario user1=new Usuario("Marcos","Herrera");
//        Usuario user2=new Usuario("X","D");  
//        Usuario user3=new Usuario("asd","sadas");
//        ListEnlazada lista;
//        RedSocial red,red2;
//        red=RedSocial.crearRedSocial();
//        red2=RedSocial.crearRedSocial();
//        lista=ListEnlazada.crearLista();
//        
//        lista.insertarAlInicio(user);
//        lista.insertarAlFinal(user1);
//        lista.insertarAlFinal(user2);       
//        lista.mostrar();
//        lista.borrarEnPosicion(1);
//        lista.mostrar();
//        red.registrar(user1);
//        red.registrar(user3);
//        RedSocial red1=RedSocial.crearRedSocial();
//        red1.registrar(user2);
//        red1.registrar(user1);
//        System.out.println(red.cantidad()+ "+"+red1.cantidad()+ red.ultimoUsuario().toString());
//        red2=red.union(red1);
//        System.out.println(red2.cantidad() + red2.ultimoUsuario().toString());
//        
//        
        Calculadora calculadora;
        calculadora=Calculadora.crearCalculadora();

        String posfija=calculadora.convertirAPostfija("A*B+C-D");
        System.out.println(posfija);
    }
    
}
