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
     *
     * @return
     */
    public boolean estaEnPosicionOriginal() {
        int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        for (int c = 0; c < 8; c++) {
            if(this.getCasilla().getCoordenada().getLetra().equals(String.valueOf((char) (97 + c))) && this.getCasilla().getCoordenada().getNumero() == pos[6]){
                return true;
            }
            else if(this.getCasilla().getCoordenada().getLetra().equals(String.valueOf((char) (97 + c))) && this.getCasilla().getCoordenada().getNumero() == pos[1]){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean puedeMoverse(Casilla casilla) {
        if(estaEnPosicionOriginal()){   
        return true;
        }
        return false;
    }

    @Override
    public boolean mover(Casilla casilla) {
        return true;
    }
}
