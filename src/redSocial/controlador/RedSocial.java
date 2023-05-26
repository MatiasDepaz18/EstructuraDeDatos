/*
 * To change lista license header, choose License Headers in Project Properties.
 * To change lista template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.controlador;

import listaEnlazada.controlador.ListaEnlazada;
import usuario.controlador.Usuario;

/**
 *
 * @author matu_
 */
public class RedSocial {
    
    private ListaEnlazada<Usuario> lista;
    
    private RedSocial(){
        lista=ListaEnlazada.crearLista();
    }
    
    public static RedSocial crearRedSocial(){
        RedSocial red=new RedSocial();
        return red;
    }
    
    public void registrar(Usuario user){
        lista.insertarAlInicio(user);
    }
    
    public boolean esVacia(){
        return lista.esVacia();
    }
    
    public boolean esta(Usuario user){
        return lista.pertenece(user);
    }
    
    public void echar(Usuario user){
        lista.borrarConValor(user);
    }
    
    public Usuario ultimoUsuario(){
        return lista.dameValorEnPosicion(0);
    }
    
    public boolean esAmigoComun(RedSocial red, Usuario user){
        return (this.esta(user) && red.esta(user));
    }
    
    public int cantidad(){
        return lista.cantidad();
    }
    
    public RedSocial union(RedSocial red1){
        RedSocial redNueva=this;
        for(int i=0; i<red1.cantidad();i++){
            if(redNueva.esAmigoComun(red1, red1.ultimoUsuario())){
                red1.echar(red1.ultimoUsuario());
            }
            else{
            redNueva.registrar(red1.ultimoUsuario());
            }
        }
        return redNueva;
    }
}
