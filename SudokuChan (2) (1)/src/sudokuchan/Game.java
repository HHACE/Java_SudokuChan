/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuchan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author ADMIN
 */
public class Game extends javax.swing.JFrame {

    RecordList rl = new RecordList();
    int check;

    int time;
    boolean ready = false;
    Sudoku sudoku;
        
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     

    
    public RecordList getRl() {
        return rl;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public Game() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//        lblSudokuChan.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/Sprite-0001-export.png")).getImage(), 1920, 995)));
            btnBack.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonBack.png")).getImage(), 130, 130)));
            lblBackground.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/gameplaceholderv1.jpg")).getImage(), 1920, 995)));


        sudoku = new Sudoku();
        btnCheckActionPerformed(null);
        PNLGameScreen.setLayout(new BorderLayout());
        PNLGameScreen.add(Sudoku.getP(), BorderLayout.CENTER);
        Sudoku.getP().setLabelTime(lblTimer);
        Sudoku.getP().checkGame(btnCheck);
        layerWinGame.setVisible(false);

        this.setTitle("Sudoku-Chan and The Ancient Puzzle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/img/CustomMousev1.png")).getImage(), new Point(0, 0), "custom");
        setCursor(cursor);
        
        setTitle("Sudoku-Chan");
        
    }
    
    Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/img/CustomMousev1hover.png")).getImage(), new Point(0, 0), "custom");

    
    public boolean messageConfirmNewGame() {
        ImageIcon wannaStartNewGame = new ImageIcon("src/img/sadboy.png");
        Image newImage = wannaStartNewGame.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon iconn = new ImageIcon(newImage);
        UIManager.put("OptionPane.buttonFont", new Font("young circle", Font.ITALIC, 30));
        check = JOptionPane.showConfirmDialog(null, "<html><b style = \"color:red; font-size:20px\">Your gameplay answers will be gone!\n<html><b style = \"color:red; font-size:20px\">Do you still want to do this?", " NOTIFICATION!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, (Icon) iconn);
        if (check == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
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

        layerWinGame = new javax.swing.JLayeredPane();
        lblOption = new javax.swing.JLabel();
        btnContinue = new javax.swing.JButton();
        btnQuitAfterWin = new javax.swing.JButton();
        btnChooseLevelAfterWin = new javax.swing.JButton();
        txtFieldYourName = new javax.swing.JTextField();
        lblPEYN = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblShowPoint = new javax.swing.JTextPane();
        pnlControl = new javax.swing.JPanel();
        btnNewGame = new javax.swing.JButton();
        lblTimer = new javax.swing.JLabel();
        btnCheck = new javax.swing.JButton();
        PNLGameScreen = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        lblSudokuChan = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layerWinGame.setBackground(new java.awt.Color(255, 255, 255));
        layerWinGame.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 204, 0)));
        layerWinGame.setOpaque(true);

        lblOption.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblOption.setText("YOU WIN!");

        btnContinue.setBackground(new java.awt.Color(255, 255, 255));
        btnContinue.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnContinue.setText("Continue");
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        btnQuitAfterWin.setBackground(new java.awt.Color(255, 102, 102));
        btnQuitAfterWin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnQuitAfterWin.setText("Quit Game");
        btnQuitAfterWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitAfterWinActionPerformed(evt);
            }
        });

        btnChooseLevelAfterWin.setBackground(new java.awt.Color(204, 0, 255));
        btnChooseLevelAfterWin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnChooseLevelAfterWin.setText("Choose Level");
        btnChooseLevelAfterWin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseLevelAfterWinActionPerformed(evt);
            }
        });

        txtFieldYourName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtFieldYourName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtFieldYourName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldYourNameActionPerformed(evt);
            }
        });
        txtFieldYourName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldYourNameKeyPressed(evt);
            }
        });

        lblPEYN.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblPEYN.setText("   Please enter your name: ");
        lblPEYN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblShowPoint.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(lblShowPoint);

        layerWinGame.setLayer(lblOption, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerWinGame.setLayer(btnContinue, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerWinGame.setLayer(btnQuitAfterWin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerWinGame.setLayer(btnChooseLevelAfterWin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerWinGame.setLayer(txtFieldYourName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerWinGame.setLayer(lblPEYN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layerWinGame.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layerWinGameLayout = new javax.swing.GroupLayout(layerWinGame);
        layerWinGame.setLayout(layerWinGameLayout);
        layerWinGameLayout.setHorizontalGroup(
            layerWinGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerWinGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layerWinGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layerWinGameLayout.createSequentialGroup()
                        .addComponent(lblPEYN, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFieldYourName))
                    .addGroup(layerWinGameLayout.createSequentialGroup()
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChooseLevelAfterWin, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitAfterWin, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerWinGameLayout.createSequentialGroup()
                        .addComponent(lblOption)
                        .addGap(231, 231, 231)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layerWinGameLayout.setVerticalGroup(
            layerWinGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerWinGameLayout.createSequentialGroup()
                .addComponent(lblOption, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layerWinGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPEYN)
                    .addComponent(txtFieldYourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layerWinGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerWinGameLayout.createSequentialGroup()
                        .addComponent(btnContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layerWinGameLayout.createSequentialGroup()
                        .addGroup(layerWinGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuitAfterWin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnChooseLevelAfterWin, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        getContentPane().add(layerWinGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 680, -1));

        pnlControl.setBackground(new java.awt.Color(255, 255, 255));
        pnlControl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 5, true));

        btnNewGame.setBackground(new java.awt.Color(0, 255, 204));
        btnNewGame.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnNewGame.setText("New Game");
        btnNewGame.setCursor(cursor);
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        lblTimer.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTimer.setText("   Time: 00:00:00");
        lblTimer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), new java.awt.Color(255, 0, 0), null));

        btnCheck.setBackground(new java.awt.Color(255, 0, 0));
        btnCheck.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCheck.setText("Check Game");
        btnCheck.setCursor(cursor);
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControlLayout = new javax.swing.GroupLayout(pnlControl);
        pnlControl.setLayout(pnlControlLayout);
        pnlControlLayout.setHorizontalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlControlLayout.setVerticalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(pnlControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 350, 280));

        PNLGameScreen.setBackground(new java.awt.Color(255, 255, 255));
        PNLGameScreen.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 255, 204)));

        javax.swing.GroupLayout PNLGameScreenLayout = new javax.swing.GroupLayout(PNLGameScreen);
        PNLGameScreen.setLayout(PNLGameScreenLayout);
        PNLGameScreenLayout.setHorizontalGroup(
            PNLGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        PNLGameScreenLayout.setVerticalGroup(
            PNLGameScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );

        getContentPane().add(PNLGameScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 850, 850));

        btnBack.setBackground(new java.awt.Color(255, 51, 0));
        btnBack.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        btnBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(cursor);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblSudokuChan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSudokuChan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/placeholder0001.png0001.gif"))); // NOI18N
        getContentPane().add(lblSudokuChan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        lblBackground.setBackground(new java.awt.Color(0, 255, 255));
        lblBackground.setOpaque(true);
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 995));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        if (messageConfirmNewGame()) {
            MenuScreen menu = new MenuScreen();
            menu.show();
            dispose();
        }

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        if (ready) {
            if (messageConfirmNewGame()) {
                Sudoku.getP().newGame();
            }
        } else {
            Sudoku.getP().newGame();
            ready = true;
        }
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        if (Sudoku.getP().checkGame(btnCheck)) {
            layerWinGame.setVisible(true);
            PNLGameScreen.setEnabled(false);
            pnlControl.setEnabled(false);
            btnNewGame.setEnabled(false);
            lblTimer.setEnabled(false);
            btnBack.setEnabled(false);
            Sudoku.getP().getCenter().setVisible(false);
            String time = lblTimer.getText().substring(9, lblTimer.getText().length());
            lblPEYN.setVisible(false);
            txtFieldYourName.setVisible(false);
            /*============= EASY LEVEL =============*/
            if (Sudoku.getLevel() == 2) {
                for (int i = 0; i < 5; i++) {
                    if (time.compareTo(rl.getListOfEasy().get(i).getTime()) < 0) {
                        lblShowPoint.setText("  Your time is " + time + "." + "\n  Congratulations! You now are at TOP#" + (i + 1));
                        lblPEYN.setVisible(true);
                        txtFieldYourName.setVisible(true);
                        break;
                    } else {
                        lblShowPoint.setText("  Your time is " + time + "." + "\n  Nice game!!");
                    }
                }
                /*============= NORMAL LEVEL =============*/
            } else if (Sudoku.getLevel() == 3) {

                for (int i = 0; i < 5; i++) {
                    if (time.compareTo(rl.getListOfMedium().get(i).getTime()) < 0) {
                        lblShowPoint.setText("  Your time is " + time + "." + "\n  Congratulations! You now are at TOP#" + (i + 1));
                        lblPEYN.setVisible(true);
                        txtFieldYourName.setVisible(true);
                        break;
                    } else {
                        lblShowPoint.setText("  Your time is " + time + "." + "\n  Nice game!!");
                    }
                }
                /*============= HARD LEVEL =============*/
            } else if (Sudoku.getLevel() == 4) {

                for (int i = 0; i < 5; i++) {
                    if (time.compareTo(rl.getListOfHard().get(i).getTime()) < 0) {
                        lblShowPoint.setText("  Your time is " + time + "." + "\nCongratulations! You now are at TOP#" + (i + 1));
                        lblPEYN.setVisible(true);
                        txtFieldYourName.setVisible(true);
                        break;
                    } else {
                        lblShowPoint.setText("  Your time is " + time + "." + "\n  Nice game!!");
                    }
                }

            }

        }
