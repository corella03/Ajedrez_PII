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
 **/
public class Peon extends Pieza{
    public Peon() {
    }
    public Peon(Color color) {
        super(color);
    }
    /**
     * 
     * @return 
     */
    public boolean estaEnPosicionOriginal(){
        return true;
    }
    @Override
    public boolean puedeMoverse(Casilla casilla) {
        return true;
    }
    @Override
    public boolean mover(Casilla casilla) {
        return true;
    }
}