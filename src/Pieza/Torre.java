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
        casilla.setPieza(this);
        this.getCasilla().setPieza(null);
        this.setCasilla(casilla);
        return true;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int numero = this.getCasilla().getCoordenada().getNumero();
        String letraThis = this.getCasilla().getCoordenada().getLetra();
        if (!this.esMismoColor(getCasilla().getPieza())) {
            for (int f = numero; f <= 8; f++) {
                if (f == casilla.getCoordenada().getNumero()
                        && letraThis.equals(casilla.getCoordenada().getLetra())) {
                    return true;
                }
            }
            for (int f = numero; f > 0; f--) {
                if (f == casilla.getCoordenada().getNumero()
                        && letraThis.equals(casilla.getCoordenada().getLetra())) {
                    return true;
                }
            }
            if (numero == casilla.getCoordenada().getNumero()) {
                return true;
            }
        }
        return false;
    }
}
