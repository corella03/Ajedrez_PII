/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
import LogicaJuego.Color;
import Pieza.*;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Casilla{
    private static int cont;
    private Color color;
    private Pieza pieza;
    private Coordenada coordenada;
    private Tablero tablero;
    private static boolean esBlanca = true;
    public Casilla(){
        this.coordenada = new Coordenada();
        determinaColorACasilla();
    }
    public Casilla(Color color, Coordenada coordenada) {
        this.color = color;
        this.coordenada = coordenada;
    }
    /**
     * Al crear cada casilla le asigna un color,
     * si la variable: esBlanco = true: el color va hacer blanco,
     * si la variable: esBlanco = false: el color va hacer Negro
     */
    public void determinaColorACasilla(){
        if(cont != 8){
            if(esBlanca){
                esBlanca = false;
                this.color = Color.BLANCO;
            }else if(!esBlanca){
                esBlanca = true;
                this.color = Color.NEGRO;
            }
            cont++;
        }if(cont == 8){
            cont = 0;
            if(esBlanca){
                esBlanca = false;
            }else if(!esBlanca){
                esBlanca = true;
            }
        }
    }
    /**
     * 
     * @return 
     */
    public boolean estaOcupada(){
       if(!(tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()].getPieza()==null)){
           return true;
       }
       return false;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Pieza getPieza() {
        return pieza;
    }
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
}