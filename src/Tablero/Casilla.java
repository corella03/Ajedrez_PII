/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import LogicaJuego.Color;
import Pieza.*;
import java.util.Objects;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 *
 */
public class Casilla {

    private static boolean esBlanca = true;
    private static int cont;
    private Color color;
    private Pieza pieza;
    private Coordenada coordenada;
    private Tablero tablero;

    public Casilla() {
        this.coordenada = new Coordenada();
        determinaColorACasilla();
    }

    public Casilla(Color color, Coordenada coordenada) {
        this.color = color;
        this.coordenada = coordenada;
    }

    public Casilla(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Al crear cada casilla le asigna un color, si la variable: esBlanco =
     * true: el color va hacer blanco, si la variable: esBlanco = false: el
     * color va hacer Negro y la variable: cont sirve para que al llegra a la
     * octaba fila se reinicie y asi repetir el proceso.
     */
    public void determinaColorACasilla() {
        if (cont != 8) {
            if (esBlanca) {
                esBlanca = false;
                this.color = Color.BLANCO;
            } else if (!esBlanca) {
                esBlanca = true;
                this.color = Color.NEGRO;
            }
            cont++;
        }
        if (cont == 8) {
            cont = 0;
            if (esBlanca) {
                esBlanca = false;
            } else if (!esBlanca) {
                esBlanca = true;
            }
        }
    }

    /**
     * Verifica si la casilla donde se va a mover esta ocupada.
     *
     * @return true: Si esta ocupada, false: Si la casilla esta libre.
     */
    public boolean estaOcupada() {
//        if (!(tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()].getPieza() == null)) {
//            return true;
//        }
//        return false;
        return pieza != null;
    }

    //Métodos GETTERS y SETTERS
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    /**
     * Método toString de la clase casilla
     *
     * @return Color color: El color que tiene la casilla, Pieza pieza: la piesa
     * que tiene la casilla y Coordenada coordenada: coordenada de la casilla.
     */
    @Override
    public String toString() {
        return "Casilla:  Color: " + color + "\nPieza: " + pieza + "\nCoordenada: " + coordenada;
    }
    
    
}
