/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
import Logica_Juego.*;
import Pieza.*;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Tablero {
    private Color turno;
    private Casilla casilla;
    public Tablero() {
    }
    public void colocarPieza(Coordenada coordenada, Pieza pieza){
    }
    public boolean moverPieza(Casilla casillaInicial, Casilla casillaFinal){
        return true;
    }
    public Casilla getCasilla(Coordenada coordenada) {
        return casilla;
    }
    public Casilla getCasilla(String letra, int numero) {
        return casilla;
    }
    @Override
    public String toString() {
        return "Tablero: Turno (" + turno + ") -- Casilla(" + casilla + ")";
    }
}