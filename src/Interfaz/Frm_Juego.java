/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica_Juego.Label;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import Logica_Juego.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 15/10/2017
 *
 */
public class Frm_Juego extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Frm_Juego
     */
    Thread h1, t;
    int i = 60;
    int j = 9;

    private Logica log;

    public Frm_Juego() {
        initComponents();
        h1 = new Thread(this);
        setLocationRelativeTo(null);
        log = new Logica();
        creaLabels();
        setBackground();
    }

    public Frm_Juego(Logica log) {
        initComponents();
        h1 = new Thread(this);
        h1.start();
        this.log = log;
        creaLabels();
        setBackground();
        run();
    }

    public void creaLabels() {
        int x = 20;
        int y = 10;
        Border border = LineBorder.createBlackLineBorder();
        int i = 0;
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                log.getMatrizL()[filas][columnas] = 0; 
                log.getLabels()[filas][columnas] = new Label(x, y, 90, 90);
                log.getLabels()[filas][columnas].setBorder(border);
                ButtonController bt = new ButtonController();//method that make labels action
                log.getLabels()[filas][columnas].addMouseListener(bt);
                if (i == 0) {
                    log.getLabels()[filas][columnas].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/white.jpg")));
                    i = 1;
                } else {
                    log.getLabels()[filas][columnas].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black.jpg")));
                    i = 0;
                }
                jpanel.add(log.getLabels()[filas][columnas]);
                x += 90;
            }
            y += 90;
            x = 20;
            if (i == 0) {
                i = 1;
            } else {
                i = 0;
            }
        }
    }

    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {//this is a thread that it is modifying the time
            i = i - 1;
            if (i == 0) {
                j--;
                i = 59;
            }
            if (i <= 9) {
                time.setText(j + ":0" + i);
                time2.setText(j + ":0" + i);

            } else {
                time.setText(j + ":" + i);
                time2.setText(j + ":" + i);
            }
            // color for the square
            if (j == 0 & i == 21) {
                time.setForeground(java.awt.Color.orange);
                time2.setForeground(java.awt.Color.orange);
            }
            if (j == 0 & i == 10) {
                time.setForeground(java.awt.Color.red);
                time2.setForeground(java.awt.Color.red);
            }
            if (j == 0 & i == 0) {//Condition that it indicates when the time has finished
                time.setText("Has Perdido");
                time2.setText("Has Perdido");
                h1.suspend();//suspend the time(thread)
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private class ButtonController implements MouseListener {

        public void actionPerformed(ActionEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            for (int i = 0; i < 8; i++) {
                for (int k = 0; k < 8; k++) {
                    if (e.getSource().equals(log.getLabels()[i][k])&log.getMatrizL()[i][k] == 0) {
                        log.getLabels()[i][k].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/blanco.png")));
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public void setBackground() {
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
        lblJug1.setText(log.getJugador1());
        lblJug2.setText(log.getJugador2());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        pnlJug1 = new javax.swing.JPanel();
        lblJug1 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        pnlJug2 = new javax.swing.JPanel();
        lblJug2 = new javax.swing.JLabel();
        time2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        pnlJug1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblJug1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        time.setEditable(false);
        time.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        time.setText("1:00");
        time.setFocusable(false);

        javax.swing.GroupLayout pnlJug1Layout = new javax.swing.GroupLayout(pnlJug1);
        pnlJug1.setLayout(pnlJug1Layout);
        pnlJug1Layout.setHorizontalGroup(
            pnlJug1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJug1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJug1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        pnlJug1Layout.setVerticalGroup(
            pnlJug1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJug1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pnlJug2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        lblJug2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        time2.setEditable(false);
        time2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        time2.setText("1:00");
        time2.setFocusable(false);

        javax.swing.GroupLayout pnlJug2Layout = new javax.swing.GroupLayout(pnlJug2);
        pnlJug2.setLayout(pnlJug2Layout);
        pnlJug2Layout.setHorizontalGroup(
            pnlJug2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJug2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJug2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlJug2Layout.setVerticalGroup(
            pnlJug2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJug2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLayout.createSequentialGroup()
                .addContainerGap(749, Short.MAX_VALUE)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlJug2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlJug1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlJug1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(pnlJug2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Juego().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jpanel;
    private javax.swing.JLabel lblJug1;
    private javax.swing.JLabel lblJug2;
    private javax.swing.JPanel pnlJug1;
    private javax.swing.JPanel pnlJug2;
    private javax.swing.JTextField time;
    private javax.swing.JTextField time2;
    // End of variables declaration//GEN-END:variables
}
