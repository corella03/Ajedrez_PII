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
    private Color1 turno;
    private Casilla casilla;
    private Casilla[][] ArregloTablero;
    private int c = 0;
    private int f = 0;
    private int c1 = 0;
    private int f1 = 0;
    private boolean bus = false;
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

    public boolean isBus() {
        return bus;
    }

    public void setBus(boolean bus) {
        this.bus = bus;
    }
    
    public int getC() {
        return c;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getF1() {
        return f1;
    }

    public void setF1(int f1) {
        this.f1 = f1;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getF() {
        return f;
    }

    //Métodos SETTERS y GETTERS
    public void setF(int f) {    
        this.f = f;
    }

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

    public Color1 getTurno() {
        return turno;
    }

    public void setTurno(Color1 turno) {
        this.turno = turno;
    }

    public InicioPartida getPartida() {
        return partida;
    }

    public void setPartida(InicioPartida partida) {
        this.partida = partida;
    }

    public void setPiezas() {
        ArregloTablero[0][0].setPieza(new Torre(Color1.NEGRO));
        ArregloTablero[0][1].setPieza(new Caballo(Color1.NEGRO));
        ArregloTablero[0][2].setPieza(new Alfil(Color1.NEGRO));
        ArregloTablero[0][3].setPieza(new Reina(Color1.NEGRO));
        ArregloTablero[0][4].setPieza(new Rey(Color1.NEGRO));
        ArregloTablero[0][5].setPieza(new Alfil(Color1.NEGRO));
        ArregloTablero[0][6].setPieza(new Caballo(Color1.NEGRO));
        ArregloTablero[0][7].setPieza(new Torre(Color1.NEGRO));
        ArregloTablero[7][0].setPieza(new Torre(Color1.BLANCO));
        ArregloTablero[7][1].setPieza(new Caballo(Color1.BLANCO));
        ArregloTablero[7][2].setPieza(new Alfil(Color1.BLANCO));
        ArregloTablero[7][3].setPieza(new Reina(Color1.BLANCO));
        ArregloTablero[7][4].setPieza(new Rey(Color1.BLANCO));
        ArregloTablero[7][5].setPieza(new Alfil(Color1.BLANCO));
        ArregloTablero[7][6].setPieza(new Caballo(Color1.BLANCO));
        ArregloTablero[7][7].setPieza(new Torre(Color1.BLANCO));
        for (int c = 0; c < 8; c++) {
            ArregloTablero[1][c].setPieza(new Peon(Color1.NEGRO));
            ArregloTablero[6][c].setPieza(new Peon(Color1.BLANCO));
        }
    }

    @Override
    public String toString() {
        return "Tablero: Turno (" + turno + ") -- Casilla(" + casilla + ")";
    }
}
