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
public class Rey extends Pieza {

    public Rey() {
    }

    public Rey(Color color) {
        super(color);
    }

    public Rey(Color color, String url) {
        super(color, url);
    }

    @Override
    public boolean mover(Casilla casilla) {
        return true;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        if (this.esMismoColor(casilla.getPieza())) {
            if (this.getCasilla().getCoordenada().getNumero() + 1 == casilla.getCoordenada().getNumero()
                    || this.getCasilla().getCoordenada().getNumero() - 1 == casilla.getCoordenada().getNumero()
                    || String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                    || String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())) {
                return true;
            }
        } else if (this.getCasilla().getCoordenada().getNumero() + 1 == casilla.getCoordenada().getNumero()
                || this.getCasilla().getCoordenada().getNumero() - 1 == casilla.getCoordenada().getNumero()
                || String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                || String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())) {
            if (this.getColor() != casilla.getPieza().getColor()) {
                return true;
            }
        }
        return false;
    }
}
