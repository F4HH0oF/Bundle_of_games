package connection;

import Random_Game_2048.RandomGame;
import SeaChess.SeaChess;
import SudokuCode.Frontend.SudokuMain;
import Word_Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BundleOfGames extends JFrame {
    private JPanel panel = new JPanel();

    public BundleOfGames() {
        setTitle("Bundle of GAMES");
        int x = 500;
        int y = 500;
        setSize(x, y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setLayout(null);
        setVisible(true);

        JRadioButton randomGame = new JRadioButton("2048");
        JRadioButton seaChessGame = new JRadioButton("Sea Chess");
        JRadioButton sudokuGame = new JRadioButton("Sudoku");
        JRadioButton wordGame = new JRadioButton("Word Game");
        JButton readyButton = new JButton("Ready");

        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose();
                if (randomGame.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play 2048", "2048", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        RandomGame frame = new RandomGame();
                        frame.setVisible(true);
                    } else {
                        dispose();
                        BundleOfGames frame = new BundleOfGames();
                        frame.setVisible(true);
                    }
                }

                if (seaChessGame.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play Sea Chess", "Sea Chess", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        SeaChess frame = new SeaChess();
                        frame.setVisible(true);
                    } else {
                        dispose();
                        BundleOfGames frame = new BundleOfGames();
                        frame.setVisible(true);
                    }
                }

                if (sudokuGame.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play Sudoku", "Sudoku", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        SudokuMain frame = new SudokuMain();
                        setVisible(true);
                    } else {
                        dispose();
                        BundleOfGames frame = new BundleOfGames();
                        frame.setVisible(true);
                    }
                }

                if (wordGame.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play Word Game", "Word Game", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        Game frame = null;
                        try {
                            frame = new Game();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        frame.setVisible(true);
                    } else {
                        dispose();
                        BundleOfGames frame = new BundleOfGames();
                        frame.setVisible(true);
                    }
                }
            }

        });


        randomGame.setBounds(x / 2 - x / 15, y / 10 * 3, x / 10, y / 25);
        seaChessGame.setBounds(x / 2 - x / 15, y / 10 * 4, x / 10, y / 25);
        sudokuGame.setBounds(x / 2 - x / 15, y / 10 * 5, x / 10, y / 25);
        wordGame.setBounds(x / 2 - x / 15, y / 10 * 6, x / 10, y / 25);
        readyButton.setBounds(x / 2 - x / 15, y / 10 * 7, x / 10, y / 25);

        randomGame.setBackground(Color.WHITE);
        seaChessGame.setBackground(Color.WHITE);
        sudokuGame.setBackground(Color.WHITE);
        wordGame.setBackground(Color.WHITE);
        readyButton.setBackground(Color.WHITE);
        ButtonGroup bg = new ButtonGroup();
        bg.add(randomGame);
        bg.add(seaChessGame);
        bg.add(sudokuGame);
        bg.add(wordGame);

        panel.setBackground(Color.GRAY);
        panel.add(randomGame);
        panel.add(seaChessGame);
        panel.add(sudokuGame);
        panel.add(wordGame);
        panel.add(readyButton);


    }

    public static void main(String[] args) {
        BundleOfGames bundleOfGames = new BundleOfGames();
    }
}
