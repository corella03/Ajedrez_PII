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
 ** @author Carlos Daniel Martines Sequeira 
 ** 16/10/2017
 */
public class Torre extends Pieza {
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
    // "El comer" de las piezas.
    @Override
    public boolean mover(Casilla casilla) {
        casilla.setPieza(this);
        this.getCasilla().setPieza(null);
        this.setCasilla(casilla);
        return true;
    }
    //El movimiento de la Torre es en dirección recta mientras no haya una pieza del mismo Color.
    @Override
    public boolean puedeMoverse(Casilla casilla, Casilla[][] a) {
        getFila();
        getFila2(casilla.getCoordenada().getLetra());
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int numero = this.getCasilla().getCoordenada().getNumero();
        String letraThis = this.getCasilla().getCoordenada().getLetra();
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        if (!this.esMismoColor(getCasilla().getPieza())) {
            if (numero < casilla.getCoordenada().getNumero()) {
                for (int f = numero; f <= 8; f++) {
                    if (f + 1 == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (a[pos[f] - 1][fila].getPieza() != null) {
                        return false;
                    }
                }
            } else if (numero > casilla.getCoordenada().getNumero()) {
                for (int f1 = numero; f1 > 0; f1--) {
                    if (f1 + 1 == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                    if (a[pos[f1] + 1][fila].getPieza() != null) {
                        return false;
                    }
                }
            } else if (fila < filaC) {
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
            } else if (fila > filaC) {
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
            }
        }
        return false;
    }
    /**
     * Obtiene de la Coordenada la latra, y la pasa a número. Para luego verificar 
     * que no se salten piezas del mismo Color.
     */
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
    /**
     * Obtiene de la Coordenada donde nos vamos a mover la latra, y la pasa a número. Para luego verificar 
     * que no se salten piezas del mismo Color.
     * @param letra String: letra de la Coordenada donde nos vamos a mover.
     */
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