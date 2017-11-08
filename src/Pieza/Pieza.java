/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;
import LogicaJuego.Color;
import Tablero.Casilla;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira 
 ** 16/10/2017
 */
public abstract class Pieza {
    private Color color;
    private Casilla casilla;
    private String url;
    public Pieza() {
    }
    public Pieza(Color color) {
        this.color = color;
    }
    public Pieza(Color color, String url) {
        this.color = color;
        this.url = url;
    }
    /**
     * Método que verifica si la pieza seleccionado y la pieza donde se va a mover son del mismo 
     * color o sino tiene pieza.
     * @param pieza Pieza: que recibe la pieza donde se va a mover.
     * @return true: si es null o mismo color, false: si  no es null o distinto color.
     */
    public boolean esMismoColor(Pieza pieza) {
        if (pieza != null) {
            if (pieza.getColor() != this.getColor()) {
                return false;
            }
        }
        return pieza == null;
    }
    /**
     * Método abstracto para determina si se puede mover.
     * @param casilla Casilla: que recibe una casilla.
     * @param arreglo Casilla[][]: que recibe una matriz.
     * @return true: si se puede mover, false: si no se puede mover.
     */
    public abstract boolean puedeMoverse(Casilla casilla, Casilla[][] arreglo);
    /**
     * Método abstracto que mueve las piezas.
     * @param casilla Casilla: que recibe una casilla a donde se va a mover.
     * @return true: si se mueve, false: si no se mueve.
     */
    public abstract boolean mover(Casilla casilla);
    /**
     * Método para determinar el url que va a llervar la imagen.
     * @param color Color: que recibe el color de la casilla.
     * @return String url: la ruta de la imagen.
     */
    public String getUrl(Color color) {
        if (url == null) {
            return null;
        } else if (color == Color.BLANCO) {
            return url + "B.jpg";
        } else {
            return url + "N.jpg";
        }
    }
    //Métodos GETTERS y SETTERS
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Casilla getCasilla() {
        return casilla;
    }
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
}