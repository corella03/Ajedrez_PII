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

    private Casilla[][] arreglo;

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
        casilla.setPieza(this);
        this.getCasilla().setPieza(null);
        this.setCasilla(casilla);
        return true;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla, Casilla[][] a) {
        arreglo = a;
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int numero = this.getCasilla().getCoordenada().getNumero();
        String letraThis = this.getCasilla().getCoordenada().getLetra();
        if (!this.esMismoColor(getCasilla().getPieza())) {
            if (numero + 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                    || numero + 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())) {
                return true;
            }
            if (numero - 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                    || numero - 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())) {
                return true;
            }
            if (String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                    && numero == casilla.getCoordenada().getNumero()
                    || String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())
                    && numero == casilla.getCoordenada().getNumero()) {
                return true;
            }
            if (numero + 1 == casilla.getCoordenada().getNumero()
                    && letraThis.equals(casilla.getCoordenada().getLetra())
                    || numero - 1 == casilla.getCoordenada().getNumero()
                    && letraThis.equals(casilla.getCoordenada().getLetra())) {
                return true;
            }
        }
        return false;
    }
}
