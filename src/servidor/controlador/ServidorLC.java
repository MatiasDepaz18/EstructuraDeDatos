/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controlador;

import java.util.Random;
import listaCircular.controlador.ListaCircular;
import peticion.controlador.PeticionLC;

/**
 *
 * @author matu_
 */
public class ServidorLC {
    public static ServidorLC server=null; 
    public static int tiempoActual=0;
    private int tiempoTotal;
    private int tiempoInactivo=0;
    private int cuanto;
    private int cuantoRestante;
    private ListaCircular listaC=ListaCircular.LCVacia();
    private PeticionLC enCurso;
    private int peticionesAtendidas=0;
    
    private ServidorLC(int tiempoTotal, int cuanto){
        this.tiempoTotal=tiempoTotal;
        this.cuanto=this.cuantoRestante=cuanto;
    }
    
    public static ServidorLC crearServidor(int tiempoTotal, int cuanto){
        if(server==null){
            server=new ServidorLC(tiempoTotal,cuanto);
        }
        return server;
    }
    
    public static PeticionLC nuevaPeticion(){
        
        Random random=new Random();
        int duracion;
        
        if(random.nextInt(100)==1){
            duracion=random.nextInt(250)+50;           
            return new PeticionLC(duracion);
        }
        else{
            return null;
        }
    }
    
    public void procesar(){
        
        while(ServidorLC.tiempoActual<this.tiempoTotal){
            PeticionLC peticion=nuevaPeticion();

            if(peticion!=null){
                this.listaC.lCInsertar(peticion);
            }
            
            if(this.cuantoRestante>0){  //Me fijo si hay una peticion en curso y si no hay le asigno una                        
                if(this.enCurso==null || this.enCurso.procesar()==0){
                    if(this.enCurso!=null){
                        while(this.listaC.lCValor()!=this.enCurso){
                            this.listaC.lCRotar();
                        }
                        this.listaC.borrarLista();
                        this.enCurso=null;
                        this.peticionesAtendidas++;
                    }
                    if(!this.listaC.esLCVacia()){
                        this.enCurso=this.listaC.lCValor();
                    }                           
                }
                this.cuantoRestante--;
            }          
            
            else if(!this.listaC.esLCVacia()){  //Cambio de peticion Rotando la lista
                this.listaC.lCRotar();
                this.enCurso=this.listaC.lCValor();
                this.cuantoRestante=this.cuanto;
            }
            
            if(this.enCurso==null){  //Aumento el tiempo si no hay peticiones 
                this.tiempoInactivo++;
            }
            ServidorLC.tiempoActual++;
        }
    }
    
    
    public static ServidorLC getServer() {
        return server;
    }

    public static void setServer(ServidorLC server) {
        ServidorLC.server = server;
    }

    public static int getTiempoActual() {
        return tiempoActual;
    }

    public static void setTiempoActual(int tiempoActual) {
        ServidorLC.tiempoActual = tiempoActual;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public int getTiempoInactivo() {
        return tiempoInactivo;
    }

    public void setTiempoInactivo(int tiempoInactivo) {
        this.tiempoInactivo = tiempoInactivo;
    }

    public ListaCircular getListaC() {
        return listaC;
    }

    public void setListaC(ListaCircular listaC) {
        this.listaC = listaC;
    }

    public PeticionLC getEnCurso() {
        return enCurso;
    }

    public void setEnCurso(PeticionLC enCurso) {
        this.enCurso = enCurso;
    }
    

    public int getPeticionesAtendidas() {
        return peticionesAtendidas;
    }

    public void setPeticionesAtendidas(int peticionesAtendidas) {
        this.peticionesAtendidas = peticionesAtendidas;
    }

    public int getCuanto() {
        return cuanto;
    }

    public void setCuanto(int cuanto) {
        this.cuanto = cuanto;
    }

    public int getCuantoRestante() {
        return cuantoRestante;
    }

    public void setCuantoRestante(int cuantoRestante) {
        this.cuantoRestante = cuantoRestante;
    }
    
    
    
}
