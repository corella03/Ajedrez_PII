/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica_Juego;
import javax.swing.JLabel;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira
 ** 15/10/2017
 **/
public class Label extends JLabel {
    public Label() {
    }
    public Label(int posX, int posY, int ancho, int largo){
        setBounds(posX, posY, ancho, largo);
    }
}