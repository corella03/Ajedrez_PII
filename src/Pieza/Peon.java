/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pieza;

import LogicaJuego.Color;
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

    public Peon(Color color) {
        super(color);
    }

    /**
     *
     * @return
     */
    public boolean estaEnPosicionOriginal() {
        for (int i = 0; i < 8; i++) {
            if (tablero.getArregloTablero()[tablero.getFunFila1()][tablero.getFunColumna1()].equals(tablero.getArregloTablero()[1][i])) {
                return true;
            } else if (tablero.getArregloTablero()[tablero.getFunFila1()][tablero.getFunColumna1()].equals(tablero.getArregloTablero()[6][i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        if (casilla.estaOcupada()) {
            if (tablero.getArregloTablero()[tablero.getFunFila1()][tablero.getFunColumna1() + 1] == tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()] || tablero.getArregloTablero()[tablero.getFunFila1()][tablero.getFunColumna1() - 1] == tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()]) {
                if (!tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()].getPieza().esMismoColor(casilla.getPieza())) {
                    return true;
                }
            }
        }else{
            if(estaEnPosicionOriginal()){
                if(tablero.getArregloTablero()[tablero.getFunFila1()-1][tablero.getFunColumna1()]==tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()]||tablero.getArregloTablero()[tablero.getFunFila1()-2][tablero.getFunColumna1()]==tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()]){
                    return true;
                }else if(tablero.getArregloTablero()[tablero.getFunFila1()+1][tablero.getFunColumna1()]==tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()]||tablero.getArregloTablero()[tablero.getFunFila1()+2][tablero.getFunColumna1()]==tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()]){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean mover(Casilla casilla) {
        if(puedeMoverse(casilla)){
            tablero.getArregloTablero()[tablero.getFunFila1()][tablero.getFunColumna1()].setPieza(null);
            tablero.getArregloTablero()[tablero.getFunFila2()][tablero.getFunColumna2()].setPieza(casilla.getPieza());
        }
        return true;
    }
}
