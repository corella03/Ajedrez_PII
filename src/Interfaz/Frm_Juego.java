/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import Logica_Juego.*;
import Pieza.Torre;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
import Tablero.*;
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
        inicioJuego();
    }
    public Frm_Juego(Logica log) {
        initComponents();
        h1 = new Thread(this);
        this.log = log;
        inicioJuego();
    }
    public void inicioJuego(){
        creaLabels();
        piezas();
        setBackground();
        ver();
        System.out.println(log.getTablero().getArregloTablero()[6][6].getColor());
        System.out.println(log.getTablero().getArregloTablero()[6][7].getCoordenada());
       log.getTablero().getArregloTablero()[6][7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close.png")));
    }
    public void ver(){
        for (int filas = 0; filas < 8; filas++) {
            for (int columnas = 1; columnas < 8; columnas++) {
                System.out.println(log.getTablero().getArregloTablero()[filas][columnas].getCoordenada());
            }
        }
    }
    public void creaLabels() {
        int x = 5;
        int y = 20;
        int l = 0;
        int n = 8;
        Border border = LineBorder.createBlackLineBorder();
        for (int filas = 0; filas < 9; filas++) {
            for (int columnas = 0; columnas < 9; columnas++) {
                log.getMatrizL()[filas][columnas] = 0;
                log.getTablero().getArregloTablero()[filas][columnas] = new Casilla(x, y, 80, 80);
                //System.out.println(log.getTablero().getArregloTablero()[filas][columnas].getColor());
                ButtonController bt = new ButtonController();//method that make labels action
                log.getTablero().getArregloTablero()[filas][columnas].addMouseListener(bt);
                if (columnas > 0 & filas < 8) {
                    if(log.getTablero().getArregloTablero()[filas][columnas].getColor() == Color.BLANCO) {                       
                        log.getTablero().getArregloTablero()[filas][columnas].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/white.jpg")));
                    } else if(log.getTablero().getArregloTablero()[filas][columnas].getColor() == Color.NEGRO){
                        log.getTablero().getArregloTablero()[filas][columnas].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black.jpg")));                        
                    }
                    log.getTablero().getArregloTablero()[filas][columnas].setBorder(border);
                } else if (!(columnas == 0 & filas == 8)) {
                    if (columnas == 0) {
                        log.getTablero().getArregloTablero()[filas][columnas].setText(String.valueOf(n) +" " );
                        log.getTablero().getArregloTablero()[filas][columnas].setFont(new java.awt.Font("Arial", 0, 25));
                        log.getTablero().getArregloTablero()[filas][columnas].setHorizontalAlignment(SwingConstants.RIGHT);
                        n--;
                    } else if (columnas > 0 & filas == 8) {
                        log.getTablero().getArregloTablero()[filas][columnas].setText(String.valueOf((char) ('a' + l)));
                        log.getTablero().getArregloTablero()[filas][columnas].setFont(new java.awt.Font("Arial", 0, 25));
                        log.getTablero().getArregloTablero()[filas][columnas].setHorizontalAlignment(SwingConstants.CENTER);
                        log.getTablero().getArregloTablero()[filas][columnas].setVerticalAlignment(SwingConstants.TOP);
                        l++;
                    }
                }
                jpanel.add(log.getTablero().getArregloTablero()[filas][columnas]);
                x += 80;
            }
            y += 80;
            x = 5;
            
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
            if (!log.isBus()) {
                
                for (int f = 0; f < 9; f++) {
                    for (int k = 0; k < 9; k++) {
                       
                        if (e.getSource().equals(log.getTablero().getArregloTablero()[f][k])) {
                            log.setF(f);
                            log.setC(k);
                            log.setBus(true);
                            f = 8;
                            k = 8;
                        }
                    }
                }
            } else {
                for (int f = 0; f < 9; f++) {
                    for (int k = 0; k < 9; k++) {
                         
                        if (e.getSource().equals(log.getTablero().getArregloTablero()[f][k]) & log.getMatrizL()[f][k] == 0) {
                            log.getTablero().getArregloTablero()[f][k].setIcon(log.getTablero().getArregloTablero()[log.getF()][log.getC()].getIcon());
                            log.getMatrizL()[log.getF()][log.getC()] = 0;
                            log.getTablero().getArregloTablero()[log.getF()][log.getC()].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/black.jpg")));
                            log.setF(0);
                            log.setC(0);
                            log.setBus(false);  
                            f = 8;
                            k = 8;
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
    public void setBackground(){
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(null);
        lblJug1.setText(log.getJugador1());
        lblJug2.setText(log.getJugador2());
    }
    public void piezas(){
        //Piezas Negras
        log.getTablero().getArregloTablero()[0][1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreNB.jpg")));
        log.getTablero().getArregloTablero()[0][2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoNN.jpg")));
        log.getTablero().getArregloTablero()[0][3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilNB.jpg")));
        log.getTablero().getArregloTablero()[0][4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reinaNN.jpg")));
        log.getTablero().getArregloTablero()[0][5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reyNB.jpg")));
        log.getTablero().getArregloTablero()[0][6].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilNN.jpg")));
        log.getTablero().getArregloTablero()[0][7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoNB.jpg")));
        log.getTablero().getArregloTablero()[0][8].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreNN.jpg")));
        log.getTablero().getArregloTablero()[1][1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNN.jpg")));
        log.getTablero().getArregloTablero()[1][2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNB.jpg")));
        log.getTablero().getArregloTablero()[1][3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNN.jpg")));
        log.getTablero().getArregloTablero()[1][4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNB.jpg")));
        log.getTablero().getArregloTablero()[1][5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNN.jpg")));
        log.getTablero().getArregloTablero()[1][6].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNB.jpg")));
        log.getTablero().getArregloTablero()[1][7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNN.jpg")));
        log.getTablero().getArregloTablero()[1][8].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonNB.jpg")));
        //Piezas Blancas
        log.getTablero().getArregloTablero()[7][1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreBN.jpg")));
        log.getTablero().getArregloTablero()[7][2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoBB.jpg")));
        log.getTablero().getArregloTablero()[7][3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilBN.jpg")));
        log.getTablero().getArregloTablero()[7][4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reinaBB.jpg")));
        log.getTablero().getArregloTablero()[7][5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reyBN.jpg")));
        log.getTablero().getArregloTablero()[7][6].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/alfilBB.jpg")));
        log.getTablero().getArregloTablero()[7][7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caballoBN.jpg")));
        log.getTablero().getArregloTablero()[7][8].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/torreBB.jpg"))); 
        log.getTablero().getArregloTablero()[6][1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBB.jpg")));
        log.getTablero().getArregloTablero()[6][2].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBN.jpg")));
        log.getTablero().getArregloTablero()[6][3].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBB.jpg")));
        log.getTablero().getArregloTablero()[6][4].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBN.jpg")));
        log.getTablero().getArregloTablero()[6][5].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBB.jpg")));
        log.getTablero().getArregloTablero()[6][6].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBN.jpg")));
        log.getTablero().getArregloTablero()[6][7].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBB.jpg")));
        log.getTablero().getArregloTablero()[6][8].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/peonBN.jpg")));
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
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );

        getContentPane().add(jpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    private javax.swing.JPanel jpanel;
    private javax.swing.JLabel lblJug1;
    private javax.swing.JLabel lblJug2;
    private javax.swing.JPanel pnlJug1;
    private javax.swing.JPanel pnlJug2;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time2;
    // End of variables declaration//GEN-END:variables
}