package SudokuCode.Frontend;

import SudokuCode.Backend.Sudoku;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;


public class SudokuMain {
    int selection = 0;
    boolean pencilMode = false;
    static SudokuMain parameters = new SudokuMain();
    static Timer timer = new Timer();
    private int moveCounter;
    public static final ImageIcon icWhite = new ImageIcon("src/SudokuCode/Images/white.jpg");
    public static final ImageIcon icBlue = new ImageIcon("src/SudokuCode/Images/blue.jpg");
    public static final ImageIcon icGrey = new ImageIcon("src/SudokuCode/Images/grey.jpg");
    public static final ImageIcon icSudoku = new ImageIcon("src/SudokuCode/Images/sudoku.jpg");
    public static final ImageIcon icRed = new ImageIcon("src/SudokuCode/Images/red.jpg");

    public static void main(String[] args) {
        //icons:

        //Object construction:

        Level l = (Level) JOptionPane.showInputDialog(null, "Choose difficultly", "Welcome to Sudoku!", JOptionPane.QUESTION_MESSAGE,
                new ImageIcon(icSudoku.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)), Level.values(), Level.values()[0]
        );
        if (l == null) System.exit(0);

        Sudoku sudoku = new Sudoku(l.getDifficulty());
        parameters.setMoveCounter(l.getDifficulty());
        int[][] solved = sudoku.getFullGrid();
        int[][] masked = sudoku.getMaskedGrid();


        //Frame:
        MyFrame frame = new MyFrame(600, 600, "Sudoku");
        frame.setIconImage(new ImageIcon("Production/src/Images/sudoku.jpg").getImage());

        //Panel:
        SudokuPanel sudokuPanel = new SudokuPanel(frame);//frame is a parameter to get its size
        frame.add(sudokuPanel);

        //9 by 9 Button Grid (BG):

        SudokuButton[][] arrBG = new SudokuButton[9][9];
        //drawing each button in the nested for loop
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SudokuButton bg = new SudokuButton(i, j);
                if (masked[i][j] != 0) bg.setText(masked[i][j] + "");

                if (masked[i][j] == 0) {
                    bg.possible = new ArrayList<>(Sudoku.possibleNumsInPosition(masked, i, j));
                }
                arrBG[i][j] = bg;
                Container c = new Container(i, j);

                bg.addActionListener(e -> {
                    //if the selection matches and pencil mode is off
                    if (!parameters.isPencilMode() && parameters.selection != 0) {
                        //if the selection matches
                        if (parameters.getSelection() == solved[c.i][c.j]) {
                            parameters.moveCounter--;
                            TimerTask exit0 = new TimerTask() {
                                @Override
                                public void run() {
                                    System.exit(0);
                                }
                            };
                            if (parameters.moveCounter == 0) timer.schedule(exit0, 1500);

                            arrBG[c.i][c.j].setText(parameters.getSelection() + "");
                            masked[c.i][c.j] = parameters.getSelection();
                            //remove pencil drawings and revaluate options for the rest of the btns
                            for (int k = 0; k < 9; k++) {
                                for (int m = 0; m < 9; m++) {
                                    bg.possible = new ArrayList<>(Sudoku.possibleNumsInPosition(masked, k, m));
                                    if (arrBG[c.i][c.j].isDrawnOn()) {
                                        arrBG[c.i][c.j].drawn.clear();
                                        arrBG[c.i][c.j].repaint();
                                        arrBG[c.i][c.j].removeDrawnOn();
                                    }
                                    if (arrBG[k][m].isDrawnOn()) {
                                        int boxRow = c.i - c.i % 3;
                                        int boxCol = c.j - c.j % 3;
                                        arrBG[c.i][m].drawn.remove((Integer) parameters.getSelection());
                                        arrBG[k][c.j].drawn.remove((Integer) parameters.getSelection());
                                        for (int n = boxRow; n < boxRow + 3; n++) {
                                            for (int o = boxCol; o < boxCol + 3; o++) {
                                                arrBG[n][o].drawn.remove((Integer) parameters.getSelection());
                                            }
                                        }
                                        arrBG[k][m].repaint();

                                    }
                                }
                            }
                        } else {//if the selection is not correct
                            arrBG[c.i][c.j].setIcon(new ImageIcon(icRed.getImage().getScaledInstance(41, 41, Image.SCALE_DEFAULT)));
                            TimerTask wrong = new TimerTask() {
                                @Override
                                public void run() {
                                    arrBG[c.i][c.j].setIcon(new ImageIcon(icWhite.getImage().getScaledInstance(41, 41, Image.SCALE_DEFAULT)));
                                }
                            };
                            timer.schedule(wrong, 400);
                        }
                    } else if (parameters.isPencilMode() && parameters.getSelection() != 0) {
                        int temp = parameters.getSelection();
                        if (arrBG[c.i][c.j].possible.contains(temp) && !arrBG[c.i][c.j].drawn.contains(temp)) {
                            arrBG[c.i][c.j].drawn.add(temp);
                            arrBG[c.i][c.j].drawnOn();
                            arrBG[c.i][c.j].repaint();
                        }
                    }


                });


