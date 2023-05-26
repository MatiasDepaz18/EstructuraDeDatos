/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaCircular.controlador;

import java.util.NoSuchElementException;
import listaEnlazada.controlador.ListaEnlazada;
import nodo.controlador.Nodo;
import peticion.controlador.PeticionLC;

/**
 *
 * @author matu_
 */
public class ListaCircular {
    class Nodo{
        private Nodo sig;
        private PeticionLC info;

        public Nodo(PeticionLC info) {
            this.info = info;
        }

        public Nodo getSig() {
            return sig;
        }

        public void setSig(Nodo sig) {
            this.sig = sig;
        }

        public PeticionLC getInfo() {
            return info;
        }

        public void setInfo(PeticionLC info) {
            this.info = info;
        }
        
    }
        
   private ListaEnlazada<PeticionLC> lista;
    private Nodo lc;
    private int cantidad=0,longitudMax=0,esperaMax=0;
    
    private ListaCircular(){
        lista=ListaEnlazada.crearLista();
    }
    
    public static ListaCircular LCVacia(){
        ListaCircular listaCir=new ListaCircular();
        return listaCir;
    }
    
    public boolean esLCVacia(){
        return this.lc==null;
    }
    
    public void lCInsertar(PeticionLC peticion){
        Nodo nuevoNodo;
        nuevoNodo=new Nodo(peticion);
        
        if(this.esLCVacia()){
            this.lc=nuevoNodo;
            this.lc.setSig(this.lc);
        }
        else{
            nuevoNodo.setSig(this.lc.getSig());
            this.lc.setSig(nuevoNodo);
        } 
        this.cantidad++;
        if(this.cantidad>this.longitudMax){
            longitudMax=cantidad;
        }
    }
    
    
    public void borrarLista(){
        if(this.esLCVacia()){
            this.lc=null;
        }
        else{
            if(lc.getSig().getInfo().espera()>this.esperaMax){
                this.esperaMax=lc.getSig().getInfo().espera();
            }
            if(this.lc==this.lc.getSig()){
                this.lc=null;
            }
            else{
                this.lc.setSig(lc.getSig().getSig());
            }
            this.cantidad--;
        }
        
    }
    
    public PeticionLC lCValor(){
        if(this.esLCVacia()){
            throw new  NoSuchElementException("Lista Vacia");
        }
        else{
            Nodo aux=this.lc.getSig();
            return aux.getInfo();
        }
    }
    
    public void lCRotar(){
        if(!this.esLCVacia()){
            this.lc=this.lc.getSig();
        }
    }
    
    public int esperaMax(){
        return this.esperaMax;
    }
    
    public int longitudMax(){
        return this.longitudMax;
    }
    
    public int cantidad(){
        return this.cantidad;
    }
}
