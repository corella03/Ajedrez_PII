/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;

import LogicaJuego.Color;
import Tablero.Casilla;
import Tablero.Coordenada;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 *
 */
public class Caballo extends Pieza {

    private Casilla[][] arreglo;
    Coordenada coor;

    public Caballo() {
    }

    public Caballo(Color color) {
        super(color);
    }

    public Caballo(Color color, String url) {
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
        if (!this.esMismoColor(getCasilla().getPieza())) {
            if ((numero == (casilla.getCoordenada().getNumero() - 2)
                    && String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra()))
                    || (numero == (casilla.getCoordenada().getNumero() - 2)
                    && String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra()))) {
                return true;
            }
            if ((numero == (casilla.getCoordenada().getNumero() + 2)
                    && String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra()))
                    || (numero == (casilla.getCoordenada().getNumero() + 2)
                    && String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra()))) {
                return true;
            }
            if (((numero == (casilla.getCoordenada().getNumero() + 1)
                    && String.valueOf((char) (letra + 2)).equals(casilla.getCoordenada().getLetra()))
                    || numero == (casilla.getCoordenada().getNumero() - 1)
                    && String.valueOf((char) (letra + 2)).equals(casilla.getCoordenada().getLetra()))) {
                return true;
            }
            if (((numero == (casilla.getCoordenada().getNumero() + 1)
                    && String.valueOf((char) (letra - 2)).equals(casilla.getCoordenada().getLetra()))
                    || numero == (casilla.getCoordenada().getNumero() - 1)
                    && String.valueOf((char) (letra - 2)).equals(casilla.getCoordenada().getLetra()))) {
                return true;
            }
        }
        return false;
    }
}