                sudokuPanel.add(bg);


            }
        }
        // Bottom selection buttons(BB):
        int bSize = 50;
        JButton[] arrBB = new JButton[9];
        for (int i = 0; i < 9; i++) {
            JButton bb = new JButton((i + 1) + "");
            bb.setIcon(new ImageIcon(icWhite.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT)));
            bb.setHorizontalTextPosition(SwingConstants.CENTER);
            bb.setFont(new Font("Arial Black", Font.PLAIN, 30));
            bb.setBorder(new LineBorder(Color.BLACK));
            bb.setBounds(30 + i * (bSize + 2), 30 + 9 * 40 + 100, bSize, bSize);
            sudokuPanel.add(bb);
            arrBB[i] = bb;
            Container cc = new Container(i);

            bb.addActionListener(e -> {
                parameters.setSelection(Integer.parseInt(arrBB[cc.i].getText()));
                for (int j = 0; j < 9; j++) {
                    for (int k = 0; k < 9; k++) {
                        if (arrBG[j][k].isDrawnOn()) {
                            arrBG[j][k].repaint();
                        }
                    }
                }
            });

        }

        //pencil
        JButton p = new JButton();
        p.setText("" + '\u270F');
        p.setVisible(true);
        p.setFont(new Font("Calibre", Font.PLAIN, 25));
        p.setMargin(new Insets(1, 1, 1, 1));
        p.setBackground(Color.lightGray);
        p.setHorizontalTextPosition(SwingConstants.CENTER);
        p.setBounds(420, 100, 40, 40);
        sudokuPanel.add(p);
        p.addActionListener(e -> parameters.swapPencilMode());

        //fast pencil

        JButton fp = new JButton();
        fp.setText("" + '\u26A1');
        fp.setVisible(true);
        fp.setFont(new Font("Calibre", Font.BOLD, 25));
        fp.setMargin(new Insets(1, 1, 1, 1));
        fp.setBackground(Color.lightGray);
        fp.setHorizontalTextPosition(SwingConstants.CENTER);
        fp.setBounds(420, 150, 40, 40);
        fp.addActionListener(e -> {
            runFastPencil(arrBG);
        });
        sudokuPanel.add(fp);

        sudokuPanel.repaint();
    }

    public static void runFastPencil(SudokuButton[][] arrBG) {
        for (SudokuButton[] i : arrBG) {
            for (SudokuButton j : i) {
                if (Objects.equals(j.getText(), "")) {
                    j.drawn = new ArrayList<>(j.possible);
                    j.drawnOn();
                    j.repaint();
                }
            }
        }
    }

    public boolean isPencilMode() {
        return pencilMode;
    }

    public void swapPencilMode() {
        this.pencilMode = !this.pencilMode;
    }

    public int getSelection() {
        return selection;
    }

    public void setSelection(int selection) {
        this.selection = selection;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }
}
