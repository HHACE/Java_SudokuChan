/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokuchan;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 *
 * @author ADMIN
 */
public class MenuScreen extends javax.swing.JFrame {
    
    Game game = new Game();
    
     AudioClip music, music2;
//        static GraphicsDevice device = GraphicsEnvironment
//        .getLocalGraphicsEnvironment().getScreenDevices()[0];

//        GraphicsEnvironment gEnviromant = GraphicsEnvironment.getLocalGraphicsEnvironment();
//       GraphicsDevice gDevice = gEnviromant.getDefaultScreenDevice();
//    public void setFullScreen() {
//        gDevice.setFullScreenWindow(this);
//    }
    /**
     * Creates new form MenuScreen
     */
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    

    public MenuScreen() {
        initComponents();
        //this.setLocationRelativeTo(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        //this.setVisible(true);
        //new java.awt.Dimension(screenSize.width-200, screenSize.height-85-200)
        Sudoku sudoku = new Sudoku();
        Sudoku.getP().changeLevelEasy(btnP_Easy);
        Sudoku.getP().changeLevelNormal(btnP_Normal);
        Sudoku.getP().changeLevelHard(btnP_Hard);
        jLabel2.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/BGtempholder_Miku.png")).getImage(), screenSize.width, screenSize.height - 85)));
        lblH2P_Background.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jLBookUiPlay.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jLBookUiBoard.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jLPlayText.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/SettingTextDif.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jLBookUiCredit.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jLCreditText.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/AboutUs.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jlH2P_Text.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/HowToPlayPage1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        jLInform1.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/inform1.png")).getImage(), 500, 170)));
        jLInform2.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/inform2.png")).getImage(), 600, 280)));
        jLInform3.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/inform3.png")).getImage(), 650, 650)));

        
        backToMainScreen();
        pnlMainOption.setOpaque(false);

//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//                    BufferedImage image = null;
//        try {
//            image = ImageIO.read(new File("src/img/titleScreenv1-exportx2.gif"));
//        } catch (IOException ex) {
//            Logger.getLogger(MenuScreen.class.getName()).log(Level.SEVERE, null, ex);
//        }
//                    Image i2 = image.getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
//
//                    Title.setIcon(new javax.swing.ImageIcon(i2));
//        //device.setFullScreenWindow(this);
        //ImageIcon image;
        //image = new ImageIcon("C:/Users/ADMIN/Downloads/NbENe.gif");
        // jPanelTest.add(new TestPane());
        //getContentPane().add(new TestPane(), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        mouseEffect1.registerMouseEffect();
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        //setFullScreen();
        // Toolkit toolkit = Toolkit.getDefaultToolkit();
        //Image image = toolkit.getImage();
        // Point hotspot = new Point(0,0);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/img/CustomMousev1.png")).getImage(), new Point(0, 0), "custom");
        setCursor(cursor);
//        
        music = Applet.newAudioClip(this.getClass().getResource("/mp3/Inst.wav"));
        music2 = Applet.newAudioClip(this.getClass().getResource("/mp3/offsetSong.wav"));

        music2.stop();

        music.play();
        
        setTitle("Sudoku-Chan");
//        
    }


        
    Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("/img/CustomMousev1hover.png")).getImage(), new Point(0, 0), "custom");

