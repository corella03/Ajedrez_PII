/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;
import LogicaJuego.Color1;
import Tablero.Casilla;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public abstract class Pieza {
    private Color1 color;
    private Casilla casilla;
    public Pieza() {
    }
    public Pieza(Color1 color) {
        this.color = color;
    }
    /**
     * falta ver que hace el método
     * @param pieza
     * @return 
     */
    public boolean esMismoColor(Pieza pieza){
        
        return true;
    }
    /**
     * //Preguntar si receibe algo por parametro porque en el enunciado no viene
     * @param casilla
     * @return 
     */
    public abstract boolean puedeMoverse(Casilla casilla);
    /**
     * 
     * @param casilla
     * @return 
     */
    public abstract boolean mover(Casilla casilla);
    public Color1 getColor() {
        return color;
    }
    public Casilla getCasilla() {
        return casilla;
    }
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
}