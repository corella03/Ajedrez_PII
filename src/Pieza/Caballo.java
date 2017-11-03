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
public class Caballo extends Pieza{
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
    public boolean puedeMoverse(Casilla casilla) {
        
        return true;
    }
}