//    public class TestPane extends JPanel {
//
//        private ImageIcon image;
//
//        public TestPane() {
//            image = new ImageIcon("src/img/titleScreenv1-exportx2.gif");
//        }
//
//        @Override
//        public Dimension getPreferredSize() {
//            return new Dimension(600, 600);
//        }
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            int imageWidth = image.getIconWidth();
//            int imageHeight = image.getIconHeight();
//
//            if (imageWidth == 0 || imageHeight == 0) {
//                return;
//            }
//            double widthScale = (double)getWidth() / (double)imageWidth;
//            double heightScale = (double)getHeight() / (double)imageHeight;
//            Graphics2D g2d = (Graphics2D) g.create();
//            g2d.drawImage(image.getImage(), AffineTransform.getScaleInstance(widthScale, heightScale), this);
//            g2d.dispose();
//        }
//
//    }
    
    
    
    
    public void settingEnableF() {
        btnPlay.setEnabled(false);
        btnBoard.setEnabled(false);
        btnHowToPlay.setEnabled(false);
        btnCredits.setEnabled(false);
        btnQuit.setEnabled(false);
    }
    
        public void settingEnableT() {
        btnPlay.setEnabled(true);
        btnBoard.setEnabled(true);
        btnHowToPlay.setEnabled(true);
        btnCredits.setEnabled(true);
        btnQuit.setEnabled(true);
    }
    
    
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public void backToMainScreen() {
        layeredSecond.setVisible(false);
        pnlChooseLevel.setVisible(false);
        pnlHow2Play.setVisible(false);
        pnlBoard.setVisible(false);
        pnlQuit.setVisible(false);
        pnlCredits.setVisible(false);
        //pnlMainOption.setVisible(true);
        settingEnableT();
    }

    public void menuToChooseLevel() {
        layeredSecond.setVisible(true);
        pnlChooseLevel.setVisible(true);
        pnlHow2Play.setVisible(false);
        pnlBoard.setVisible(false);
        pnlQuit.setVisible(false);
        pnlCredits.setVisible(false);
        //pnlMainOption.setEnabled(false);
        settingEnableF();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FlowPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        layeredSecond = new javax.swing.JLayeredPane();
        pnlHow2Play = new javax.swing.JPanel(new FlowLayout(FlowLayout.CENTER));
        btnH2P_ReNext = new javax.swing.JButton();
        btnH2P_Next = new javax.swing.JButton();
        btnH2P_X = new javax.swing.JButton();
        jLInform2 = new javax.swing.JLabel();
        jLInform1 = new javax.swing.JLabel();
        jLInform3 = new javax.swing.JLabel();
        jlH2P_Text = new javax.swing.JLabel();
        lblH2P_Background = new javax.swing.JLabel();
        pnlChooseLevel = new javax.swing.JPanel(new FlowLayout(FlowLayout.CENTER));
        btnP_Easy = new javax.swing.JButton();
        btnP_Normal = new javax.swing.JButton();
        btnP_Hard = new javax.swing.JButton();
        btnPlayX = new javax.swing.JButton();
        jLPlayText = new javax.swing.JLabel();
        jLBookUiPlay = new javax.swing.JLabel();
        pnlCredits = new javax.swing.JPanel(new FlowLayout(FlowLayout.CENTER));
        jBCreditX = new javax.swing.JButton();
        jLCreditText = new javax.swing.JLabel();
        jLBookUiCredit = new javax.swing.JLabel();
        pnlQuit = new javax.swing.JPanel(new FlowLayout(FlowLayout.CENTER));
        jBQuitYes = new javax.swing.JButton();
        jBQuitNo = new javax.swing.JButton();
        jLQuitText = new javax.swing.JLabel();
        jLQuitPromUi = new javax.swing.JLabel();
        pnlBoard = new javax.swing.JPanel(new FlowLayout(FlowLayout.CENTER));
        jBBoardX = new javax.swing.JButton();
        btnRecord_Hard = new javax.swing.JButton();
        btnRecord_Easy = new javax.swing.JButton();
        btnRecord_Normal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textRecordData = new javax.swing.JTextPane();
        jLBookUiBoard = new javax.swing.JLabel();
        pnlMainOption = new javax.swing.JPanel();
        btnQuit = new javax.swing.JButton();
        btnCredits = new javax.swing.JButton();
        btnHowToPlay = new javax.swing.JButton();
        btnBoard = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        mouseEffect1 = new effect.MouseEffect();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FlowPanel.setOpaque(false);
        FlowPanel.setPreferredSize(new java.awt.Dimension(1920, 995));

        jPanel2.setOpaque(false);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(1920, 995));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layeredSecond.setOpaque(true);
        layeredSecond.setPreferredSize(new java.awt.Dimension(1920, 995));

        pnlHow2Play.setOpaque(false);
        pnlHow2Play.setPreferredSize(new java.awt.Dimension(1720, 795));
        pnlHow2Play.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnH2P_ReNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonReNext.png"))); // NOI18N
        btnH2P_ReNext.setBorderPainted(false);
        btnH2P_ReNext.setContentAreaFilled(false);
        btnH2P_ReNext.setCursor(cursor);
        btnH2P_ReNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnH2P_ReNextActionPerformed(evt);
            }
        });
        pnlHow2Play.add(btnH2P_ReNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 710, -1, -1));

        btnH2P_Next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonNext.png"))); // NOI18N
        btnH2P_Next.setBorderPainted(false);
        btnH2P_Next.setContentAreaFilled(false);
        btnH2P_Next.setCursor(cursor);
        btnH2P_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnH2P_NextActionPerformed(evt);
            }
        });
        pnlHow2Play.add(btnH2P_Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 700, -1, -1));

        btnH2P_X.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonX.png"))); // NOI18N
        btnH2P_X.setBorderPainted(false);
        btnH2P_X.setContentAreaFilled(false);
        btnH2P_X.setCursor(cursor);
        btnH2P_X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnH2P_XActionPerformed(evt);
            }
        });
        pnlHow2Play.add(btnH2P_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 50, -1, -1));

        jLInform2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inform2.png"))); // NOI18N
        pnlHow2Play.add(jLInform2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 440, -1, -1));

        jLInform1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inform1.png"))); // NOI18N
        pnlHow2Play.add(jLInform1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, -1));

        jLInform3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inform3.png"))); // NOI18N
        pnlHow2Play.add(jLInform3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        jlH2P_Text.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonNext.png"))); // NOI18N
        pnlHow2Play.add(jlH2P_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblH2P_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png"))); // NOI18N
        pnlHow2Play.add(lblH2P_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        layeredSecond.add(pnlHow2Play);
        pnlHow2Play.setBounds(110, 100, 1720, 795);
        pnlHow2Play.setVisible(false);

        pnlChooseLevel.setOpaque(false);
        pnlChooseLevel.setPreferredSize(new java.awt.Dimension(1720, 795));
        pnlChooseLevel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnP_Easy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonEasyv2.png"))); // NOI18N
        btnP_Easy.setBorderPainted(false);
        btnP_Easy.setContentAreaFilled(false);
        btnP_Easy.setCursor(cursor);
        btnP_Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_EasyActionPerformed(evt);
            }
        });
        pnlChooseLevel.add(btnP_Easy, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        btnP_Normal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonNormalv2.png"))); // NOI18N
        btnP_Normal.setBorderPainted(false);
        btnP_Normal.setContentAreaFilled(false);
        btnP_Normal.setCursor(cursor);
        btnP_Normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_NormalActionPerformed(evt);
            }
        });
        pnlChooseLevel.add(btnP_Normal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        btnP_Hard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonHardv2.png"))); // NOI18N
        btnP_Hard.setContentAreaFilled(false);
        btnP_Hard.setCursor(cursor);
        btnP_Hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP_HardActionPerformed(evt);
            }
        });
        pnlChooseLevel.add(btnP_Hard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, -1, -1));

        btnPlayX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonX.png"))); // NOI18N
        btnPlayX.setBorderPainted(false);
        btnPlayX.setContentAreaFilled(false);
        btnPlayX.setCursor(cursor);
        btnPlayX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayXActionPerformed(evt);
            }
        });
        pnlChooseLevel.add(btnPlayX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 30, -1, -1));

        jLPlayText.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLPlayText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonNext.png"))); // NOI18N
        jLPlayText.setToolTipText("");
        pnlChooseLevel.add(jLPlayText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLBookUiPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png"))); // NOI18N
        pnlChooseLevel.add(jLBookUiPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        layeredSecond.add(pnlChooseLevel);
        pnlChooseLevel.setBounds(110, 100, 1720, 795);
        pnlChooseLevel.setVisible(false);

        pnlCredits.setOpaque(false);
        pnlCredits.setPreferredSize(new java.awt.Dimension(1720, 795));
        pnlCredits.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBCreditX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonX.png"))); // NOI18N
        jBCreditX.setBorderPainted(false);
        jBCreditX.setContentAreaFilled(false);
        jBCreditX.setCursor(cursor);
        jBCreditX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreditXActionPerformed(evt);
            }
        });
        pnlCredits.add(jBCreditX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 50, -1, -1));

        jLCreditText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonNext.png"))); // NOI18N
        pnlCredits.add(jLCreditText, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLBookUiCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png"))); // NOI18N
        pnlCredits.add(jLBookUiCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        layeredSecond.add(pnlCredits);
        pnlCredits.setBounds(110, 100, 1720, 795);
        pnlCredits.setVisible(false);

        pnlQuit.setOpaque(false);
        pnlQuit.setPreferredSize(new java.awt.Dimension(1720, 795));
        pnlQuit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBQuitYes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonQuit.png"))); // NOI18N
        jBQuitYes.setBorderPainted(false);
        jBQuitYes.setContentAreaFilled(false);
        jBQuitYes.setCursor(cursor);
        jBQuitYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitYesActionPerformed(evt);
            }
        });
        pnlQuit.add(jBQuitYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

        jBQuitNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonBack.png"))); // NOI18N
        jBQuitNo.setBorderPainted(false);
        jBQuitNo.setContentAreaFilled(false);
        jBQuitNo.setCursor(cursor);
        jBQuitNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBQuitNoActionPerformed(evt);
            }
        });
        pnlQuit.add(jBQuitNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 450, -1, -1));

        jLQuitText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/QuitPromText1.png"))); // NOI18N
        pnlQuit.add(jLQuitText, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        jLQuitPromUi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/QuitPromUi.png"))); // NOI18N
        pnlQuit.add(jLQuitPromUi, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, -1, -1));

        layeredSecond.add(pnlQuit);
        pnlQuit.setBounds(110, 100, 1720, 795);
        pnlQuit.setVisible(false);

        pnlBoard.setOpaque(false);
        pnlBoard.setPreferredSize(new java.awt.Dimension(1720, 795));
        pnlBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBBoardX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettignUiButtonX.png"))); // NOI18N
        jBBoardX.setBorderPainted(false);
        jBBoardX.setContentAreaFilled(false);
        jBBoardX.setCursor(cursor);
        jBBoardX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBoardXActionPerformed(evt);
            }
        });
        pnlBoard.add(jBBoardX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 40, -1, -1));

        btnRecord_Hard.setBackground(new java.awt.Color(255, 51, 0));
        btnRecord_Hard.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btnRecord_Hard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonHardv2.png"))); // NOI18N
        btnRecord_Hard.setBorderPainted(false);
        btnRecord_Hard.setContentAreaFilled(false);
        btnRecord_Hard.setCursor(cursor);
        btnRecord_Hard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecord_HardActionPerformed(evt);
            }
        });
        pnlBoard.add(btnRecord_Hard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, -1));

        btnRecord_Easy.setBackground(new java.awt.Color(51, 255, 0));
        btnRecord_Easy.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btnRecord_Easy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonEasyv2.png"))); // NOI18N
        btnRecord_Easy.setToolTipText("");
        btnRecord_Easy.setContentAreaFilled(false);
        btnRecord_Easy.setCursor(cursor);
        btnRecord_Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecord_EasyActionPerformed(evt);
            }
        });
        pnlBoard.add(btnRecord_Easy, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        btnRecord_Normal.setBackground(new java.awt.Color(255, 255, 0));
        btnRecord_Normal.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btnRecord_Normal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonNormalv2.png"))); // NOI18N
        btnRecord_Normal.setBorderPainted(false);
        btnRecord_Normal.setContentAreaFilled(false);
        btnRecord_Normal.setCursor(cursor);
        btnRecord_Normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecord_NormalActionPerformed(evt);
            }
        });
        pnlBoard.add(btnRecord_Normal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        textRecordData.setEditable(false);
        textRecordData.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jScrollPane1.setViewportView(textRecordData);

        pnlBoard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 700, 560));

        jLBookUiBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SettingUIx145v1.png"))); // NOI18N
        pnlBoard.add(jLBookUiBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        layeredSecond.add(pnlBoard);
        pnlBoard.setBounds(110, 100, 1720, 795);
        pnlCredits.setVisible(false);

        jPanel3.add(layeredSecond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        layeredSecond.setVisible(false);
        layeredSecond.setBackground(new Color(0, 0, 0, 50));

        pnlMainOption.setOpaque(false);

        btnQuit.setBackground(new java.awt.Color(0, 51, 255));
        btnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonQuitv4.gif"))); // NOI18N
        btnQuit.setBorder(null);
        btnQuit.setContentAreaFilled(false);
        btnQuit.setCursor(cursor);
        btnQuit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonQuitv4hover.gif"))); // NOI18N
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnCredits.setBackground(new java.awt.Color(0, 51, 255));
        btnCredits.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonCreditsv4.gif"))); // NOI18N
        btnCredits.setBorder(null);
        btnCredits.setBorderPainted(false);
        btnCredits.setContentAreaFilled(false);
        btnCredits.setCursor(cursor);
        btnCredits.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonCreditsv4hover.gif"))); // NOI18N
        btnCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditsActionPerformed(evt);
            }
        });

        btnHowToPlay.setBackground(new java.awt.Color(0, 51, 255));
        btnHowToPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonHTPv4.gif"))); // NOI18N
        btnHowToPlay.setBorder(null);
        btnHowToPlay.setBorderPainted(false);
        btnHowToPlay.setContentAreaFilled(false);
        btnHowToPlay.setCursor(cursor);
        btnHowToPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonHTPv4hover.gif"))); // NOI18N
        btnHowToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHowToPlayActionPerformed(evt);
            }
        });

        btnBoard.setBackground(new java.awt.Color(0, 51, 255));
        btnBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBoardv1.gif"))); // NOI18N
        btnBoard.setBorder(null);
        btnBoard.setBorderPainted(false);
        btnBoard.setContentAreaFilled(false);
        btnBoard.setCursor(cursor);
        btnBoard.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonBoardv1hover.gif"))); // NOI18N
        btnBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoardActionPerformed(evt);
            }
        });

        btnPlay.setBackground(new java.awt.Color(0, 51, 255));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonPlayv4.gif"))); // NOI18N
        btnPlay.setToolTipText("");
        btnPlay.setContentAreaFilled(false);
        btnPlay.setCursor(cursor);
        btnPlay.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonPlayv4hover.gif"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainOptionLayout = new javax.swing.GroupLayout(pnlMainOption);
        pnlMainOption.setLayout(pnlMainOptionLayout);
        pnlMainOptionLayout.setHorizontalGroup(
            pnlMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainOptionLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHowToPlay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCredits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQuit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainOptionLayout.setVerticalGroup(
            pnlMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainOptionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPlay)
                    .addGroup(pnlMainOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnQuit)
                        .addComponent(btnHowToPlay)
                        .addComponent(btnCredits)
                        .addComponent(btnBoard)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.add(pnlMainOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 670, -1, 210));

        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/titleScreenv1-exportx2.gif"))); // NOI18N
        jPanel3.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FlowPanelLayout = new javax.swing.GroupLayout(FlowPanel);
        FlowPanel.setLayout(FlowPanelLayout);
        FlowPanelLayout.setHorizontalGroup(
            FlowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlowPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FlowPanelLayout.setVerticalGroup(
            FlowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FlowPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(FlowPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mouseEffect1.setFocusable(false);
        mouseEffect1.setOpaque(false);
        mouseEffect1.setPreferredSize(new java.awt.Dimension(1920, 995));
        mouseEffect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/placeholder_background.png"))); // NOI18N
        mouseEffect1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(mouseEffect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:

        layeredSecond.setVisible(true);
        pnlQuit.setVisible(true);
        pnlChooseLevel.setVisible(false);
        pnlHow2Play.setVisible(false);
        pnlBoard.setVisible(false);
        pnlCredits.setVisible(false);
        //pnlMainOption.setVisible(false);
        settingEnableF();

    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnHowToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHowToPlayActionPerformed
        // TODO add your handling code here:
        layeredSecond.setVisible(true);
        pnlChooseLevel.setVisible(false);
        pnlHow2Play.setVisible(true);
        pnlBoard.setVisible(false);
        pnlQuit.setVisible(false);
        pnlCredits.setVisible(false);
        //pnlMainOption.setVisible(false);
        settingEnableF();
        btnH2P_Next.setEnabled(true);
        btnH2P_ReNext.setEnabled(false);
        jlH2P_Text.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/HowToPlayPage1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));

        jLInform1.setVisible(true);
        jLInform2.setVisible(true);
        jLInform3.setVisible(false);
    }//GEN-LAST:event_btnHowToPlayActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        menuToChooseLevel();


    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditsActionPerformed
        // TODO add your handling code here:
        layeredSecond.setVisible(true);
        pnlCredits.setVisible(true);
        pnlChooseLevel.setVisible(false);
        pnlHow2Play.setVisible(false);
        pnlBoard.setVisible(false);
        pnlQuit.setVisible(false);
        //pnlMainOption.setVisible(false);
        settingEnableF();
    }//GEN-LAST:event_btnCreditsActionPerformed

    private void btnH2P_XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnH2P_XActionPerformed
        // TODO add your handling code here:
        
        backToMainScreen();
    }//GEN-LAST:event_btnH2P_XActionPerformed
    int H2Pcount =1;
    private void btnH2P_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnH2P_NextActionPerformed
        // TODO add your handling code here:

