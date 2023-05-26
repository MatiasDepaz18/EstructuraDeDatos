/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peticion.controlador;
import servidor.controlador.Servidor;

/**
 *
 * @author matu_
 */
public class Peticion {
    private int ingreso,duracion,tiempoRestante,comienzoAtencion;
    private boolean prioritaria;

    public Peticion(boolean prioritaria,int duracion) {
        this.ingreso=Servidor.tiempoActual;
        this.duracion=duracion;
        this.tiempoRestante= duracion;
        this.prioritaria=prioritaria;
    }
    
    public boolean esPrioritaria(){
        return prioritaria;
    }
    
    public int procesar(){
        if(this.tiempoRestante == this.duracion){
            this.comienzoAtencion = Servidor.tiempoActual;
        }
        this.tiempoRestante--;
        return this.tiempoRestante;
    }
    
    public int espera(){
        return Servidor.tiempoActual-this.ingreso;
    }

    public int getIngreso() {
        return ingreso;
    }

    public void setIngreso(int ingreso) {
        this.ingreso = ingreso;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public int getComienzoAtencion() {
        return comienzoAtencion;
    }

    public void setComienzoAtencion(int comienzoAtencion) {
        this.comienzoAtencion = comienzoAtencion;
    }


    public void setPrioritaria(boolean prioritaria) {
        this.prioritaria = prioritaria;
    }

    
}
