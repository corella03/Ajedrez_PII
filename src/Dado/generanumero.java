/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dado;
import java.util.Random;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 */
public class generanumero {
    public int calculanumero() {
        Random Generar = new Random();
        int num = Generar.nextInt(6) + 1;
        return num;
    }
}