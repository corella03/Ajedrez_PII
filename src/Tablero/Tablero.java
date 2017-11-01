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
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 *
 */
public class Tablero {

    private InicioPartida partida;
    private Color turno;
    private Casilla casilla;
    private Casilla[][] ArregloTablero;

    public Tablero() {
        partida = new InicioPartida();
        ArregloTablero = new Casilla[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ArregloTablero[i][j] = new Casilla();
            }
        }
        setPiezas();
    }

    public void colocarPieza(Coordenada coordenada, Pieza pieza) {
    }

    public boolean moverPieza(Casilla casillaInicial, Casilla casillaFinal) {
        return true;
    }

    public Casilla getCasilla(Coordenada coordenada) {
        return casilla;
    }

    /**
     * Se le asigana una coordenada a la casilla.
     *
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

    public void setPiezas() {
        ArregloTablero[0][0].setPieza(new Torre(Color.NEGRO));
        ArregloTablero[0][1].setPieza(new Caballo(Color.NEGRO));
        ArregloTablero[0][2].setPieza(new Alfil(Color.NEGRO));
        ArregloTablero[0][3].setPieza(new Reina(Color.NEGRO));
        ArregloTablero[0][4].setPieza(new Rey(Color.NEGRO));
        ArregloTablero[0][5].setPieza(new Alfil(Color.NEGRO));
        ArregloTablero[0][6].setPieza(new Caballo(Color.NEGRO));
        ArregloTablero[0][7].setPieza(new Torre(Color.NEGRO));
        ArregloTablero[7][0].setPieza(new Torre(Color.BLANCO));
        ArregloTablero[7][1].setPieza(new Caballo(Color.BLANCO));
        ArregloTablero[7][2].setPieza(new Alfil(Color.BLANCO));
        ArregloTablero[7][3].setPieza(new Reina(Color.BLANCO));
        ArregloTablero[7][4].setPieza(new Rey(Color.BLANCO));
        ArregloTablero[7][5].setPieza(new Alfil(Color.BLANCO));
        ArregloTablero[7][6].setPieza(new Caballo(Color.BLANCO));
        ArregloTablero[7][7].setPieza(new Torre(Color.BLANCO));
        for (int c = 0; c < 8; c++) {
            ArregloTablero[1][c].setPieza(new Peon(Color.NEGRO));
            ArregloTablero[6][c].setPieza(new Peon(Color.BLANCO));
        }
    }

    @Override
    public String toString() {
        return "Tablero: Turno (" + turno + ") -- Casilla(" + casilla + ")";
    }
}
