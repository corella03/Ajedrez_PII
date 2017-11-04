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
public class Peon extends Pieza {

    public Peon() {
    }

    public Peon(Color color) {
        super(color);
    }

    public Peon(Color color, String url) {
        super(color, url);
    }

    /**
     *
     * @return
     */
    public boolean estaEnPosicionOriginal() {
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        for (int c = 0; c < 8; c++) {
            if (this.getCasilla().getCoordenada().getLetra().equals(String.valueOf((char) (97 + c)))
                    && this.getCasilla().getCoordenada().getNumero() == pos[6]) {
                return true;
            } else if (this.getCasilla().getCoordenada().getLetra().equals(String.valueOf((char) (97 + c)))
                    && this.getCasilla().getCoordenada().getNumero() == pos[1]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        if (this.esMismoColor(casilla.getPieza())) {
            if (estaEnPosicionOriginal()) {
                for (int f = 1; f < 3; f++) {
                    if (this.getCasilla().getCoordenada().getNumero() + f == casilla.getCoordenada().getNumero() || this.getCasilla().getCoordenada().getNumero() - f == casilla.getCoordenada().getNumero() 
                            && this.getCasilla().getCoordenada().getLetra().equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    } else if (casilla.getPieza() != null) {
                        if (this.getCasilla().getCoordenada().getNumero() + f == casilla.getCoordenada().getNumero() || this.getCasilla().getCoordenada().getNumero() - f == casilla.getCoordenada().getNumero()) {
                            if (String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra()) || String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())) {
                                return true;
                            }
                        }
                    }
                }
            } else if (this.getCasilla().getCoordenada().getNumero() + 1 == casilla.getCoordenada().getNumero()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean mover(Casilla casilla) {
        this.setCasilla(casilla);
        return true;
    }
}
