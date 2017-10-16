/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Juego;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 16/10/2017
 **/
public class Color {
    private boolean color;
    public Color() {
    }
    public Color(boolean color) {
        this.color = color;
    }
    /**
     * Determina el color de la pieza o la casilla.
     * @return true: Si la pieza/casilla es blanca. false: Si la pieza/casilla es negra
     */
    public boolean determinaColorPiezaCasilla(){
        return true;
    }
    public boolean isColor() {
        return color;
    }
    public void setColor(boolean color) {
        this.color = color;
    }
}