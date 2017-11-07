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

    private Casilla[][] arreglo;
    private int fila;
    private int filaC;

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
    public boolean puedeMoverse(Casilla casilla, Casilla[][] a) {
        arreglo = a;
        getFila();
        getFila2(casilla.getCoordenada().getLetra());
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int numero = this.getCasilla().getCoordenada().getNumero();
        String letraThis = this.getCasilla().getCoordenada().getLetra();
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        if (!this.esMismoColor(getCasilla().getPieza())) {
            if (numero < casilla.getCoordenada().getNumero()) {
                for (int f = numero; f <= 8; f++) {
                    if (f == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (arreglo[pos[f] - 1][7].getPieza() != null) {
                        return false;
                    }
                }
            } else if (numero > casilla.getCoordenada().getNumero()) {
                for (int f = numero; f > 0; f--) {
                    if (f == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (arreglo[pos[f] + 1][7].getPieza() != null) {
                        return false;
                    }
                }
            } else if (fila < filaC) {
                int i = 1;
                for (int f = fila; f < 7; f++) {
                    if (numero == casilla.getCoordenada().getNumero()
                            && String.valueOf((char) (letra + i)).equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (arreglo[5][f+1].getPieza() != null) {
                        return false;
                    }
                    i++;
                }
            } else if (fila > filaC) {
                for (int f = fila; f > 0; f--) {
                    if (numero == casilla.getCoordenada().getNumero()
                            && String.valueOf((char) (letra - f)).equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (arreglo[5][f - 1].getPieza() != null) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public void getFila() {
        switch (this.getCasilla().getCoordenada().getLetra()) {
            case "a":
                fila = 0;
                return;
            case "b":
                fila = 1;
                return;
            case "c":
                fila = 2;
                return;
            case "d":
                fila = 3;
                return;
            case "e":
                fila = 4;
                return;
            case "f":
                fila = 5;
                return;
            case "g":
                fila = 6;
                return;
            case "h":
                fila = 7;
                return;
        }

    }

    public void getFila2(String letra) {
        switch (letra) {
            case "a":
                filaC = 0;
                return;
            case "b":
                filaC = 1;
                return;
            case "c":
                filaC = 2;
                return;
            case "d":
                filaC = 3;
                return;
            case "e":
                filaC = 4;
                return;
            case "f":
                filaC = 5;
                return;
            case "g":
                filaC = 6;
                return;
            case "h":
                filaC = 7;
                return;
        }

    }
}
