package sudokuchan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class controlPanel extends javax.swing.JPanel {

    Sudoku game;
    private int[][] temp = new int[9][9];
    private int[][] grid = new int[9][9];
    private Timer timer;
    private static JTextField[][] boxes;
    private JPasswordField pass = new JPasswordField("mortadda");
    private JLabel lblTimeSet;
    private JLabel lblWinGame;
    private JPanel[][] paneles;
    private JPanel center;
    private int counter = 0;
    private int rightAnswer = 0;
    boolean correct = true;

    public JTextField newtextfield() {
        JTextField j = new JTextField("");
        j.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        j.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
        j.setHorizontalAlignment(JTextField.CENTER);
        /*-------------------mouse lisner----------------*/
        j.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.decode("#f6ea80")));
                    ((JTextField) e.getSource()).setBackground(Color.decode("#f6ea80"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.lightGray));
                    ((JTextField) e.getSource()).setBackground(Color.white);
                }
            }
        });
        /*------------------------------------------------*/

        j.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (j.isEditable()) {
                    ((JTextField) e.getSource()).setForeground(Color.decode("#0c4"));
                } else {
                    ((JTextField) e.getSource()).setForeground(Color.black);
                }
            }
        });
        return j;
    }

    public JPanel[][] getPaneles() {
        return paneles;
    }

    public JPanel getCenter() {
        return center;
    }

    public controlPanel() {
        initComponents();
        /*------------------------main panal  -------------------------------------*/
        center = new JPanel();  //main panel
        center.setLayout(new GridLayout(3, 3));     //grid for 3*3 
        center.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(center);  //add main panel to frame 
        boxes = new JTextField[9][9];
        paneles = new JPanel[3][3];
        timer = new Timer(1000, action);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                paneles[i][j] = new JPanel();
                paneles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                paneles[i][j].setLayout(new GridLayout(3, 3));
                center.add(paneles[i][j]);
            }
        }
        /*------------------------text fildes in boxes-------------------------------------*/
        for (int n = 0; n < 9; n++) {
            for (int i = 0; i < 9; i++) {
                boxes[n][i] = newtextfield();
                int fm = (n + 1) / 3;
                if ((n + 1) % 3 > 0) {
                    fm++;
                }
                int cm = (i + 1) / 3;
                if ((i + 1) % 3 > 0) {
                    cm++;
                }
                paneles[fm - 1][cm - 1].add(boxes[n][i]);   //add box to panel 
            }
        }

    }

    public void setLabelTime(JLabel label) {
        this.lblTimeSet = label;
    }

    public JLabel getLblWinGame() {
        return lblWinGame;
    }

    public int getCounter() {
        return counter;
    }

    ActionListener action = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            lblTimeSet.setText(TimeFormat(counter));
            counter++;
        }
    };

    /*------------------------panal for new game button -------------------------------------*/
    public void newGame() {

        counter = 0;
        timer.start();
        resetGame();
        Sudoku.newGame();

    }

    /*------------------------panal for check game button -------------------------------------*/
    public boolean checkGame(JButton check) {

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                rightAnswer = 0;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (!boxes[i][j].isEditable()) {
                            rightAnswer++;
                            continue;
                        } else if (boxes[i][j].getText().equals(String.valueOf(grid[i][j]))) {
                            boxes[i][j].setBackground(Color.green);
                            rightAnswer++;
                        } else if (boxes[i][j].getText().trim().isEmpty()) {
                            boxes[i][j].setBackground(Color.WHITE);
                            continue;
                        } else {
                            boxes[i][j].setBackground(Color.red);
                            correct = false;
                        }
                    }
                }

            }
        }
        );
        if (!correct) {
            counter += 30;
        }

        if (rightAnswer == 81) {
            System.out.println("Victory");
            timer.stop();
            center.setEnabled(false);

            return true;
        } else {
            return false;
        }
    }

    public void changeLevelEasy(JButton easy) {
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
                counter = 0;
//                timer.start();
                Sudoku.setlevel(2);
                Sudoku.newGame();
            }

        });

    }

    public void changeLevelNormal(JButton medium) {
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
                counter = 0;
////                timer.start();
                Sudoku.setlevel(3);
                Sudoku.newGame();
            }

        });

    }

    public void changeLevelHard(JButton hard) {
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
                counter = 0;
//                timer.start();
                Sudoku.setlevel(4);
                Sudoku.newGame();
            }

        });

    }

    /*------------------------panal for new Hard button -------------------------------------*/
    public void solve(JButton solve) {
        solve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if (pass.getText().equals("mortadda")) {
                    timer.stop();
                    counter = 0;
                    lblTimeSet.setText(TimeFormat(counter));
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            boxes[i][j].setText(String.valueOf(grid[i][j]));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(center, "your password incorrect");
                }
            }
        }
        );
    }

    public void setArray(int[][] grid, int[][] temp) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.temp[i][j] = temp[i][j];
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public void setTextLable() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.temp[i][j] != 0) {
                    boxes[i][j].setText(String.valueOf(this.temp[i][j]));
                    boxes[i][j].setEditable(false);
                    boxes[i][j].setBackground(Color.decode("#C0DCC0"));
                } else {
                    boxes[i][j].setText("");
                }
            }
        }
    }

    public static void resetGame() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boxes[i][j].setForeground(Color.black);
                boxes[i][j].setEditable(true);
                boxes[i][j].setBackground(Color.WHITE);
            }
        }
    }

    private String TimeFormat(int count) {
        int hours = count / 3600;
        int minutes = (count - hours * 3600) / 60;
        int seconds = count - minutes * 60;
        return String.format("   Time: " + "%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
