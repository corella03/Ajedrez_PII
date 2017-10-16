/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dado;

import javax.swing.ImageIcon;

/**
 *
 * @author jenni
 */
public class imagenes1 {

    public ImageIcon icoImagen;

    public ImageIcon gifDado1(int Dado1) {
        switch (Dado1) {
            case 1:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/dado.gif"));
                break;
        }
        return icoImagen;
    }
}
