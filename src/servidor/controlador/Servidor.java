/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.controlador;

import fila.controlador.Fila;
import java.util.Random;
import peticion.controlador.Peticion;

/**
 *
 * @author matu_
 */
public class Servidor {
    public static Servidor server=null; 
    public static int tiempoActual=0;
    private int tiempoTotal;
    private int tiempoInactivo=0;
    private Fila filaPrioridad=Fila.crearFila();
    private Fila filaComun=Fila.crearFila();
    private Peticion enCurso;
    private int peticionaPrioritariaAtendidas=0;
    private int peticionaComunesAtendidas=0;
       
    public Servidor(int tiempoTotal){
        this.tiempoTotal=tiempoTotal;
    }
    public static Servidor crearServidor(int tiempoTotal){
        if(server==null){
            server= new Servidor(tiempoTotal);
        }
        return server;
    }      
    
    public static Peticion nuevaPeticion(){
        
        Random random=new Random();
        int duracion;
        boolean prioritaria=false;
        
        if(random.nextInt(100)==1){ 
            if(random.nextInt(10)==1){
                prioritaria = true;
            }
            duracion=random.nextInt(250)+50;
            return new Peticion(prioritaria,duracion);
        }
        else{
            return null;
        }
    }        
    
    public void procesar(){
        while(Servidor.tiempoActual<this.tiempoTotal){
            Peticion ingresa=nuevaPeticion();
            
            if(ingresa!=null){
                if(ingresa.esPrioritaria()){
                    this.filaPrioridad.enfila(ingresa);
                }
                else{
                    this.filaComun.enfila(ingresa);
                }
            }
            
            if(this.enCurso==null || this.enCurso.procesar()==0 ){
                if(this.enCurso!=null && this.enCurso.esPrioritaria() ){
                    this.filaPrioridad.defila();
                    this.enCurso=null;
                    this.peticionaPrioritariaAtendidas++;
                }
                else if(this.enCurso!=null){
                    this.filaComun.defila();
                    this.enCurso=null;
                    this.peticionaComunesAtendidas++;
                }
                
                if(!this.filaPrioridad.esFilaVacia()){
                    this.enCurso=this.filaPrioridad.frente();
                }
                else if(!this.filaComun.esFilaVacia()){
                    this.enCurso=this.filaComun.frente();
                }
            }
            if(this.enCurso==null){
                this.tiempoInactivo++;
            }
            Servidor.tiempoActual++; 
        }
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

    public Fila getFilaPrioridad() {
        return filaPrioridad;
    }

    public void setFilaPrioridad(Fila filaPrioridad) {
        this.filaPrioridad = filaPrioridad;
    }

    public Fila getFilaComun() {
        return filaComun;
    }

    public void setFilaComun(Fila filaComun) {
        this.filaComun = filaComun;
    }

    public Peticion getEnCurso() {
        return enCurso;
    }

    public void setEnCurso(Peticion enCurso) {
        this.enCurso = enCurso;
    }

    public int getPeticionaPrioritariaAtendidas() {
        return peticionaPrioritariaAtendidas;
    }

    public void setPeticionaPrioritariaAtendidas(int peticionaPrioritariaAtendidas) {
        this.peticionaPrioritariaAtendidas = peticionaPrioritariaAtendidas;
    }

    public int getPeticionaComunesAtendidas() {
        return peticionaComunesAtendidas;
    }

    public void setPeticionaComunesAtendidas(int peticionaComunesAtendidas) {
        this.peticionaComunesAtendidas = peticionaComunesAtendidas;
    }
    
    
}
