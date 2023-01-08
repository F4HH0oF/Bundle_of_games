package SeaChess;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.util.Random;

public class SeaChess extends JFrame {
    private JPanel chessPanel = new JPanel();
    public int br;

    public SeaChess() {
        setTitle("Sea Chess");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int x = 814;
        int y = 839;
        setSize(x, y);
        setLocationRelativeTo(null);
        setContentPane(chessPanel);
        setLayout(null);
        setVisible(true);

        x = 800;
        y = 800;
        JLabel label = new JLabel();
        label.setBounds(0, 0, x - 2, y / 10);
        label.setBackground(Color.BLACK);
        label.setBorder(new LineBorder(Color.BLACK, 2));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Ink Free", Font.BOLD, 75));
        label.setOpaque(true);
        chessPanel.add(label);
        label.setForeground(Color.GREEN);
        label.setText("Tic-Tac-Toe");
        firstTurnWait();
        label.setText("Wait...");
        firstTurnWait();
        if (choosePlayer() == 0) {
            label.setText("O turn");
        } else {
            label.setText("X turn");
        }

        JButton[][] masButton = new JButton[3][3];
        int x1 = 0, y1 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setBounds(x1, y / 10 + y1, x / 3, y / 10 * 3);
                button.addActionListener(e -> {
                    if (label.getText().equals("O turn")) {
                        button.setFont(new Font("", Font.BOLD, 100));
                        if (button.getText().equals("")) {
                            button.setForeground(Color.BLUE);
                            button.setText("O");
                            label.setText("X turn");
                            br = 0;
                            repaint();
                        }
                    } else {
                        button.setFont(new Font("", Font.BOLD, 100));
                        if (button.getText().equals("")) {
                            button.setForeground(Color.RED);
                            button.setText("X");
                            label.setText("O turn");
                            br = 1;
                            repaint();
                        }
                    }
                    if (winCheck(masButton)) {
                        Frame frame = new Frame();
                        if (br == 1) {
                            for (int k = 0; k < 3; k++) {
                                for (int l = 0; l < 3; l++) {
                                    masButton[k][l].setEnabled(false);
                                }
                            }
                            label.setText("Winner X !!!");
                            JOptionPane.showMessageDialog(frame, "Winner X");

                        } else {
                            for (int k = 0; k < 3; k++) {
                                for (int l = 0; l < 3; l++) {
                                    masButton[k][l].setEnabled(false);
                                }
                            }
                            label.setText("Winner O !!!");
                            frame.setLocationRelativeTo(null);
                            frame.setOpacity(1);
                            JOptionPane.showMessageDialog(frame, "Winner O");
                        }
                        dispose();
                        SeaChess seaChess = new SeaChess();
                    } else if (end(masButton)) {
                        Frame frame = new Frame();
                        label.setText("Draw");
                        JOptionPane.showMessageDialog(frame, "Draw");
                        dispose();
                        SeaChess seaChess = new SeaChess();
                    }


                });
                masButton[i][j] = button;
                chessPanel.add(button);
                x1 += x / 3;
            }
            y1 += y / 10 * 3;
            x1 = 0;
        }
        repaint();

    }

    public static void main(String[] args) {
        SeaChess seaChess = new SeaChess();
    }

    public int choosePlayer() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public boolean winCheck(JButton[][] masButton) {
        int brCol = 0;
        int brROw = 0;

        String mas[][] = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mas[i][j] = masButton[i][j].getText();
            }
        }

        int i = 0;
        int j = 0;
        for (int k = 0; k < 3; k++) {
            if (mas[i][j].equals(mas[i][j + 1]) && mas[i][j + 1].equals(mas[i][j + 2]) && (!mas[i][j].equals(""))) {
                masButton[i][j].setBackground(Color.GREEN);
                masButton[i][j + 1].setBackground(Color.GREEN);
                masButton[i][j + 2].setBackground(Color.GREEN);
                return true;
            }
            i++;
        }
        i = 0;
        j = 0;
        for (int m = 0; m < 3; m++) {
            if (mas[i][j].equals(mas[i + 1][j]) && mas[i + 1][j].equals(mas[i + 2][j]) && (!mas[i][j].equals(""))) {
                masButton[i][j].setBackground(Color.GREEN);
                masButton[i + 1][j].setBackground(Color.GREEN);
                masButton[i + 2][j].setBackground(Color.GREEN);
                return true;
            }
            j++;
        }

        i = 0;
        j = 0;

        if (mas[i][j].equals(mas[i + 1][j + 1]) && mas[i + 1][j + 1].equals(mas[i + 2][j + 2]) && (!mas[i][j].equals(""))) {
            masButton[i][j].setBackground(Color.GREEN);
            masButton[i + 1][j + 1].setBackground(Color.GREEN);
            masButton[i + 2][j + 2].setBackground(Color.GREEN);
            return true;
        }

        i = 0;
        j = 0;
        if (mas[i][j + 2].equals(mas[i + 1][j + 1]) && mas[i + 1][j + 1].equals(mas[i + 2][j]) && (!mas[i][j + 2].equals(""))) {
            masButton[i][j + 2].setBackground(Color.GREEN);
            masButton[i + 1][j + 1].setBackground(Color.GREEN);
            masButton[i][j + 2].setBackground(Color.GREEN);
            return true;
        }


        return false;
    }

    public void firstTurnWait() {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public boolean end(JButton[][] masButton) {
        int br = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (masButton[i][j].getText().equals("")) {
                    br++;
                }

            }
        }
        if (br == 0) {
            return true;
        }
        return false;
    }
}