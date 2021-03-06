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
     * Determina si es el primer movimiento del peón para saber si puede mover 1 o 2 casillas.
     * @return true si se encuentra en la posición inicial, false: si ya se ha movido.
     */
    public boolean estaEnPosicionOriginal() {
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        for (int c = 0; c < 8; c++) {
            if (this.getCasilla().getCoordenada().getLetra().equals(String.valueOf((char) (97 + c)))
                    && this.getCasilla().getCoordenada().getNumero() == pos[6]
                    && this.getColor().equals(Color.BLANCO)) {
                return true;
            } else if (this.getCasilla().getCoordenada().getLetra().equals(String.valueOf((char) (97 + c)))
                    && this.getCasilla().getCoordenada().getNumero() == pos[1]
                    && this.getColor().equals(Color.NEGRO)) {
                return true;
            }
        }
        return false;
    }
    //El movimiento del peon esrecto hacia adelante 1 o 2 pasos en el primero movimiento y 1 despues.
    @Override
    public boolean puedeMoverse(Casilla casilla, Casilla[][] a) {
        char letra = this.getCasilla().getCoordenada().getLetra().charAt(0);
        int numero = this.getCasilla().getCoordenada().getNumero();
        String letraThis = this.getCasilla().getCoordenada().getLetra();
        if (!this.esMismoColor(getCasilla().getPieza())) {
            if (estaEnPosicionOriginal()) {
                for (int f = 1; f < 3; f++) {
                    if (numero + f == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())
                            || numero - f == casilla.getCoordenada().getNumero()
                            && letraThis.equals(casilla.getCoordenada().getLetra())) {
                        return true;
                    }
                }
            }
            if (numero + 1 == casilla.getCoordenada().getNumero()
                    && letraThis.equals(casilla.getCoordenada().getLetra())
                    || numero - 1 == casilla.getCoordenada().getNumero()
                    && letraThis.equals(casilla.getCoordenada().getLetra())) {
                if (casilla.getPieza() == null) {
                    return true;
                }
            }
            if (numero + 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                    && this.getColor().equals(Color.BLANCO)
                    || numero + 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())
                    && this.getColor().equals(Color.BLANCO)) {
                if (casilla.getPieza() != null) {
                    if (this.getColor() != casilla.getPieza().getColor()) {
                        return true;
                    }
                }
            }
            if (numero - 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra + 1)).equals(casilla.getCoordenada().getLetra())
                    && this.getColor().equals(Color.NEGRO)
                    || numero - 1 == casilla.getCoordenada().getNumero()
                    && String.valueOf((char) (letra - 1)).equals(casilla.getCoordenada().getLetra())
                    && this.getColor().equals(Color.NEGRO)) {
                if (casilla.getPieza() != null) {
                    if (this.getColor() != casilla.getPieza().getColor()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // "El comer" de las piezas; Diagonal.
    @Override
    public boolean mover(Casilla casilla) {
        casilla.setPieza(this);
        this.getCasilla().setPieza(null);
        this.setCasilla(casilla);
        return true;
    }
}