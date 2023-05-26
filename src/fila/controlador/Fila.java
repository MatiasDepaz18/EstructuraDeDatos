/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fila.controlador;

import peticion.controlador.Peticion;

/**
 *
 * @author matu_
 */

public class Fila  {
    private int esperaMaxima=0, maximo=0,cantidad=0;
    private Nodo ultimo;
    private Nodo primero;  
    
    private class Nodo{
        private Peticion dato;
        private Nodo sig;

        public Nodo(Peticion dato) {
            this.dato = dato;
        }
        
        
        public Peticion getDato() {
            return dato;
        }

        public void setDato(Peticion dato) {
            this.dato = dato;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }
        
         
    }
    
    
    public static Fila crearFila(){
        Fila fila=new Fila();
        return fila;
    }
   
    public Boolean esFilaVacia(){   
        return this.primero==null;
    }
    
    public Peticion frente(){
        return this.primero.getDato();
    }
    
    public void enfila(Peticion item){
        Nodo aux=new Nodo(item);
        
        if(this.esFilaVacia()){
            this.primero=aux;
            this.ultimo=aux;
        }
        else{
            this.ultimo.setSig(aux);
            this.ultimo=aux;
        }
        this.cantidad++;
        if(this.maximo< this.cantidad){
            this.maximo=this.cantidad;
        }
        
    }
    
    public void defila(){
        if(!this.esFilaVacia()){
            if(this.primero.dato.espera()> this.esperaMaxima){
               this.esperaMaxima=this.primero.dato.espera();
               this.primero=this.primero.getSig();
               this.cantidad--;
            }
        }
    }
    
    public int cantidad(){
        return this.cantidad;
    }
    public int esperaMaxima(){
        return this.esperaMaxima;
    }
    public int longitudMaxima(){
        return this.maximo;
    }
  
}
