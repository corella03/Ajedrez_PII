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
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/1.png"));
                break;
            case 2:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/2.png"));
                break;
            case 3:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/3.png"));
                break;
            case 4:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/4.png"));
                break;
            case 5:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/5.png"));
                break;
            case 6:
                icoImagen = new ImageIcon(getClass().getResource("/Imagenes/6.png"));
                break;
        }
        return icoImagen;
    }
}
