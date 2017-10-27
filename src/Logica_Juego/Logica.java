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
public class Logica {
    private String jugador1;
    private String jugador2;
    private boolean bus = true;
    private Label[][] labels ;
    private Integer[][] matrizL;
    public Logica() {
        labels = new Label[8][8];
        matrizL = new Integer[8][8];
    }
    public boolean verificarIgualdadDeJugadores(String jug1, String jug2){
        if(jug1.equals(jug2)){
            bus = true;
            return false;
        }
        bus = false;
        return true;
    }
    public boolean verificarInicio(String jug1,String jug2){
            
            return !jug1.isEmpty() && !jug2.isEmpty();
    }

    public Integer[][] getMatrizL() {
        return matrizL;
    }

    public void setMatrizL(Integer[][] matrizL) {
        this.matrizL = matrizL;
    }

    public Label[][] getLabels() {
        return labels;
    }

    public void setLabels(Label[][] labels) {
        this.labels = labels;
    }
    
    public String getJugador1() {
        return jugador1;
    }
    public String getJugador2() {
        return jugador2;
    }
    public boolean isBus() {
        return bus;
    }
    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }
    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
    public void setBus(boolean bus) {
        this.bus = bus;
    }
}