/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.calculadoraalvarofr;

import java.io.Serializable;
import es.albarregas.calculadoraalvarofr.Sumador;
import es.albarregas.calculadoraalvarofr.Restador;
import es.albarregas.calculadoraalvarofr.Multiplicador;
import es.albarregas.calculadoraalvarofr.Divisor;

/**
 *
 * @author atomsk
 */
public class Calculator implements Serializable{
    int value1,value2;
    String operation;
    int result = 0;

    public Calculator(int val1, int val2, String op) {
	this.value1 = val1;
	this.value2 = val2;
	this.operation = op;
    }
    
    public int operate(){
	switch(operation){
	    case "suma":Sumador Johny = new Sumador();result = Johny.sumar(value1,value2);break;
	    case "resta":Restador Mike = new Restador();result = Mike.restar(value1,value2);break;
	    case "prod":Multiplicador Bob = new Multiplicador();result = Bob.multiplicar(value1,value2);break;
	    case "div":Divisor Mark = new Divisor();result = Mark.dividir(value1,value2);break;
	}
	return result;
    }
}
