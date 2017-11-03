/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import LogicaJuego.Color;
import Pieza.*;
import Tablero.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 15/10/2017 *
 *
 */
public class Frm_Juego extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Frm_Juego
     */
    private Thread h1, t;//tiempo de los jugadores
    private int segundos = 60;
    private int minutos = 9;
    private Tablero tablero;
    private Border line = BorderFactory.createLineBorder(java.awt.Color.RED, 3);
    private Casilla casilla1;
    private Casilla casilla2;

    public Frm_Juego() {
        initComponents();
        h1 = new Thread(this);
        setLocationRelativeTo(null);
        tablero = new Tablero();
        inicioJuego();
    }

    public Frm_Juego(Tablero tablero) {
        initComponents();
        h1 = new Thread(this);
        this.tablero = tablero;
        inicioJuego();
    }

    public void inicioJuego() {
        crearLabels();
        setBackground();
        ver();
    }

    public void ver() {
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                System.out.println(filas + "   " + columnas);
                System.out.println(tablero.getArregloTablero()[filas][columnas].getColor());
                System.out.println(tablero.getArregloTablero()[filas][columnas].getCoordenada());
                System.out.println(tablero.getArregloTablero()[filas][columnas].getPieza());
                System.out.println("****");
                System.out.println("");
            }
        }
    }

    public void crearLabels() {
        ButtonController bt = new ButtonController();
        jpanel.removeAll();
        jpanel.setLayout(new java.awt.GridLayout(8, 8));
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                JLabel label = new JLabel();
                label.addMouseListener(bt);
                label.setOpaque(true);
                Casilla casillaTemp = tablero.getArregloTablero()[filas][columnas];
                if (casillaTemp.getColor() == Color.BLANCO) {
                    label.setBackground(java.awt.Color.WHITE);
                } else {
                    label.setBackground(java.awt.Color.BLACK);
                }
                Pieza temp = tablero.getArregloTablero()[filas][columnas].getPieza();
                if (temp != null && temp.getUrl(casillaTemp.getColor()) != null) {
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp.getUrl(casillaTemp.getColor()))));

                }
                label.setName(filas + "," + columnas);
                jpanel.add(label);
            }
        }
        jpanel.addMouseListener(bt);
        jpanel.paintAll(jpanel.getGraphics());
    }

    public void run() {
        tablero.setTurno(Color.BLANCO);
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            segundos = segundos - 1;
            if (segundos == 0) {
                minutos--;
                segundos = 59;
            }
            if (segundos <= 9) {
                time.setText(minutos + ":0" + segundos);
                time2.setText(minutos + ":0" + segundos);

            } else {
                time.setText(minutos + ":" + segundos);
                time2.setText(minutos + ":" + segundos);
            }
            if (minutos == 0 & segundos == 21) {
                time.setForeground(java.awt.Color.orange);
                time2.setForeground(java.awt.Color.orange);
            }
            if (minutos == 0 & segundos == 10) {
                time.setForeground(java.awt.Color.red);
                time2.setForeground(java.awt.Color.red);
            }
            if (minutos == 0 & segundos == 0) {
                time.setText("Has Perdido");
                time2.setText("Has Perdido");
                h1.interrupt();
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

            JLabel lbl = (JLabel) e.getSource();
            String[] coor = lbl.getName().split(",");
            int fi = Integer.parseInt(coor[0]);
            int co = Integer.parseInt(coor[1]);

            if (casilla1 == null) {
                casilla1 = tablero.getArregloTablero()[fi][co];
            } else {
                int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
                System.out.println(casilla1.getCoordenada());
                System.out.println(String.valueOf((char) (97 + co)));
                System.out.println(pos[fi]);

                if (casilla1.getCoordenada().getLetra().equals(String.valueOf((char) (97 + co))) && casilla1.getCoordenada().getNumero() == pos[fi]) {
                    return;
                }
                if (casilla1.getPieza().puedeMoverse(tablero.getArregloTablero()[fi][co])) {
                    tablero.getArregloTablero()[fi][co].setPieza(casilla1.getPieza());
                    tablero.getArregloTablero()[fi][co].getPieza().setCasilla(tablero.getArregloTablero()[fi][co]);
                    casilla1.setPieza(null);
                    casilla1 = null;
                    crearLabels();
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
        lblJug1.setText(tablero.getPartida().getJugador1());
        lblJug2.setText(tablero.getPartida().getJugador2());
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
        jButton1 = new javax.swing.JButton();
        pnlJug1 = new javax.swing.JPanel();
        lblJug1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        pnlJug2 = new javax.swing.JPanel();
        lblJug2 = new javax.swing.JLabel();
        time2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lbl8 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl7 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpanel.setOpaque(false);

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(jpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 650, 650));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("JUGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 680, -1, -1));

        pnlJug1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlJug1.setOpaque(false);

        lblJug1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time.setText("10:00");

        javax.swing.GroupLayout pnlJug1Layout = new javax.swing.GroupLayout(pnlJug1);
        pnlJug1.setLayout(pnlJug1Layout);
        pnlJug1Layout.setHorizontalGroup(
            pnlJug1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJug1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJug1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        pnlJug1Layout.setVerticalGroup(
            pnlJug1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJug1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );

        getContentPane().add(pnlJug1, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 24, -1, -1));

        pnlJug2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pnlJug2.setOpaque(false);

        lblJug2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        time2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time2.setText("10:00");

        javax.swing.GroupLayout pnlJug2Layout = new javax.swing.GroupLayout(pnlJug2);
        pnlJug2.setLayout(pnlJug2Layout);
        pnlJug2Layout.setHorizontalGroup(
            pnlJug2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJug2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblJug2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        pnlJug2Layout.setVerticalGroup(
            pnlJug2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJug2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblJug2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(time2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        getContentPane().add(pnlJug2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, -1, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png"))); // NOI18N
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1163, 0, 46, 50));

        lbl8.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl8.setText("8");
        getContentPane().add(lbl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        lbl5.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl5.setText("5");
        getContentPane().add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        lbl6.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl6.setText("6");
        getContentPane().add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        lbl2.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl2.setText("2");
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        lbl1.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl1.setText("1");
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));

        lbl3.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl3.setText("3");
        getContentPane().add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, -1, -1));

        lbl7.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl7.setText("7");
        getContentPane().add(lbl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        lbl4.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        lbl4.setText("4");
        getContentPane().add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 25)); // NOI18N
        jLabel2.setText("    a           b          c         d         e           f          g          h");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 670, 690, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vistaJuego.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 1230, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        run();
        h1.start();
    }//GEN-LAST:event_jButton1ActionPerformed
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpanel;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lbl7;
    private javax.swing.JLabel lbl8;
    private javax.swing.JLabel lblJug1;
    private javax.swing.JLabel lblJug2;
    private javax.swing.JPanel pnlJug1;
    private javax.swing.JPanel pnlJug2;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time2;
    // End of variables declaration//GEN-END:variables
}
