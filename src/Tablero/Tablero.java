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
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017 *
 *
 */
public class Tablero {

    private InicioPartida partida;
    private Color turno;
    private Casilla casilla;
    private Casilla[][] arregloTablero;
    private int funColumna1;
    private int funFila1;
    private int funColumna2;
    private int funFila2;
    private boolean bus;

    public Tablero() {
        partida = new InicioPartida();
        arregloTablero = new Casilla[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                arregloTablero[i][j] = new Casilla();
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
     * @return String letra: Una letra que va de A,H , int numero: un numero uqe
     * va del 8 al 1.
     */
    public Casilla getCasillaCoordenada(String letra, int numero) {
        return casilla;
    }

    /**
     * Método donde se le asigna una pieza a una casilla de forma Inicial
     */
    public void setPiezas() {
        arregloTablero[0][0].setPieza(new Torre(Color.NEGRO,"/Imagenes/torreN"));
        arregloTablero[0][0].getPieza().setCasilla(arregloTablero[0][0]);
        
        arregloTablero[0][1].setPieza(new Caballo(Color.NEGRO,"/Imagenes/caballoN"));
        arregloTablero[0][1].getPieza().setCasilla(arregloTablero[0][1]);
        
        arregloTablero[0][2].setPieza(new Alfil(Color.NEGRO,"/Imagenes/alfilN"));
        arregloTablero[0][2].getPieza().setCasilla(arregloTablero[0][2]);
        
        arregloTablero[0][3].setPieza(new Reina(Color.NEGRO,"/Imagenes/reinaN"));
        arregloTablero[0][3].getPieza().setCasilla(arregloTablero[0][3]);
        
        arregloTablero[0][4].setPieza(new Rey(Color.NEGRO,"/Imagenes/reyN"));
        arregloTablero[0][4].getPieza().setCasilla(arregloTablero[0][4]);
        
        arregloTablero[0][5].setPieza(new Alfil(Color.NEGRO,"/Imagenes/alfilN"));
        arregloTablero[0][5].getPieza().setCasilla(arregloTablero[0][5]);
        
        arregloTablero[0][6].setPieza(new Caballo(Color.NEGRO,"/Imagenes/caballoN"));
        arregloTablero[0][6].getPieza().setCasilla(arregloTablero[0][6]);
        
        arregloTablero[0][7].setPieza(new Torre(Color.NEGRO, "/Imagenes/torreN"));
        arregloTablero[0][7].getPieza().setCasilla(arregloTablero[0][7]);
        
        arregloTablero[7][0].setPieza(new Torre(Color.BLANCO,"/Imagenes/torreB"));
        arregloTablero[7][0].getPieza().setCasilla(arregloTablero[7][0]);
        
        arregloTablero[7][1].setPieza(new Caballo(Color.BLANCO,"/Imagenes/caballoB"));
        arregloTablero[7][1].getPieza().setCasilla(arregloTablero[7][1]);
        
        arregloTablero[7][2].setPieza(new Alfil(Color.BLANCO,"/Imagenes/alfilB"));
        arregloTablero[7][2].getPieza().setCasilla(arregloTablero[7][2]);
        
        arregloTablero[7][3].setPieza(new Reina(Color.BLANCO,"/Imagenes/reinaB"));
        arregloTablero[7][3].getPieza().setCasilla(arregloTablero[7][3]);
        
        arregloTablero[7][4].setPieza(new Rey(Color.BLANCO,"/Imagenes/reyB"));
        arregloTablero[7][4].getPieza().setCasilla(arregloTablero[7][4]);
        
        arregloTablero[7][5].setPieza(new Alfil(Color.BLANCO,"/Imagenes/alfilB"));
        arregloTablero[7][5].getPieza().setCasilla(arregloTablero[7][5]);
        
        arregloTablero[7][6].setPieza(new Caballo(Color.BLANCO,"/Imagenes/caballoB"));
        arregloTablero[7][6].getPieza().setCasilla(arregloTablero[7][6]);
        
        arregloTablero[7][7].setPieza(new Torre(Color.BLANCO,"/Imagenes/torreB"));
        arregloTablero[7][7].getPieza().setCasilla(arregloTablero[7][7]);
        
        for (int c = 0; c < 8; c++) {
            arregloTablero[1][c].setPieza(new Peon(Color.NEGRO,"/Imagenes/peonN"));
            arregloTablero[1][c].getPieza().setCasilla(arregloTablero[1][c]);
            
            arregloTablero[6][c].setPieza(new Peon(Color.BLANCO,"/Imagenes/peonB"));
            arregloTablero[6][c].getPieza().setCasilla(arregloTablero[6][c]);
        }
    }

    //Métodos GETTERS y SETTERS
    public boolean isBus() {
        return bus;
    }

    public void setBus(boolean bus) {
        this.bus = bus;
    }

    public int getFunFila1() {
        return funFila1;
    }

    public void setFunFila1(int funFila1) {
        this.funFila1 = funFila1;
    }

    public int getFunFila2() {
        return funFila2;
    }

    public void setFunFila2(int funFila2) {
        this.funFila2 = funFila2;
    }

    public int getFunColumna1() {
        return funColumna1;
    }

    public void setFunColumna1(int funColumna1) {
        this.funColumna1 = funColumna1;
    }

    public int getFunColumna2() {
        return funColumna2;
    }

    public void setFunColumna2(int funColumna2) {
        this.funColumna2 = funColumna2;
    }

    public Casilla[][] getArregloTablero() {
        return arregloTablero;
    }

    public void setArregloTablero(Casilla[][] arregloTablero) {
        this.arregloTablero = arregloTablero;
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

    /**
     * Método toString de la clase Tablero
     *
     * @return Color turno: El color ya sea blanco o negro. Casilla casilla: La
     * casilla con todos sus atributos.
     */
    @Override
    public String toString() {
        return "Tablero: Turno (" + turno + ") -- Casilla(" + casilla + ")";
    }
}