//          

    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnQuitAfterWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitAfterWinActionPerformed
        // TODO add your handling code here: 
        saveWinner();
        System.exit(0);
        dispose();
    }//GEN-LAST:event_btnQuitAfterWinActionPerformed

    public void saveWinner() {
        if (txtFieldYourName.getText().equals("")) {
            txtFieldYourName.setText("Someone");
        }
        String time = lblTimer.getText().substring(9, lblTimer.getText().length());

        /*============= EASY LEVEL =============*/
        if (Sudoku.getLevel() == 2) {
            if (time.compareTo(rl.getListOfEasy().get(4).getTime()) < 0) {
                rl.addNewWinnerEasy(txtFieldYourName.getText(), time);
                rl.saveData();
            }
        } /*============= NORMAL LEVEL =============*/ else if (Sudoku.getLevel() == 3) {
            if (time.compareTo(rl.getListOfMedium().get(4).getTime()) < 0) {
                rl.addNewWinnerNormal(txtFieldYourName.getText(), time);
                rl.saveData();
            }
        } /*============= HARD LEVEL =============*/ else if (Sudoku.getLevel() == 4) {
            if (time.compareTo(rl.getListOfHard().get(4).getTime()) < 0) {
                rl.addNewWinnerHard(txtFieldYourName.getText(), time);
                rl.saveData();
            }
        }

        txtFieldYourName.setText("");
    }


    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
        // TODO add your handling code here:
        saveWinner();
        layerWinGame.setVisible(false);
        PNLGameScreen.setEnabled(true);
        pnlControl.setEnabled(true);
        btnNewGame.setEnabled(true);
        lblTimer.setEnabled(true);
        btnBack.setEnabled(true);
        Sudoku.getP().getCenter().setVisible(true);
        Sudoku.getP().newGame();


    }//GEN-LAST:event_btnContinueActionPerformed

    private void btnChooseLevelAfterWinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseLevelAfterWinActionPerformed
        saveWinner();
        MenuScreen menu = new MenuScreen();
        menu.show();
        this.dispose();
        menu.menuToChooseLevel();
    }//GEN-LAST:event_btnChooseLevelAfterWinActionPerformed


    private void txtFieldYourNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldYourNameActionPerformed

    }//GEN-LAST:event_txtFieldYourNameActionPerformed

    private void txtFieldYourNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldYourNameKeyPressed
        String yourName = txtFieldYourName.getText();
        int length = yourName.length();
        char c = evt.getKeyChar();
        if (length < 10) {
            txtFieldYourName.setEditable(true);
        } else {
            txtFieldYourName.setEditable(false);
        }
        if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
            txtFieldYourName.setEditable(true);
        }
    }//GEN-LAST:event_txtFieldYourNameKeyPressed

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PNLGameScreen;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnChooseLevelAfterWin;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JButton btnQuitAfterWin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane layerWinGame;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblPEYN;
    private javax.swing.JTextPane lblShowPoint;
    private javax.swing.JLabel lblSudokuChan;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JTextField txtFieldYourName;
    // End of variables declaration//GEN-END:variables
}
