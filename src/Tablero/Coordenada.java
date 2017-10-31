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
    private static int cont;
    private static int letraColumna = 0;
    private static int numeroFijo = 8;
    private String letra;
    private int numero;
    public Coordenada() {
        if(cont != 8){
            this.numero = numeroFijo;
            this.letra = String.valueOf((char) ('a' + letraColumna));
            letraColumna ++;
            cont++;
        }if(cont == 8){
            numeroFijo--;
            letraColumna = 0;
            cont = 0;
        }
    }
    public Coordenada(Coordenada coordenada) {
    }
    public Coordenada(String letra, int numero) {
        this.letra = letra;
        this.numero = numero;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    //Falta lo de equals
    @Override
    public String toString() {
        return "Coordenada: Letra(" + letra + ") -- Numero(" + numero +")";
    }
}