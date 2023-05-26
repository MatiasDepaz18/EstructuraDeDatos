package calculadora.controlador;


import listaEnlazada.controlador.ListaEnlazada;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matu_
 */
public class Pila <T> {
    
    private ListaEnlazada<T> lista;
    
    private Pila() {
        lista = new ListaEnlazada<T>();
    }
    
    public static <T> Pila<T> crearPila() {
        Pila<T> pila=new Pila();
        return pila;
    }
    
    public boolean esPilaVacia(){
        return lista.esVacia();
    }
    
    public void push(T valor){
        lista.insertarAlInicio(valor);
    }
    
    public void pop(){
        lista.borrarPrimero();
    }
    
    public T top(){
        return lista.dameValorEnPosicion(0);
    }
    
    public T fondo(){
        return lista.dameValorEnPosicion(lista.cantidad()-1);
    }
    
    public void mostrar(){
        lista.mostrar();
    }
}   

