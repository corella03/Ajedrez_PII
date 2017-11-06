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
public class Alfil extends Pieza {
    
    private Casilla[][] arreglo;
    
    public Alfil() {
    }

    public Alfil(Color color) {
        super(color);
    }

    public Alfil(Color color, String url) {
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
    public boolean puedeMoverse(Casilla casilla, Casilla[][] a) {
        arreglo = a;
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        if (!this.esMismoColor(getCasilla().getPieza())) {
            for (int i = 1; i <= 8; i++) {
                if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() - i)
                        && String.valueOf((char) (letra + i)).equals(casilla.getCoordenada().getLetra()))) {
                    return true;
                }
                if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() - i)
                        && String.valueOf((char) (letra - i)).equals(casilla.getCoordenada().getLetra()))) {
                    return true;
                }
                if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() + i)
                        && String.valueOf((char) (letra + i)).equals(casilla.getCoordenada().getLetra()))) {
                    return true;
                }
                if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() + i)
                        && String.valueOf((char) (letra - i)).equals(casilla.getCoordenada().getLetra()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
