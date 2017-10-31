/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
import LogicaJuego.*;
import Pieza.*;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Tablero {
    private InicioPartida partida;
    private Color turno;
    private Casilla casilla;
    private Casilla[][] ArregloTablero;
    public Tablero() {
        partida = new InicioPartida();
        ArregloTablero = new Casilla[8][8];
    }
    public void colocarPieza(Coordenada coordenada, Pieza pieza){
    }
    public boolean moverPieza(Casilla casillaInicial, Casilla casillaFinal){
        return true;
    }
    public Casilla getCasilla(Coordenada coordenada) {
        return casilla;
    }
    /**
     * Se le asigana una coordenada a la casilla.
     * @param letra String: que recibe letra para identificar las columnas.
     * @param numero int: que recibe número para identificar las filas.
     * @return
     */
    public Casilla getCasillaCoordenada(String letra, int numero) {
        return casilla;
    }
    //Métodos SETTERS y GETTERS
    public Casilla[][] getArregloTablero() {
        return ArregloTablero;
    }
    public void setArregloTablero(Casilla[][] ArregloTablero) {
        this.ArregloTablero = ArregloTablero;
    }
    public Casilla getCasilla() {
        return casilla;
    }
    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    public Color getTurno() {
        return turno;
    }
    public void setTurno(Color turno) {
        this.turno = turno;
    }

    public InicioPartida getPartida() {
        return partida;
    }

    public void setPartida(InicioPartida partida) {
        this.partida = partida;
    }
    
    @Override
    public String toString() {
        return "Tablero: Turno (" + turno + ") -- Casilla(" + casilla + ")";
    }
}