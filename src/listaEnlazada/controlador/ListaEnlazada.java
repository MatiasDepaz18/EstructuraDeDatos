/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaEnlazada.controlador;

import nodo.controlador.Nodo;

/**
 *
 * @author PC
 * @param <T>
 */
public class ListaEnlazada <T>{
    private Nodo primero;
    private int tamaño=0;
    
    
    public static ListaEnlazada crearLista(){
        ListaEnlazada list=new ListaEnlazada();   
        return list;
    }
    
    public boolean esVacia(){ //O(|)
        return this.primero==null;
    }
    
    public void insertarAlInicio(T x){ //O(1)
        Nodo aux; 
        
        aux=new Nodo(x);
        aux.setSig(primero);
        primero=aux;
        tamaño++;
    }
    
    public void insertarAlFinal(T x){ //O(n)
        Nodo aux=primero;
        
        if(this.esVacia()){ // O(1)
            primero=new Nodo(x);
        }
        else{  //O(n)
            while(aux.getSig()!=null){ //Recorro la lista hasta encontrar el Nodo que apunte a null
                aux=aux.getSig();
            }
            aux.setSig(new Nodo(x));
        }
        tamaño++;
    }
    public void mostrar(Nodo aux){
        if(aux==null){
            
        }
        else{
            System.out.println(aux.getInfo());
            mostrar(aux.getSig());
        }
    }
    public void mostrar(){
       Nodo aux=primero;
       mostrar(aux);
    }
    
    public int cantidad(){
        return tamaño;
    }
    
    public void borrarPrimero(){
        if(!esVacia()){
            primero=primero.getSig();
        }
        tamaño--;
    }
    
    public void borrarUltimo(){
        Nodo aux=primero;
        
        if(aux.getSig()==null){ //Borra si solo hay un elemento
            borrarPrimero();
            return;
        }
        
        while(aux.getSig().getSig()!=null){
            System.out.println("Dato:"+aux.getInfo());
           aux=aux.getSig();
        }       
        aux.setSig(null);
        tamaño--;
    }
    
    public boolean pertenece(T buscado){
        return this.pertenece(buscado, primero);
    }
    private boolean pertenece(T buscado,Nodo aux){
        if(buscado==null || aux== null){
            return false;
        }
        else{
            System.out.println(aux.getInfo().toString());
            if(buscado==aux.getInfo()){
                return true;
            }
            return (this.pertenece(buscado,aux.getSig()));
        }
    }
    
    public void borrarConValor(T buscado){
        Nodo aux=primero;       
        if(pertenece(buscado)){  
            
            while(aux.getInfo()==buscado){ //Si los datos estan al principio
                aux=aux.getSig();
                primero=aux;
                tamaño--;
            }
            
            while(aux.getSig()!=null){
                
                if(aux.getSig().getInfo()==buscado){                   
                    if(aux.getSig().getSig()==null){
                        aux.setSig(null);
                        tamaño--;
                        break;
                    }
                Nodo borrador=aux.getSig().getSig(); 
                aux.setSig(borrador);    
                tamaño--;
                }
            aux=aux.getSig();
          }
        }            
    }

    public void borrarEnPosicion(int posicion){
        Nodo aux=primero; 
       int contador=0;
       
       if(posicion==0){// Si mi posicion a borrar es la primera, entonces salto 1 lugar
           primero=aux.getSig();
           tamaño--;
           return;
       }
       
        if(posicion<this.cantidad()){//Compruebo si existe esa posicion
            while(!(contador==posicion-1)){ //Que llegue hasta la posicion anterior a borrar
               contador++;
               aux=aux.getSig();
            }
            Nodo borrador=aux.getSig().getSig();
            aux.setSig(borrador); 
            tamaño--;
        }
        else{
            throw new IndexOutOfBoundsException();
        }     
    }
    
    public T dameValorEnPosicion(int posicion){
        Nodo aux=primero;        
        int contador=0;
        try{
           if(posicion>=0 && posicion<this.cantidad()){
                while(contador<posicion){
                    contador++;
                    aux=aux.getSig();
                } 
                return (T) aux.getInfo();
            }
            else{
            throw new IndexOutOfBoundsException();
            }  
        }     
        catch(IndexOutOfBoundsException e){
            throw e;
        }
    }
    
    public void modificarValorEnPosicion(T valor, int posicion){
       Nodo aux=primero;
       int contador=0;
        
       if(posicion>=0 && posicion<this.cantidad()){
          while(!(contador==posicion)){
             contador++;
             aux=aux.getSig();
          } 
          aux.setInfo(valor);
       }
       else{
           throw new IndexOutOfBoundsException();
       }
    }
    
    public void insertarEnPosicion(T valor, int posicion){
        Nodo aux=primero;
        Nodo nuevoNodo=new Nodo(valor);
        int contador=0;
        
        if(posicion>=0 && posicion<this.cantidad()){
            
            if(posicion==0){ //Si mi posicion es la inicial entonces hago el cambio con primero
              this.insertarAlInicio(valor);
              tamaño++;
              return;
            }
            while(!(contador==posicion-1)){
                contador++;
                aux=aux.getSig();
            }
            nuevoNodo.setSig(aux.getSig());
            aux.setSig(nuevoNodo);
            tamaño++;
        }
        else{
            throw new NullPointerException();
        }
     
    }  
    
    public int sumEnt(int umbral,Nodo aux){
        
        if(aux.getSig()==null){
            return 0;
        }    
        else{
            if((Integer)aux.getInfo()>umbral){
                System.out.println(aux.getInfo());
                return((Integer)aux.getInfo()+sumEnt(umbral,aux.getSig()));
            }
            else{
                System.out.println(aux.getInfo());
                return(sumEnt(umbral,aux.getSig()));
            }
        }
    }
    
    public int sumEnt(int umbral){
        Nodo aux=primero;
        return(sumEnt(umbral,aux));
    }
    
    
    //Para mayor comodidad se mostrara el primer y el ultimo dato
    public int verPrimero(){
        if(!esVacia()){
            return (Integer)primero.getInfo();
        }
        return 0;
    }
    
    public int verUltimo(){
        Nodo aux=primero;
        
        while(aux.getSig()!=null){
            aux=aux.getSig();
        }
        return (Integer)aux.getInfo();
    }
    
    
}
