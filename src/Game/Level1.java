/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

/**
 *
 * @author agusbudianto2
 */
public class Level1 extends javax.swing.JFrame {

    private Thread time, mover1, mover2, mover3, mover4,wincondition;
    public Level1() {
        initComponents();
        this.setLocationRelativeTo(null);
        startThread();
    }
    public void CreateThread(){
        Method timer = new Method(minute,second,kucing);
        this.time = timer.Ttime(star1, star2, star3);
        createThreads();
//        winThread();
    }
    public void endGame(){
        start = false;
        stopThread();
        if(win){
            winPanel.setVisible(true);
            star1.setBounds(451,340,36,35);
            star2.setBounds(490,340,36,35);
            star3.setBounds(530,340,36,35);
        }else{
            losePanel.setVisible(true);
        }
    }
    public void winThread(){
        wincondition = new Thread(){
            public void run() {
                while (true) {
                    if (new Method().isCollide(kucing, winarea)) {
                        win = true;
                        endGame();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
    }
    public void createThreads(){
        mover1 = new Thread(){
            public void run() {
                int ms = 0;
                while (true) {
                    if(ms%3==0) {
                        mobil1.setLocation(mobil1.getX() + 1, mobil1.getY()); //3
                        mobil2.setLocation(mobil2.getX() - 1 , mobil2.getY());//3
                    }
                    if(ms%2==0) {
                        mobil4.setLocation(mobil4.getX() - 1 , mobil4.getY());//2
                    }
                    if(ms%4==0) mobil3.setLocation(mobil3.getX() + 1, mobil3.getY());//4
                    if (new Method().isCollide(mobil1, kucing) || new Method().isCollide(mobil2, kucing) || new Method().isCollide(mobil3, kucing) || new Method().isCollide(mobil4, kucing)) {
                        endGame();
                    }
                    if (new Method().isCollide(kucing, winarea) && ms%1000==0) {
                        win = true;
                        endGame();
                    }
                    try {
                        Thread.sleep(1);
                        ms++;
                    } catch (InterruptedException ex) {
                    }
                    if (mobil1.getX() + mobil1.getWidth() > 1020) {
                        mobil1.setLocation(0-mobil1.getWidth(), mobil1.getY());
                    }
                    if (mobil2.getX() + mobil2.getWidth() < 0) {
                        mobil2.setLocation(1020, mobil2.getY());
                    }
                    if (mobil3.getX() + mobil3.getWidth() > 1020) {
                        mobil3.setLocation(0-mobil3.getWidth(), mobil3.getY());
                    }
                    if (mobil4.getX() + mobil4.getWidth() < 0) {
                        mobil4.setLocation(1020, mobil4.getY());
                    }
                }
            }
        };
    }

    public void startThread(){
        CreateThread();
//        wincondition.start();
        time.start();
        mover1.start();
    }
    public void stopThread(){
//        wincondition.interrupt();
        time.interrupt();
        mover1.interrupt();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bintangPanel = new JPanel();
        winPanel = new JPanel();
        losePanel = new JPanel();
        winLabel = new JLabel();
        loseLabel = new JLabel();
        mobil1 = new javax.swing.JLabel();
        mobil2 = new javax.swing.JLabel();
        mobil3 = new javax.swing.JLabel();
        mobil4 = new javax.swing.JLabel();
        pagar6 = new javax.swing.JLabel();
        pagar5 = new javax.swing.JLabel();
        pagar4 = new javax.swing.JLabel();
        pagar3 = new javax.swing.JLabel();
        pagar2 = new javax.swing.JLabel();
        pagar1 = new javax.swing.JLabel();
        pagar7 = new javax.swing.JLabel();
        pagar8 = new javax.swing.JLabel();
        pagar9 = new javax.swing.JLabel();
        pagar10 = new javax.swing.JLabel();
        pagar11 = new javax.swing.JLabel();
        pagar12 = new javax.swing.JLabel();
        bendera1 = new javax.swing.JLabel();
        bendera2 = new javax.swing.JLabel();
        bintang = new JPanel();
        winarea = new JLabel();
        star1 = new JLabel();
        star2 = new JLabel();
        star3 = new JLabel();
        second = new javax.swing.JLabel();
        minute = new javax.swing.JLabel();
        panelTime = new javax.swing.JLabel();
        minute1 = new javax.swing.JLabel();
        kucing = new javax.swing.JLabel();
        rumput1 = new javax.swing.JLabel();
        jalan1 = new javax.swing.JLabel();
        rumput2 = new javax.swing.JLabel();
        jalan2 = new javax.swing.JLabel();
        rumput3 = new javax.swing.JLabel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(sizeframe);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(star1);
        getContentPane().add(star2);
        getContentPane().add(star3);
        winPanel.setBounds(this.getX()+220, this.getY()+93, 600, 420);
        winLabel.setBounds(winPanel.getBounds());
        winLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/win.png")));
        winPanel.add(winLabel);
        winPanel.setBackground(new Color(0,0,0,0));
        winPanel.setVisible(false);
        getContentPane().add(winPanel);


        losePanel.setBounds(this.getX()+220, this.getY()+93, 600, 420);
        loseLabel.setBounds(losePanel.getBounds());
        loseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lose.png")));
        losePanel.add(loseLabel);
        losePanel.setBackground(new Color(0,0,0,0));
        losePanel.setVisible(false);
        getContentPane().add(losePanel);



        mobil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rightImage/merah.png"))); // NOI18N
        getContentPane().add(mobil1);
        mobil1.setBounds(0, 505 , 57, 30);

        mobil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leftImage/taxi.png"))); // NOI18N
        getContentPane().add(mobil2);
        mobil2.setBounds(974, 460, 57, 30);

        mobil3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rightImage/biru.png"))); // NOI18N
        getContentPane().add(mobil3);
        mobil3.setBounds(0, 280, 57, 30);

        mobil4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/leftImage/polisi.png"))); // NOI18N
        getContentPane().add(mobil4);
        mobil4.setBounds(974, 180, 57, 30);

        pagar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar6);
        pagar6.setBounds(10, 80, 59, 22);

        pagar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar5);
        pagar5.setBounds(360, 80, 59, 22);

        pagar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar4);
        pagar4.setBounds(290, 80, 59, 22);

        pagar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar3);
        pagar3.setBounds(220, 80, 59, 22);

        pagar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar2);
        pagar2.setBounds(150, 80, 59, 22);

        pagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar1);
        pagar1.setBounds(80, 80, 59, 22);

        pagar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar7);
        pagar7.setBounds(600, 80, 59, 22);

        pagar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar8);
        pagar8.setBounds(950, 80, 59, 22);

        pagar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar9);
        pagar9.setBounds(880, 80, 59, 22);

        pagar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar10);
        pagar10.setBounds(810, 80, 59, 22);

        pagar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar11);
        pagar11.setBounds(740, 80, 59, 22);

        pagar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pagar.png"))); // NOI18N
        getContentPane().add(pagar12);
        pagar12.setBounds(670, 80, 59, 22);

        bendera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bendera2.png"))); // NOI18N
        getContentPane().add(bendera1);
        bendera1.setBounds(440, 30, 60, 52);

        bendera2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bendera1.png"))); // NOI18N
        getContentPane().add(bendera2);
        bendera2.setBounds(530, 30, 60, 52);

        second.setFont(new java.awt.Font("Galvji", 1, 14)); // NOI18N
        second.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        second.setText("00");
        second.setForeground(Color.WHITE);
        second.setBounds(70 , 25, 40, 40);
        getContentPane().add(second);

        minute.setFont(new java.awt.Font("Galvji", 1, 14)); // NOI18N
        minute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minute.setText("00");
        minute.setForeground(Color.WHITE);
        minute.setBounds(40, 25, 40, 40);
        getContentPane().add(minute);

        minute1.setFont(new java.awt.Font("Galvji", 1, 14)); // NOI18N
        minute1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minute1.setText(":");
        minute1.setForeground(Color.WHITE);
        minute1.setBounds(55, 25, 40, 40);
        getContentPane().add(minute1);


        panelTime.setIcon(new ImageIcon(getClass().getResource("/image/waktuu.png")));
        panelTime.setBounds(35, 10, 86, 55);
        panelTime.setText("Run Time : \n"+minute.getText()+":"+second.getText());
        panelTime.setForeground(Color.WHITE);

        getContentPane().add(panelTime);

