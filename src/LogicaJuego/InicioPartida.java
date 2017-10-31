/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaJuego;
import Tablero.Tablero;
/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 16/10/2017
 **
 **/
public class InicioPartida {
    private Tablero tablero;
    private String jugador1;
    private String jugador2;
    private boolean bus = true;
    
    public InicioPartida() {
        tablero = new Tablero();
    }
    public boolean verificarIgualdadDeJugadores(String jug1, String jug2) {
        if (jug1.equals(jug2)) {
            bus = true;
            return false;
        }
        bus = false;
        return true;
    }
    public boolean verificarInicio(String jug1, String jug2) {

        return !jug1.isEmpty() && !jug2.isEmpty();
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

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
}
