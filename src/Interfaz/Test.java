/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JOptionPane;

/**
 *
 * @author luisalonso
 */
public class Test {
    public static void main(String[] args) {
        String domainStudent = "@est.utn.ac.cr";//Esto va hacer lo que coloque en el Combobox o el lo que quieran
        String emailEntry = JOptionPane.showInputDialog("Ingrese solo el nombre del Correo del Estudiante: ");
        boolean x = true;
        for (int i = 0; i < emailEntry.length(); i++) {
            if(String.valueOf(emailEntry.charAt(i)).equals("@")){
                JOptionPane.showMessageDialog(null, "Error al ingresar el correo, ingrese solo el nombre sin el @...");
                x = false;
                break;
            }
        }
        if(x == true){
            JOptionPane.showMessageDialog(null, "Guardado"); 
        }
    }
    public void verificarEmail(){
        
    }
}