/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import LogicaJuego.Color;
import Pieza.*;
import Tablero.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 **
 ** @author Luis Alonso Corella Chaves
 ** @author Carlos Daniel Martines Sequeira * 15/10/2017 *
 *
 */
public class Frm_Juego extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Juego
     */
    private Timer timer;
    private Timer timer2;
    private int segundos = 60;
    private int minutos = 9;
    private int segundos2 = 60;
    private int minutos2 = 9;
    private Tablero tablero;
    private Border line = BorderFactory.createLineBorder(java.awt.Color.RED, 3);
    private Casilla casilla1;
    private Casilla casilla2;
    private JLabel label = new JLabel();
    private boolean estado = true;

    public Frm_Juego() {
        initComponents();
        setLocationRelativeTo(null);
        tablero = new Tablero();
        timer = new Timer(1000, accion);
        timer2 = new Timer(1000, accion2);
        tablero.setTurno(Color.BLANCO);
        inicioJuego();
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
    }

    public Frm_Juego(Tablero tablero) {
        initComponents();
        timer = new Timer(1000, accion);
        timer2 = new Timer(1000, accion2);
        this.tablero = tablero;
        tablero.setTurno(Color.BLANCO);
        inicioJuego();
        setBackground();
    }
    private ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos = segundos - 1;
            if (minutos <= 0 && segundos == 0) {
                time2.setText("Has Perdido");
                timer2.stop();
                timer.stop();
                return;
            }
            if (segundos == 0) {
                minutos--;
                segundos = 59;
            }
            if (segundos <= 9) {
                time2.setText(minutos + ":0" + segundos);

            } else {
                time2.setText(minutos + ":" + segundos);
            }
            if (minutos == 0 & segundos == 21) {
                time2.setForeground(java.awt.Color.orange);
            }
            if (minutos == 0 & segundos == 10) {
                time2.setForeground(java.awt.Color.red);
            }

        }
    };
    private ActionListener accion2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos2 = segundos2 - 1;
            if (minutos2 <= 0 && segundos2 == 0) {
                time.setText("Has Perdido");
                timer.stop();
                timer2.stop();
                return;
            }
            if (segundos2 == 0) {
                minutos2--;
                segundos2 = 59;
            }
            if (segundos2 <= 9) {
                time.setText(minutos2 + ":0" + segundos2);
            } else {
                time.setText(minutos2 + ":" + segundos2);

            }
            if (minutos2 == 0 & segundos2 == 21) {
                time.setForeground(java.awt.Color.orange);
            }
            if (minutos2 == 0 & segundos2 == 10) {
                time.setForeground(java.awt.Color.red);
            }
        }
    };

    public void inicioJuego() {
        crearLabels();
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
                if (tablero.getArregloTablero()[fi][co].getPieza() != null) {
                    if (tablero.getTurno().equals(Color.BLANCO)) {
                        if (tablero.getArregloTablero()[fi][co].getPieza().getColor().equals(Color.BLANCO)) {
                            casilla1 = tablero.getArregloTablero()[fi][co];
                            label = lbl;
                            lbl.setBorder(line);
                        }
                    } else if (tablero.getArregloTablero()[fi][co].getPieza().getColor().equals(Color.NEGRO)) {
                        casilla1 = tablero.getArregloTablero()[fi][co];
                        label = lbl;
                        lbl.setBorder(line);
                    }

                }
            } else if (casilla1 != null) {
                if (tablero.getArregloTablero()[fi][co].getPieza() != null) {
                    if (casilla1.getPieza().getColor().equals(tablero.getArregloTablero()[fi][co].getPieza().getColor())) {
                        casilla1 = tablero.getArregloTablero()[fi][co];
                        label.setBorder(null);
                        lbl.setBorder(line);
                        label = lbl;
                    }
                }
                if (tablero.getArregloTablero()[fi][co].getPieza() == null || !casilla1.getPieza().getColor().equals(tablero.getArregloTablero()[fi][co].getPieza().getColor())) {
                    int[] pos = {8, 7, 6, 5, 4, 3, 2, 1, 0};
                    if (casilla1.getCoordenada().getLetra().equals(String.valueOf((char) (97 + co))) && casilla1.getCoordenada().getNumero() == pos[fi]) {
                        return;
                    }
                    if (casilla1.getPieza().puedeMoverse(tablero.getArregloTablero()[fi][co], tablero.getArregloTablero())) {
                        if (tablero.getArregloTablero()[fi][co].getPieza() != null) {
                            if (tablero.getArregloTablero()[fi][co].getPieza().getColor() != casilla1.getPieza().getColor()) {
                                JLabel l = new JLabel();
                                ImageIcon image = new ImageIcon(getClass().getResource(tablero.getArregloTablero()[fi][co].getPieza().getUrl(tablero.getArregloTablero()[fi][co].getColor())));
                                Icon icon = new ImageIcon(image.getImage().getScaledInstance(70, 60, Image.SCALE_DEFAULT));
                                l.setIcon(icon);
                                if (tablero.getArregloTablero()[fi][co].getPieza().getColor() == Color.NEGRO) {
                                    piezasN.setLayout(new java.awt.GridLayout(4, 4));
                                    piezasN.add(l);
                                    piezasN.paintAll(piezasN.getGraphics());
                                } else {
                                    piezasB.setLayout(new java.awt.GridLayout(4, 4));
                                    piezasB.add(l);
                                    piezasB.paintAll(piezasB.getGraphics());
                                }
                            }
                        }
                        tablero.getArregloTablero()[fi][co].setPieza(casilla1.getPieza());
                        tablero.getArregloTablero()[fi][co].getPieza().setCasilla(tablero.getArregloTablero()[fi][co]);
                        casilla1.setPieza(null);
                        casilla1 = null;
                        label = null;
                        if (estado) {
                            timer.stop();
                            timer2.start();
                            tablero.setTurno(Color.NEGRO);
                            estado = false;
                        } else {
                            timer2.stop();
                            tablero.setTurno(Color.BLANCO);
                            timer.start();
                            estado = true;
                        }
                        crearLabels();
                        if (validarNegra()) {
                            timer.stop();
                            timer2.stop();
                            JOptionPane.showMessageDialog(null, lblJug2.getText() + "\nHA GANADO.");
                        }
                        if (validarBlanca()) {
                            timer.stop();
                            timer2.stop();
                            JOptionPane.showMessageDialog(null, lblJug1.getText() + "\nHA GANADO.");
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
        String jug1 = String.valueOf(tablero.getPartida().getJugador1().charAt(tablero.getPartida().getJugador1().length() - 1));
        if (jug1.equals("1")) {
            lblJug2.setText(tablero.getPartida().getJugador1().replace("1", ""));
            lblJug1.setText(tablero.getPartida().getJugador2());
        } else {
            lblJug1.setText(tablero.getPartida().getJugador1());
            lblJug2.setText(tablero.getPartida().getJugador2().replace("1", ""));
        }
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
        piezasB = new javax.swing.JPanel();
        pnlJug2 = new javax.swing.JPanel();
        piezasN = new javax.swing.JPanel();
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
        jButton2 = new javax.swing.JButton();
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 690, -1, -1));

        pnlJug1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pnlJug1.setOpaque(false);
        pnlJug1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblJug1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pnlJug1.add(lblJug1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 345, 23));

        time.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time.setText("10:00");
        pnlJug1.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 165, 29));

        piezasB.setOpaque(false);

        javax.swing.GroupLayout piezasBLayout = new javax.swing.GroupLayout(piezasB);
        piezasB.setLayout(piezasBLayout);
        piezasBLayout.setHorizontalGroup(
            piezasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        piezasBLayout.setVerticalGroup(
            piezasBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        pnlJug1.add(piezasB, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 77, -1, -1));

        getContentPane().add(pnlJug1, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 24, 370, 320));

        pnlJug2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        pnlJug2.setOpaque(false);
        pnlJug2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        piezasN.setOpaque(false);

        javax.swing.GroupLayout piezasNLayout = new javax.swing.GroupLayout(piezasN);
        piezasN.setLayout(piezasNLayout);
        piezasNLayout.setHorizontalGroup(
            piezasNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        piezasNLayout.setVerticalGroup(
            piezasNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        pnlJug2.add(piezasN, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 77, -1, -1));

        lblJug2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pnlJug2.add(lblJug2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 8, 345, 25));

        time2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        time2.setText("10:00");
        pnlJug2.add(time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 42, 165, 29));

        getContentPane().add(pnlJug2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 370, 320));

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

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("NUEVA PARTIDA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 690, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/vistaJuego.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 1230, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timer.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        piezasB.removeAll();
        piezasN.removeAll();
        piezasB.repaint();
        piezasN.repaint();
        casilla1 = null;
        casilla2 = null;
        estado = true;
        minutos = 9;
        minutos2 = 9;
        segundos = 60;
        segundos2 = 60;
        timer.stop();
        timer2.stop();
        Casilla.setCont(0);
        Coordenada.setLetraColumna(0);
        Coordenada.setNumeroFijo(8);
        Casilla.setEsBlanca(true);
        Coordenada.setCont(0);
        time.setText("10:00");
        time2.setText("10:00");
        timer = new Timer(1000, accion);
        timer2 = new Timer(1000, accion2);
        tablero = new Tablero();
        tablero.setTurno(Color.BLANCO);
        inicioJuego();
    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean validarNegra() {
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Rey && tablero.getArregloTablero()[filas][columnas].getPieza().getColor().equals(Color.NEGRO)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validarBlanca() {
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 0; columnas < 8; columnas++) {
                if (tablero.getArregloTablero()[filas][columnas].getPieza() instanceof Rey && tablero.getArregloTablero()[filas][columnas].getPieza().getColor().equals(Color.BLANCO)) {
                    return false;
                }
            }
        }
        return true;
    }

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
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel piezasB;
    private javax.swing.JPanel piezasN;
    private javax.swing.JPanel pnlJug1;
    private javax.swing.JPanel pnlJug2;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time2;
    // End of variables declaration//GEN-END:variables
}
