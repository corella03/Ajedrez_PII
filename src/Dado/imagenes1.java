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
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 */
public class imagenes1 {
    private ImageIcon icoImagen;
    public ImageIcon gifDado1(int Dado1) {
        switch (Dado1) {
            case 1:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/dado.gif"));
                break;
        }
        return icoImagen;
    }
}