/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import LogicaJuego.Color1;
import Pieza.Alfil;
import Pieza.Caballo;
import Pieza.Peon;
import Pieza.Pieza;
import Pieza.Reina;
import Pieza.Rey;
import Pieza.Torre;

import Tablero.*;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
    private Thread h1, t;
    private int segundos = 60;
    private int minutos = 9;
    private Tablero tablero;
    private JLabel label;
    Border line = BorderFactory.createLineBorder(Color.RED, 3);
    int p = 0;

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
        //piezas();
        setBackground();
        ver();
        //System.out.println(log.getTablero().getArregloTablero()[6][6].getColor());
        //System.out.println(log.getTablero().getArregloTablero()[6][7].getCoordenada());
        //log.getTablero().getArregloTablero()[6][7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png")));
    }

    public void ver() {
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                System.out.println(filas + "   " + columnas);
                System.out.println(tablero.getArregloTablero()[filas][columnas].getColor());
                System.out.println(tablero.getArregloTablero()[filas][columnas].getCoordenada());
                System.out.println("****");
                System.out.println("");
            }
        }
    }

    public void crearLabels() {
        ButtonController bt = new ButtonController();
        jpanel.setLayout(new java.awt.GridLayout(8, 8));
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                label = new JLabel();
                label.addMouseListener(bt);
                if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Torre && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.NEGRO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreNB.jpg")));
                    } else {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreNN.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Caballo && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.NEGRO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoNB.jpg")));
                    } else {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoNN.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Alfil && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.NEGRO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilNB.jpg")));
                    } else {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilNN.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Reina && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.NEGRO) {
//                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color.BLANCO) {
//                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reinaNB.jpg")));
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.NEGRO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reinaNN.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Rey && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.NEGRO) {
//                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color.BLANCO) {
//                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoNB.jpg")));
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reyNB.jpg")));
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Peon && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.NEGRO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNB.jpg")));
                    } else if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.NEGRO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNN.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Torre && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.BLANCO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreBN.jpg")));
                    } else {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreBB.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Caballo && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.BLANCO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoBN.jpg")));
                    } else {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoBB.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Alfil && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.BLANCO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilBN.jpg")));
                    } else {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilBB.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Reina && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.BLANCO) {
//                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color.BLANCO) {
//                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reinaNB.jpg")));
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reinaBB.jpg")));
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Rey && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.BLANCO) {
//                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color.BLANCO) {
//                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoNB.jpg")));
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reyBN.jpg")));
                } else if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Peon && tablero.getArregloTablero()[filas][columnas].getPieza().getColor() == Color1.BLANCO) {
                    if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBN.jpg")));
                    } else if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.NEGRO) {
                        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBB.jpg")));
                    }
                } else if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.BLANCO) {
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/white.jpg")));
                } else if (tablero.getArregloTablero()[filas][columnas].getColor() == Color1.NEGRO) {
                    label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black.jpg")));
                }
                jpanel.add(label);
            }
        }
        jpanel.addMouseListener(bt);
        jpanel.paintAll(jpanel.getGraphics());
    }

    public void run() {
        tablero.setTurno(Color1.BLANCO);
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
            // color for the square
            if (minutos == 0 & segundos == 21) {
                time.setForeground(java.awt.Color.orange);
                time2.setForeground(java.awt.Color.orange);
            }
            if (minutos == 0 & segundos == 10) {
                time.setForeground(java.awt.Color.red);
                time2.setForeground(java.awt.Color.red);
            }
            if (minutos == 0 & segundos == 0) {//Condition that it indicates when the time has finished
                time.setText("Has Perdido");
                time2.setText("Has Perdido");
                h1.interrupt();//suspend the time(thread)
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
            if (tablero.getTurno() != null) {
                if (tablero.getTurno().equals(tablero.getArregloTablero()[tablero.getF()][tablero.getC()].getPieza().getColor())) {
                    ((JLabel) jpanel.getComponents()[p-1]).setBorder(null);
                    tablero.setBus(false);
                }
                if (!tablero.isBus()) {
                    p = 0;
                    for (int f = 0; f < 8; f++) {
                        for (int k = 0; k < 8; k++) {
                            if (jpanel.getComponents()[p].equals(e.getSource())) {
                                tablero.setF(f);
                                tablero.setC(k);
                                tablero.setBus(true);
                                ((JLabel) jpanel.getComponents()[p]).setBorder(line);
                                f = 7;
                                k = 7;
                            }
                            p++;
                        }
                    }
                } 
                else {
                    p = 0;
                    for (int f = 0; f < 8; f++) {
                        for (int k = 0; k < 8; k++) {
                            if (e.getSource().equals(jpanel.getComponents()[p])) {
                                if (tablero.getArregloTablero()[tablero.getF()][tablero.getC()].getPieza() instanceof Peon) {
                                    tablero.setF1(f);
                                    tablero.setC1(k);
                                    tablero.getArregloTablero()[tablero.getF()][tablero.getC()].getPieza().puedeMoverse(tablero.getArregloTablero()[tablero.getF1()][tablero.getC1()]);
                                    tablero.setF(0);
                                    tablero.setC(0);
                                    tablero.setBus(false);
                                    f = 7;
                                    k = 7;
                                    crearLabels();

                                }
                            }
                            p++;
                        }
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
            .addGap(0, 690, Short.MAX_VALUE)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        getContentPane().add(jpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 690, 660));

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
        jLabel2.setText("    a           b          c           d           e           f           g           h");
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
