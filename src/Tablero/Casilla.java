/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
import Logica_Juego.*;
import Pieza.*;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Casilla {
    private Color color;
    private Pieza pieza;
    private Coordenada coordenada;
    public Casilla() {
    }
    public Casilla(Color color, Coordenada coordenada) {
        this.color = color;
        this.coordenada = coordenada;
    }
    /**
     * 
     * @return 
     */
    public boolean estaOcupada(){
       return true;
    }
    public Color getColor() {
        return color;
    }
    public Pieza getPieza() {
        return pieza;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
}