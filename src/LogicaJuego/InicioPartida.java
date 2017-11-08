/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJuego;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira 
 ** 16/10/2017
 **/
public class InicioPartida {
    private String jugador1;
    private String jugador2;
    private boolean bus = true;
    public InicioPartida() {
    }
    /**
     * Método que verifica que los jugadores no tengan el mismo nombre.
     * @param jug1 String: que recibe el nombre del jugador1.
     * @param jug2 String: que recibe el nombre del jugador2.
     * @return true: si el jugar es igual, false: si el jugador es igual.
     */
    public boolean verificarIgualdadDeJugadores(String jug1, String jug2) {
        if (jug1.equals(jug2)) {
            bus = true;
            return false;
        }
        bus = false;
        return true;
    }
    /**
     * Verifica que ambos usuarios hayan escrito el nombre.
     * @param jug1 String: que recibe el nombre del jugador1.
     * @param jug2 String: que recibe el nombre del jugador2.
     * @return true: si los datos estan completos, false: si falta alguno de los datos.
     */
    public boolean verificarInicio(String jug1, String jug2) {
        return !jug1.isEmpty() && !jug2.isEmpty();
    }
    //Métodos GETTERS y SETTERS
    public String getJugador1() {
        return jugador1;
    }
    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }
    public String getJugador2() {
        return jugador2;
    }
    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
    public boolean isBus() {
        return bus;
    }
    public void setBus(boolean bus) {
        this.bus = bus;
    }
}