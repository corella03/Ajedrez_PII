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
    private String letra;
    private int numero;
    public Coordenada(Coordenada coordenada) {
    }
    public Coordenada(String letra, int numero) {
        this.letra = letra;
        this.numero = numero;
    }
    public String getLetra() {
        return letra;
    }
    public int getNumero() {
        return numero;
    }
    public void setLetra(String letra) {
        this.letra = letra;
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