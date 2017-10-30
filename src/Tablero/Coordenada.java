/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Coordenada {
    private static int letra = 0;
    private static int filas = 0;
    private static int columnas = 1;
    private static int numeroFijo = 8;
    private String letras;
    private int numeros;
    public Coordenada() {
        if(filas < 8 && columnas > 0){
           
                this.numeros = filas;
                this.letras = String.valueOf((char) ('A' + letra));
                letra++;
                columnas++;
        }
        if(columnas == 8){
            filas ++;
        }
    }
    public Coordenada(Coordenada coordenada) {
    }
    public Coordenada(String letra, int numero) {
        this.letras = letra;
        this.numeros = numero;
    }
    public String getLetra() {
        return letras;
    }
    public int getNumero() {
        return numeros;
    }
    public void setLetra(String letra) {
        this.letras = letra;
    }
    public void setNumero(int numero) {
        this.numeros = numero;
    }
    //Falta lo de equals
    @Override
    public String toString() {
        return "Coordenada: Letra(" + letras + ") -- Numero(" + numeros +")";
    }
}