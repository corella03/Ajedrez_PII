/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dado;
import javax.swing.ImageIcon;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira 
 ** 16/10/2017
 */
public class imagenes {
    private ImageIcon icoImagen;
    /**
     *  Método que muestra un gif de un dado.
     * @param Dado1: que recibe un numero para determinar cual gif mostar.
     * @return icoImagen: el gif del dado
     */
    public ImageIcon gifDado1(int Dado1) {
        switch (Dado1) {
            case 1:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/dado.gif"));
                break;
        }
        return icoImagen;
    }
}