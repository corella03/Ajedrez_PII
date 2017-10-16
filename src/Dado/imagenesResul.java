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
public class imagenesResul {

    public ImageIcon icoImagen;

    public ImageIcon Imaen(int vDados) {
        switch (vDados) {
            case 1:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/white.jpg"));
                break;
            case 2:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/black.jpg"));
                break;
           
        }
        return icoImagen;
    }
}
