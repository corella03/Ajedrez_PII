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
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 *
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
     * falta ver que hace el método
     *
     * @param pieza
     * @return
     */
    public boolean esMismoColor(Pieza pieza) {

        return true;
    }

    /**
     * //Preguntar si receibe algo por parametro porque en el enunciado no
     * viene
     *
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

    public Color getColor() {
        return color;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public String getUrl(Color color) {
        if (url == null) {
            return null;
        } else if (color == Color.BLANCO) {
            return url + "B.jpg";
        } else {
            return url + "N.jpg";
        }
    }

}