//        ImageIcon icon = new ImageIcon("src/img/SettignUiButtonReNext.png");
//        icon.getImage().flush();
//
//        jlH2P_Text.setIcon(icon);
            
       
        jlH2P_Text.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/HowToPlayPage2.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        btnH2P_ReNext.setEnabled(true);
        btnH2P_Next.setEnabled(false);
        jLInform1.setVisible(false);
        jLInform2.setVisible(false);
        jLInform3.setVisible(true);

    }//GEN-LAST:event_btnH2P_NextActionPerformed

    private void btnH2P_ReNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnH2P_ReNextActionPerformed
        // TODO add your handling code here:
//        ImageIcon icon = new ImageIcon("src/img/SettignUiButtonNext.png");
//        icon.getImage().flush();
//
//        jlH2P_Text.setIcon(icon);
            
                jlH2P_Text.setIcon(new javax.swing.ImageIcon(getScaledImage(new javax.swing.ImageIcon(getClass().getResource("/img/HowToPlayPage1.png")).getImage(), screenSize.width - 200, screenSize.height - 85 - 200)));
        btnH2P_ReNext.setEnabled(false);
        btnH2P_Next.setEnabled(true);
        jLInform1.setVisible(true);
        jLInform2.setVisible(true);
        jLInform3.setVisible(false);
        
    }//GEN-LAST:event_btnH2P_ReNextActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void btnP_EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_EasyActionPerformed
        // TODO add your handling code here:
        Game game = new Game();
        game.show();
        Sudoku.getP().changeLevelEasy(btnP_Easy);
        music.stop();
        music2.play();
        dispose();
    }//GEN-LAST:event_btnP_EasyActionPerformed

    private void btnP_NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_NormalActionPerformed
        // TODO add your handling code here:
        Game game = new Game();
        game.show();
        Sudoku.getP().changeLevelEasy(btnP_Normal);
        music.stop();
        music2.play();
        dispose();
        
    }//GEN-LAST:event_btnP_NormalActionPerformed

    private void btnPlayXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayXActionPerformed
        // TODO add your handling code here:
        backToMainScreen();
    }//GEN-LAST:event_btnPlayXActionPerformed

    private void btnP_HardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP_HardActionPerformed
        // TODO add your handling code here:
        Game game = new Game();
        game.show();
        Sudoku.getP().changeLevelEasy(btnP_Hard);
        music.stop();
        music2.play();
        dispose();
    }//GEN-LAST:event_btnP_HardActionPerformed

    private void jBCreditXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreditXActionPerformed
        // TODO add your handling code here:
        backToMainScreen();
    }//GEN-LAST:event_jBCreditXActionPerformed

    private void jBQuitYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitYesActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/img/QuitPromText2.png");
        icon.getImage().flush();
        jLQuitText.setIcon(icon);
        jBQuitNo.setEnabled(false);

        Timer timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                secondMethod();
            }

            private void secondMethod() {
                dispose();
                System.exit(0);//To change body of generated methods, choose Tools | Templates.
            }
        });
        timer.setRepeats(false);
        timer.start();


    }//GEN-LAST:event_jBQuitYesActionPerformed

    private void jBQuitNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBQuitNoActionPerformed
        // TODO add your handling code here:
        backToMainScreen();
