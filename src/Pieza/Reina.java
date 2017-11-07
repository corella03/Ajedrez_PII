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

    private int fila;
    private int filaC;

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
        getFila();
        getFila2(casilla.getCoordenada().getLetra());
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int numero = this.getCasilla().getCoordenada().getNumero();
        String letraThis = this.getCasilla().getCoordenada().getLetra();
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        if (!this.esMismoColor(getCasilla().getPieza())) {
            if (numero < casilla.getCoordenada().getNumero()
                    && letraThis.equals(casilla.getCoordenada().getLetra())) {
                for (int f = numero; f <= 8; f++) {
                    if (f + 1 == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (a[pos[f] - 1][fila].getPieza() != null) {
                        return false;
                    }
                }
            } else if (numero > casilla.getCoordenada().getNumero()
                    && letraThis.equals(casilla.getCoordenada().getLetra())) {
                for (int f1 = numero; f1 > 0; f1--) {
                    if (f1 + 1 == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (a[pos[f1] + 1][fila].getPieza() != null) {
                        return false;
                    }
                }
            } else if (fila < filaC && numero == casilla.getCoordenada().getNumero()) {
                int i = 1;
                for (int f2 = fila; f2 < 7; f2++) {
                    if (numero == casilla.getCoordenada().getNumero()
                            && String.valueOf((char) (letra + i)).equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (a[pos[numero]][f2 + 1].getPieza() != null) {
                        return false;
                    }
                    i++;
                }
            } else if (fila > filaC && numero == casilla.getCoordenada().getNumero()) {
                int p = 1;
                for (int f3 = fila; f3 > 0; f3--) {
                    if (numero == casilla.getCoordenada().getNumero()
                            && String.valueOf((char) (letra - p)).equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (a[pos[numero]][f3 - 1].getPieza() != null) {
                        return false;
                    }
                    p++;
                }
            } else if (pos[numero] + 1 > pos[casilla.getCoordenada().getNumero()] + 1) {
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
            } else if (pos[numero] - 1 < pos[casilla.getCoordenada().getNumero()] - 1) {
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
