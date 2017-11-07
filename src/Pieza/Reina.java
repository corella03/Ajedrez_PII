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
public class Reina extends Pieza {

    private Casilla[][] arreglo;

    public Reina() {
    }

    public Reina(Color color) {
        super(color);
    }

    public Reina(Color color, String url) {
        super(color, url);
    }

    @Override
    public boolean mover(Casilla casilla) {
        return true;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla, Casilla[][] a) {
        arreglo = a;
        return true;
    }
}
