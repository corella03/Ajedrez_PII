/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dado;

import java.util.Random;

/**
 *
 * @author jenni
 */
public class generanumero {

    
    public int calculanumero() {
        Random Generar = new Random();
        int num = Generar.nextInt(2) + 1;
        System.out.println(num);
        return num;
    }
}
