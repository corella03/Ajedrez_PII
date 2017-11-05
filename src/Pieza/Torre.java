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
public class Torre extends Pieza {

    public Torre() {
    }

    public Torre(Color color) {
        super(color);
    }

    public Torre(Color color, String url) {
        super(color, url);
    }

    @Override
    public boolean mover(Casilla casilla) {
        return true;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int f1 = this.getCasilla().getCoordenada().getNumero();
        if (this.esMismoColor(casilla.getPieza())) {
            for (int f = f1; f < 8; f++) {
                if (f == casilla.getCoordenada().getNumero()
                        && this.getCasilla().getCoordenada().getLetra().equals(casilla.getCoordenada().getLetra())) {
                    return true;
                }
            }
            for (int f = f1; f > 0; f--) {
                if (f == casilla.getCoordenada().getNumero()
                        && this.getCasilla().getCoordenada().getLetra().equals(casilla.getCoordenada().getLetra())) {
                    return true;
                }
            }
            if (f1 == casilla.getCoordenada().getNumero()) {
                return true;
            }
        } else {
            for (int f = f1; f < 8; f++) {
                if (f == casilla.getCoordenada().getNumero()
                        && this.getCasilla().getCoordenada().getLetra().equals(casilla.getCoordenada().getLetra())) {
                    if (this.getColor() != casilla.getPieza().getColor()) {
                        return true;
                    }
                }
            }
            for (int f = f1; f > 0; f--) {
                if (f == casilla.getCoordenada().getNumero()
                        && this.getCasilla().getCoordenada().getLetra().equals(casilla.getCoordenada().getLetra())) {
                    if (this.getColor() != casilla.getPieza().getColor()) {
                        return true;
                    }
                }
            }
            if (f1 == casilla.getCoordenada().getNumero()) {
                if (this.getColor() != casilla.getPieza().getColor()) {
                        return true;
                    }
            }
        }
        return false;
    }
}
