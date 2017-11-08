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
    private int fila;
    private int filaC;
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
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        getFila();
        getFila2(casilla.getCoordenada().getLetra());
        int numero = this.getCasilla().getCoordenada().getNumero();
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        if (!this.esMismoColor(getCasilla().getPieza())) {

            if (pos[numero] + 1 > pos[casilla.getCoordenada().getNumero()] + 1) {
                for (int i = 1; i <= 8; i++) {
                    if (fila < filaC) {
                        if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() - i)
                                && String.valueOf((char) (letra + i)).equals(casilla.getCoordenada().getLetra()))) {
                            return true;
                        }
                        if (a[pos[numero] - i][fila + i].getPieza() != null) {
                            return false;
                        }
                    } else if (fila > filaC) {
                        if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() - i)
                                && String.valueOf((char) (letra - i)).equals(casilla.getCoordenada().getLetra()))) {
                            return true;
                        }
                        if (a[pos[numero] - i][fila - i].getPieza() != null) {
                            return false;
                        }
                    }
                }
            }
            if (pos[numero] - 1 < pos[casilla.getCoordenada().getNumero()] - 1) {
                for (int i = 1; i <= 8; i++) {
                    if (fila < filaC) {
                        if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() + i)
                                && String.valueOf((char) (letra + i)).equals(casilla.getCoordenada().getLetra()))) {
                            return true;
                        }
                        if (a[pos[numero] + i][fila + i].getPieza() != null) {
                            return false;
                        }
                    } else if (fila > filaC) {
                        if ((this.getCasilla().getCoordenada().getNumero() == (casilla.getCoordenada().getNumero() + i)
                                && String.valueOf((char) (letra - i)).equals(casilla.getCoordenada().getLetra()))) {
                            return true;
                        }
                        if (a[pos[numero] + i][fila - i].getPieza() != null) {
                            return false;
                        }
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
