/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;
import Logica_Juego.*;
import Pieza.*;
import javax.swing.JLabel;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Casilla extends JLabel{
    //
    private static int letra = 0;
    private static int filas = 0;
    private static int columnas = 0;
    private static int numero = 8;
    private static int numeroFijo = 0;
    //
    private Color color;
    private Pieza pieza;
    private Coordenada coordenada;
    private static boolean esBlanca;
    public Casilla() {
    }
    public Casilla(int posX, int posY, int ancho, int largo){
        setBounds(posX, posY, ancho, largo);
        this.coordenada = new Coordenada();
        determinaColorACasilla();
        determinarCoordenada();
    }
    public Casilla(Color color, Coordenada coordenada, int posX, int posY, int ancho, int largo) {
        this.color = color;
        this.coordenada = coordenada;
        setBounds(posX, posY, ancho, largo);
    }
    public Casilla(Color color, Coordenada coordenada) {
        this.color = color;
        this.coordenada = coordenada;
    }
    /**
     *
     */
    public void determinarCoordenada(){
        if(filas == numeroFijo){
           if(columnas <= 8){
                coordenada.setNumero(numero);
                coordenada.setLetra(String.valueOf((char) ('A' + letra)));
                letra++;
                columnas++;
            }
           else{
               filas++;
               numero--;
               numeroFijo++;
               letra = 0;
               columnas = 0;
           }
        }
    }
    /**
     * Al crear cada casilla le asigna un color,
     * si la variable: esBlanco = true: el color va hacer blanco,
     * si la variable: esBlanco = false: el color va hacer Negro
     */
    public void determinaColorACasilla(){
        if(esBlanca == true){
            esBlanca = false;
            this.color = Color.BLANCO;
        }else if(esBlanca == false){
           esBlanca = true;
           this.color = Color.NEGRO;
        }
    }
    /**
     * 
     * @return 
     */
    public boolean estaOcupada(){
        
       return true;
    }
    public Color getColor() {
        return color;
    }
    public Pieza getPieza() {
        return pieza;
    }
    public Coordenada getCoordenada() {
        return coordenada;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
}