/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.controlador;

/**
 *
 * @author matu_
 */
public class Calculadora {
    private Pila<Character> pila;
    
    private Calculadora() {
       pila=Pila.crearPila();
    }
    
    
    public static Calculadora crearCalculadora(){
        Calculadora calculadora= new Calculadora();
        return calculadora;               
    }

    
    private int prioridadOperadorEnLaPila(char operador){
        int prioridad = 0;
        switch(operador){
        
        case '(':
            prioridad=0;
            break;
        case '+':
            prioridad=1;
            break;
        case '-':
            prioridad=1;
            break;
        case '*':
            prioridad=2;
            break;
        case '/':
            prioridad=2;
            break;
        case '^':
            prioridad=3;
        }    
            
        return prioridad;
    }
    
    private int prioridadOperadorFueraDeLaPila(char operador){
        int prioridad = 0;
        switch(operador){
        
        case '(':
            prioridad=5;
            break;
        case '+':
            prioridad=1;
        case '-':
            prioridad=1;
            break;
        case '*':
            prioridad=2;
            break;
        case '/':
            prioridad=2;
            break;
        case '^':
            prioridad=4;
        }    
            
        return prioridad;      
    }

    private boolean esOperador(char caracter){
        return caracter=='('||caracter=='+'||caracter=='-'||caracter=='*'||caracter=='/'||caracter=='^';
    }
    
    public String convertirAPostfija(String infija){
        String postfija = "";
        int contador=0;
        boolean Oper=false;
        boolean noOper=true;
        for(char c : infija.toCharArray()){
            
            if(!esOperador(c) && noOper==true){
                if(c != ')')
                    postfija += c;
                else{
                    while(pila.top() != '('){
                        postfija += pila.top();
                        pila.pop();                        
                    }
                    pila.pop();
                }
                if(infija.length()<contador){
                    if(esOperador(infija.charAt(contador+1))){
                        noOper=false;
                    }
                    else{
                        
                    }
                }
                
            }
            else if(esOperador(c) && Oper==true){
                if(pila.esPilaVacia())
                    pila.push(c);
                else if(prioridadOperadorFueraDeLaPila(c) > prioridadOperadorEnLaPila(pila.top()))
                    pila.push(c);
                else if(prioridadOperadorFueraDeLaPila(c) <= prioridadOperadorEnLaPila(pila.top())){
                    postfija += pila.top();
                    pila.pop();
                    pila.push(c);
                }
                noOper=true;
            }
            else{
                throw new IllegalArgumentException("Escribi bien govir");
            }
            contador++;
            System.out.println(c);
        }
        while(!pila.esPilaVacia()){
            postfija += pila.top();
            pila.pop();
        }
        return postfija;
    }
        
}

    

