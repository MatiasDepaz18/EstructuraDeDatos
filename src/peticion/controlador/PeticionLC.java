/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peticion.controlador;

import servidor.controlador.ServidorLC;

/**
 *
 * @author matu_
 */
public class PeticionLC {
    private int ingreso,duracion,tiempoRestante,comienzoAtencion;

    public PeticionLC(int duracion) {
        this.ingreso=ServidorLC.tiempoActual;
        this.duracion=duracion;
        this.tiempoRestante= duracion;
    }
    
    public int procesar(){
        if(this.tiempoRestante == this.duracion){
            this.comienzoAtencion = ServidorLC.tiempoActual;
        }
        this.tiempoRestante--;
        return this.tiempoRestante;
    }
    
    public int espera(){
        return ServidorLC.tiempoActual-this.ingreso;
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
    
    

}