//
        star1.setBounds(930,20,36,35);
        star1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bintangku.png")));
        star2.setBounds(890,20,36,35);
        star2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bintangku.png")));
        star3.setBounds(850,20,36,35);
        star3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bintangku.png")));

        winarea.setBounds(420, 0, 180, 82);
        winarea.setBackground(Color.WHITE);
        getContentPane().add(winarea);


        kucing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Kucing.png"))); // NOI18N
        getContentPane().add(kucing);
        kucing.setBounds(500, 550, 20, 50);

        rumput1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/finish.png"))); // NOI18N
        rumput1.setPreferredSize(new java.awt.Dimension(2021, 219));
        getContentPane().add(rumput1);
        rumput1.setBounds(0, 0, 1020, 110);

        jalan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jalan1.png"))); // NOI18N
        getContentPane().add(jalan1);
        jalan1.setBounds(0, 440, 1024, 111);

        rumput2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput.png"))); // NOI18N
        getContentPane().add(rumput2);
        rumput2.setBounds(0, 550, 1020, 110);

        jalan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/jalan2.png"))); // NOI18N
        getContentPane().add(jalan2);
        jalan2.setBounds(0, 110, 1024, 220);

        rumput3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rumput.png"))); // NOI18N
        rumput3.setPreferredSize(new java.awt.Dimension(2021, 219));
        getContentPane().add(rumput3);
        rumput3.setBounds(0, 330, 1020, 110);

        pack();

    }// </editor-fold>//GEN-END:initComponents


    private void formKeyPressed(java.awt.event.KeyEvent evt) {
        int key = evt.getKeyCode();
        Method lets = new Method(kucing);
        if(start) {
            switch (key) {
                case KeyEvent.VK_UP:
                    if (kucing.getY() > 132) {
                        lets.moveUp();
                    } else if (kucing.getY() <= 132 && kucing.getX() > 410 && kucing.getX() < 580 && kucing.getY() >30) {
                        lets.moveUp();
                    }


                    break;
                case KeyEvent.VK_W:
                    if (kucing.getY() > 132) {
                        lets.moveUp();
                    } else if (kucing.getY() <= 132 && kucing.getX() > 410 && kucing.getX() < 580 && kucing.getY() >30) {
                        lets.moveUp();
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (kucing.getY() < 600) {
                        lets.moveDown();
                    }
                    break;
                case KeyEvent.VK_S:
                    if (kucing.getY() < 600) {
                        lets.moveDown();
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if (!(kucing.getY() <= 120 && kucing.getX() < 450)) {
                        lets.moveLeft();
                    }
                    break;
                case KeyEvent.VK_A:
                    if (!(kucing.getY() <= 120 && kucing.getX() < 450)) {
                        lets.moveLeft();
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (!(kucing.getY() <= 120 && kucing.getX() > 530)) {
                        lets.moveRight();
                    }
                    break;
                case KeyEvent.VK_D:
                    if (!(kucing.getY() <= 120 && kucing.getX() > 530)) {
                        lets.moveRight();
                    }
                    break;
            }
        }else{
            if(key == KeyEvent.VK_ENTER) {
                new Level1().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_formKeyPressed

    
    //private ImageIcon = new ImageIcon()

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final java.awt.Dimension sizeframe = new java.awt.Dimension(1020, 687);
    private boolean win = false;
    private boolean start = true;
    private JPanel winPanel;
    private JLabel winLabel;
    private JPanel bintangPanel;
    private JPanel losePanel;
    private JLabel loseLabel;
    private javax.swing.JLabel mobil1;
    private javax.swing.JLabel mobil2;
    private javax.swing.JLabel mobil3;
    private javax.swing.JLabel mobil4;
    private javax.swing.JLabel bendera1;
    private javax.swing.JLabel bendera2;
    private javax.swing.JPanel bintang;
    private JLabel winarea;
    private javax.swing.JLabel star1;
    private javax.swing.JLabel star2;
    private javax.swing.JLabel star3;
    private javax.swing.JLabel jalan1;
    private javax.swing.JLabel jalan2;
    private javax.swing.JLabel kucing;
    private javax.swing.JLabel minute;
    private JLabel panelTime;
    private javax.swing.JLabel minute1;
    private javax.swing.JLabel pagar1;
    private javax.swing.JLabel pagar10;
    private javax.swing.JLabel pagar11;
    private javax.swing.JLabel pagar12;
    private javax.swing.JLabel pagar2;
    private javax.swing.JLabel pagar3;
    private javax.swing.JLabel pagar4;
    private javax.swing.JLabel pagar5;
    private javax.swing.JLabel pagar6;
    private javax.swing.JLabel pagar7;
    private javax.swing.JLabel pagar8;
    private javax.swing.JLabel pagar9;
    private javax.swing.JLabel rumput1;
    private javax.swing.JLabel rumput2;
    private javax.swing.JLabel rumput3;
    private javax.swing.JLabel second;
    // End of variables declaration//GEN-END:variables
}