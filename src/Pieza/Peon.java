/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;

import LogicaJuego.Color1;
import Tablero.Casilla;
import Tablero.Tablero;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 *
 */
public class Peon extends Pieza {

    private Tablero tablero;

    public Peon() {
        
    }

    public Peon(Color1 color) {
        super(color);
    }

    /**
     *
     * @return
     */
    public boolean estaEnPosicionOriginal() {
        for (int i = 0; i < 8; i++) {
            if (tablero.getArregloTablero()[tablero.getF()][tablero.getC()].equals(tablero.getArregloTablero()[1][i])) {
                return true;
            } else if (tablero.getArregloTablero()[tablero.getF()][tablero.getC()].equals(tablero.getArregloTablero()[6][i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        if (casilla.estaOcupada()) {
            if (tablero.getArregloTablero()[tablero.getF()][tablero.getC() + 1] == tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()] || tablero.getArregloTablero()[tablero.getF()][tablero.getC() - 1] == tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()]) {
                if (!tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()].getPieza().esMismoColor(casilla.getPieza())) {
                    return true;
                }
            }
        }else{
            if(estaEnPosicionOriginal()){
                if(tablero.getArregloTablero()[tablero.getF()-1][tablero.getC()]==tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()]||tablero.getArregloTablero()[tablero.getF()-2][tablero.getC()]==tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()]){
                    return true;
                }else if(tablero.getArregloTablero()[tablero.getF()+1][tablero.getC()]==tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()]||tablero.getArregloTablero()[tablero.getF()+2][tablero.getC()]==tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()]){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean mover(Casilla casilla) {
        if(puedeMoverse(casilla)){
            tablero.getArregloTablero()[tablero.getF()][tablero.getC()].setPieza(null);
            tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()].setPieza(casilla.getPieza());
        }
        return true;
    }
}