//        layeredSecond.setVisible(true);
//        pnlChooseLevel.setVisible(false);
//        pnlHow2Play.setVisible(false);
//        pnlBoard.setVisible(false);
//        pnlQuit.setVisible(false);
//        pnlCredits.setVisible(false);
        //pnlMainOption.setVisible(true);
        
    }//GEN-LAST:event_jBQuitNoActionPerformed

    private void btnBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoardActionPerformed
        // TODO add your handling code here:
        layeredSecond.setVisible(true);
        pnlChooseLevel.setVisible(false);
        pnlHow2Play.setVisible(false);
        pnlBoard.setVisible(true);
        pnlQuit.setVisible(false);
        pnlCredits.setVisible(false);
        //pnlMainOption.setVisible(false);
        settingEnableF();
    }//GEN-LAST:event_btnBoardActionPerformed

    private void jBBoardXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBoardXActionPerformed
        // TODO add your handling code here:
        backToMainScreen();
    }//GEN-LAST:event_jBBoardXActionPerformed

    private void btnRecord_EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecord_EasyActionPerformed
        // TODO add your handling code here:
        textRecordData.setText(game.getRl().printEasy());
    }//GEN-LAST:event_btnRecord_EasyActionPerformed

    private void btnRecord_NormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecord_NormalActionPerformed
        textRecordData.setText(game.getRl().printNormal());
    }//GEN-LAST:event_btnRecord_NormalActionPerformed

    private void btnRecord_HardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecord_HardActionPerformed
        textRecordData.setText(game.getRl().printHard());//
    }//GEN-LAST:event_btnRecord_HardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel
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
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FlowPanel;
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnBoard;
    private javax.swing.JButton btnCredits;
    private javax.swing.JButton btnH2P_Next;
    private javax.swing.JButton btnH2P_ReNext;
    private javax.swing.JButton btnH2P_X;
    private javax.swing.JButton btnHowToPlay;
    private javax.swing.JButton btnP_Easy;
    private javax.swing.JButton btnP_Hard;
    private javax.swing.JButton btnP_Normal;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnPlayX;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRecord_Easy;
    private javax.swing.JButton btnRecord_Hard;
    private javax.swing.JButton btnRecord_Normal;
    private javax.swing.JButton jBBoardX;
    private javax.swing.JButton jBCreditX;
    private javax.swing.JButton jBQuitNo;
    private javax.swing.JButton jBQuitYes;
    private javax.swing.JLabel jLBookUiBoard;
    private javax.swing.JLabel jLBookUiCredit;
    private javax.swing.JLabel jLBookUiPlay;
    private javax.swing.JLabel jLCreditText;
    private javax.swing.JLabel jLInform1;
    private javax.swing.JLabel jLInform2;
    private javax.swing.JLabel jLInform3;
    private javax.swing.JLabel jLPlayText;
    private javax.swing.JLabel jLQuitPromUi;
    private javax.swing.JLabel jLQuitText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlH2P_Text;
    private javax.swing.JLayeredPane layeredSecond;
    private javax.swing.JLabel lblH2P_Background;
    private effect.MouseEffect mouseEffect1;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlChooseLevel;
    private javax.swing.JPanel pnlCredits;
    private javax.swing.JPanel pnlHow2Play;
    private javax.swing.JPanel pnlMainOption;
    private javax.swing.JPanel pnlQuit;
    private javax.swing.JTextPane textRecordData;
    // End of variables declaration//GEN-END:variables
}
