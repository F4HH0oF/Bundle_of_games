package Random_Game_2048;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class RandomGame extends JFrame implements KeyListener {
    private JPanel random_Panel;
    int start_button_br = 0;
    JLabel NumberLabel_1 = new JLabel("");
    JLabel NumberLabel_2 = new JLabel("");
    JLabel NumberLabel_3 = new JLabel("");
    JLabel NumberLabel_4 = new JLabel("");
    JLabel NumberLabel_5 = new JLabel("");
    JLabel NumberLabel_6 = new JLabel("");
    JLabel NumberLabel_7 = new JLabel("");
    JLabel NumberLabel_8 = new JLabel("");
    JLabel NumberLabel_9 = new JLabel("");
    JLabel NumberLabel_10 = new JLabel("");
    JLabel NumberLabel_11 = new JLabel("");
    JLabel NumberLabel_12 = new JLabel("");
    JLabel NumberLabel_13 = new JLabel("");
    JLabel NumberLabel_14 = new JLabel("");
    JLabel NumberLabel_15 = new JLabel("");
    JLabel NumberLabel_16 = new JLabel("");
    JLabel[] mas1 = {NumberLabel_1, NumberLabel_2, NumberLabel_3, NumberLabel_4};
    JLabel[] mas2 = {NumberLabel_5, NumberLabel_6, NumberLabel_7, NumberLabel_8};
    JLabel[] mas3 = {NumberLabel_9, NumberLabel_10, NumberLabel_11, NumberLabel_12};
    JLabel[] mas4 = {NumberLabel_13, NumberLabel_14, NumberLabel_15, NumberLabel_16};
    JLabel[][] mas = {mas1, mas2, mas3, mas4};
    JLabel bestScore = new JLabel();

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyLetter = e.getKeyChar();


        if (keyLetter == ' ') {
            int x = random_Panel.getWidth();
            int y = random_Panel.getHeight();
            Graphics g = random_Panel.getGraphics();

            bestScore.setBounds(x / 2 - x / 15, 10, x / 6 - 25, y / 30);
            bestScore.setVerticalAlignment(JLabel.CENTER);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            bestScore.setBorder(border);
            NumberLabel_1.setBounds(x / 5 - x / 10 + 10, y / 5 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_1.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_1.setOpaque(true);
            NumberLabel_2.setBounds(x / 5 * 2 - x / 10 + 10, y / 5 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_2.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_2.setOpaque(true);
            NumberLabel_3.setBounds(x / 5 * 3 - x / 10 + 10, y / 5 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_3.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_3.setOpaque(true);
            NumberLabel_4.setBounds(x / 5 * 4 - x / 10 + 10, y / 5 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_4.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_4.setOpaque(true);
            NumberLabel_5.setBounds(x / 5 - x / 10 + 10, y / 5 * 2 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_5.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_5.setOpaque(true);
            NumberLabel_6.setBounds(x / 5 * 2 - x / 10 + 10, y / 5 * 2 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_6.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_6.setOpaque(true);
            NumberLabel_7.setBounds(x / 5 * 3 - x / 10 + 10, y / 5 * 2 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_7.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_7.setOpaque(true);
            NumberLabel_8.setBounds(x / 5 * 4 - x / 10 + 10, y / 5 * 2 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_8.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_8.setOpaque(true);
            NumberLabel_9.setBounds(x / 5 - x / 10 + 10, y / 5 * 3 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_9.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_9.setOpaque(true);
            NumberLabel_10.setBounds(x / 5 * 2 - x / 10 + 10, y / 5 * 3 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_10.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_10.setOpaque(true);
            NumberLabel_11.setBounds(x / 5 * 3 - x / 10 + 10, y / 5 * 3 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_11.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_11.setOpaque(true);
            NumberLabel_12.setBounds(x / 5 * 4 - x / 10 + 10, y / 5 * 3 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_12.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_12.setOpaque(true);
            NumberLabel_13.setBounds(x / 5 - x / 10 + 10, y / 5 * 4 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_13.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_13.setOpaque(true);
            NumberLabel_14.setBounds(x / 5 * 2 - x / 10 + 10, y / 5 * 4 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_14.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_14.setOpaque(true);
            NumberLabel_15.setBounds(x / 5 * 3 - x / 10 + 10, y / 5 * 4 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_15.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_15.setOpaque(true);
            NumberLabel_16.setBounds(x / 5 * 4 - x / 10 + 10, y / 5 * 4 - y / 10 + 10, x / 5 - 20, y / 5 - 20);
            NumberLabel_16.setHorizontalAlignment(JLabel.CENTER);
            NumberLabel_16.setOpaque(true);


            g.drawLine(x / 5 - x / 10, y / 5 - y / 10, x / 5 - x / 10, y - y / 10);
            g.drawLine((x / 5 * 2) - x / 10, y / 5 - y / 10, (x / 5 * 2) - x / 10, y - y / 10);
            g.drawLine((x / 5 * 3) - x / 10, y / 5 - y / 10, (x / 5 * 3) - x / 10, y - y / 10);
            g.drawLine((x / 5 * 4) - x / 10, y / 5 - y / 10, (x / 5 * 4) - x / 10, y - y / 10);
            g.drawLine((x / 5 * 5) - x / 10, y / 5 - y / 10, (x / 5 * 5) - x / 10, y - y / 10);

            g.drawLine(x / 5 - x / 10, y / 5 - y / 10, x / 5 * 4 + x / 10, y / 5 - y / 10);
            g.drawLine(x / 5 - x / 10, y / 5 * 2 - y / 10, x / 5 * 4 + x / 10, y / 5 * 2 - y / 10);
            g.drawLine(x / 5 - x / 10, y / 5 * 3 - y / 10, x / 5 * 4 + x / 10, y / 5 * 3 - y / 10);
            g.drawLine(x / 5 - x / 10, y / 5 * 4 - y / 10, x / 5 * 4 + x / 10, y / 5 * 4 - y / 10);
            g.drawLine(x / 5 - x / 10, y / 5 * 5 - y / 10, x / 5 * 4 + x / 10, y / 5 * 5 - y / 10);
            start(mas);
            Coloring(mas);
            bestScore.setText("Your best score is: " + CheckBestNumber(mas));
        }


        if (keyLetter == 'w') {
            MassivUpChanger(mas);
            ShadowNumberGenerator(mas);
            Coloring(mas);
            CheckIfWon(mas);
            bestScore.setText("Your best score is: " + CheckBestNumber(mas));
            if (CheckIfLost(mas)) {

                Frame frame = new Frame();
                JOptionPane.showMessageDialog(frame, "GAME OVER!");
                System.exit(0);
            }
        }
        if (keyLetter == 'a') {
            MassivLeftChanger(mas);
            ShadowNumberGenerator(mas);
            Coloring(mas);
            CheckIfWon(mas);
            bestScore.setText("Your best score is: " + CheckBestNumber(mas));
            if (CheckIfLost(mas)) {

                Frame frame = new Frame();
                JOptionPane.showMessageDialog(frame, "GAME OVER!");
                System.exit(0);
            }
        }
        if (keyLetter == 's') {
            MassivDownChanger(mas);
            ShadowNumberGenerator(mas);
            Coloring(mas);
            CheckIfWon(mas);
            bestScore.setText("Your best score is: " + CheckBestNumber(mas));
            if (CheckIfLost(mas)) {

                Frame frame = new Frame();
                JOptionPane.showMessageDialog(frame, "GAME OVER!");
                System.exit(0);
            }
        }
        if (keyLetter == 'd') {
            MassivRightChanger(mas);
            ShadowNumberGenerator(mas);
            Coloring(mas);
            CheckIfWon(mas);
            bestScore.setText("Your best score is: " + CheckBestNumber(mas));
            if (CheckIfLost(mas)) {

                Frame frame = new Frame();
                JOptionPane.showMessageDialog(frame, "GAME OVER!");
                System.exit(0);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public RandomGame() {


        setTitle("2048");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
        random_Panel = new JPanel();
        random_Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        random_Panel.setBackground(Color.WHITE);
        setContentPane(random_Panel);
        random_Panel.setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        addKeyListener(this);
        int x = random_Panel.getWidth();
        int y = random_Panel.getHeight();


        random_Panel.add(bestScore);


        NumberLabel_1.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_1.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_1);


        NumberLabel_2.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_2.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_2);


        NumberLabel_3.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_3.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_3);


        NumberLabel_4.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_4.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_4);


        NumberLabel_5.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_5.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_5);


        NumberLabel_6.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_6.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_6);


        NumberLabel_7.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_7.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_7);


        NumberLabel_8.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_8.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_8);


        NumberLabel_9.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_9.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_9);


        NumberLabel_10.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_10.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_10);


        NumberLabel_11.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_11.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_11);


        NumberLabel_12.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_12.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_12);


        NumberLabel_13.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_13.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_13);


        NumberLabel_14.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_14.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_14);


        NumberLabel_15.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_15.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_15);


        NumberLabel_16.setVerticalAlignment((int) JLabel.CENTER_ALIGNMENT);
        NumberLabel_16.setFont(new Font("Verdana", Font.PLAIN, y / 35));
        random_Panel.add(NumberLabel_16);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        JOptionPane.showMessageDialog(frame,
                "Space->to START/w->UP/a->LEFT/s->DOWN/d->RIGHT",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        );
        RandomGame randomGame = new RandomGame();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    private void start(JLabel[][] mas) {

        if (start_button_br >= 1) {
            Frame frame = new Frame("New Game");
            if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to start a new game", "Start new", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                Random rand = new Random();
                int[] masWithSpecialNumbers = new int[]{2, 0, 0, 2, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0};
                int index;
                int[] masWithValidNumbers = new int[]{2, 2, 2, 4};
                int newIndex;
                int br = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        index = rand.nextInt(16);
                        mas[i][j].setText(String.valueOf(masWithSpecialNumbers[index]));
                        if (masWithSpecialNumbers[index] == 2 || masWithSpecialNumbers[index] == 4) {
                            br++;
                            if (br > 2) {
                                mas[i][j].setText("0");
                            }
                        }
                        if (br == 0 && i == 3 && j == 2) {
                            newIndex = rand.nextInt(4);
                            mas[i][j].setText(String.valueOf(masWithValidNumbers[newIndex]));
                            br++;
                        }
                        if (br == 1 && i == 3 && j == 3) {
                            newIndex = rand.nextInt(4);
                            mas[i][j].setText(String.valueOf(masWithValidNumbers[newIndex]));
                        }
                    }
                }
            }
        } else if (start_button_br == 0) {
            Random rand = new Random();
            int[] masWithSpecialNumbers = new int[]{2, 0, 0, 2, 0, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0};
            int[] masWithValidNumbers = new int[]{2, 2, 2, 4};
            int newIndex;
            int index;
            int br = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    index = rand.nextInt(16);
                    mas[i][j].setText(String.valueOf(masWithSpecialNumbers[index]));
                    if (masWithSpecialNumbers[index] == 2 || masWithSpecialNumbers[index] == 4) {
                        br++;
                        if (br > 2) {
                            mas[i][j].setText("0");
                        }
                    }
                    if (br == 0 && i == 3 && j == 2) {
                        newIndex = rand.nextInt(4);
                        mas[i][j].setText(String.valueOf(masWithValidNumbers[newIndex]));
                        br++;
                    }
                    if (br == 1 && i == 3 && j == 3) {
                        newIndex = rand.nextInt(4);
                        mas[i][j].setText(String.valueOf(masWithValidNumbers[newIndex]));
                    }
                }
            }
        }
        start_button_br++;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    private static void MassivLeftChanger(JLabel[][] mas) {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    int currentNumber = Integer.parseInt(mas[i][j].getText());
                    int nextNumber = Integer.parseInt(mas[i][j - 1].getText());

                    if (nextNumber == 0 && currentNumber != 0) {
                        nextNumber = currentNumber;
                        currentNumber = 0;
                        mas[i][j].setText(String.valueOf(currentNumber));
                        mas[i][j - 1].setText(String.valueOf(nextNumber));
                    } else if (currentNumber == nextNumber) {
                        nextNumber = currentNumber * 2;
                        currentNumber = 0;
                        mas[i][j].setText(String.valueOf(currentNumber));
                        mas[i][j - 1].setText(String.valueOf(nextNumber));
                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    private static void MassivRightChanger(JLabel[][] mas) {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int currentNumber = Integer.parseInt(mas[i][j].getText());
                    int nextNumber = Integer.parseInt(mas[i][j + 1].getText());
                    if (currentNumber != 0 && nextNumber == 0) {
                        nextNumber = currentNumber;
                        currentNumber = 0;
                        mas[i][j].setText(String.valueOf(currentNumber));
                        mas[i][j + 1].setText(String.valueOf(nextNumber));
                    } else if (currentNumber == nextNumber) {
                        nextNumber = currentNumber * 2;
                        currentNumber = 0;
                        mas[i][j].setText(String.valueOf(currentNumber));
                        mas[i][j + 1].setText(String.valueOf(nextNumber));
                    }
                }
            }
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void MassivUpChanger(JLabel[][] mas) {

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    int currentNumber = Integer.parseInt(mas[i][j].getText());
                    int nextNumber = Integer.parseInt(mas[i + 1][j].getText());
                    if (currentNumber == 0 && nextNumber != 0) {
                        currentNumber = nextNumber;
                        mas[i][j].setText(String.valueOf(currentNumber));
                        nextNumber = 0;
                        mas[i + 1][j].setText(String.valueOf(nextNumber));
                    } else if (currentNumber == nextNumber) {
                        currentNumber = nextNumber * 2;
                        mas[i][j].setText(String.valueOf(currentNumber));
                        nextNumber = 0;
                        mas[i + 1][j].setText(String.valueOf(nextNumber));
                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void MassivDownChanger(JLabel[][] mas) {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j <= 3; j++) {
                    int currentNumber = Integer.parseInt(mas[i][j].getText());
                    int nextNumber = Integer.parseInt(mas[i + 1][j].getText());
                    if (nextNumber == 0 && currentNumber != 0) {
                        nextNumber = currentNumber;
                        mas[i + 1][j].setText(String.valueOf(nextNumber));
                        currentNumber = 0;
                        mas[i][j].setText(String.valueOf(currentNumber));
                    } else if (currentNumber == nextNumber) {
                        nextNumber = currentNumber * 2;
                        currentNumber = 0;
                        mas[i + 1][j].setText(String.valueOf(nextNumber));
                        mas[i][j].setText(String.valueOf(currentNumber));
                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void ShadowNumberGenerator(JLabel[][] mas) {
        Random rand = new Random();
        int[] NumbersGeneratingDuringGame = new int[]{2, 2, 2, 4};
        int index;
        index = rand.nextInt(4);
        int i = rand.nextInt(4);
        int j = rand.nextInt(4);
        int currentNum;
        if (Integer.parseInt(mas[i][j].getText()) == 0) {
            currentNum = NumbersGeneratingDuringGame[index];
            mas[i][j].setText(String.valueOf(currentNum));
        } else {
            while (Integer.parseInt(mas[i][j].getText()) > 0) {
                i = rand.nextInt(4);
                j = rand.nextInt(4);
            }
            currentNum = NumbersGeneratingDuringGame[index];
            mas[i][j].setText(String.valueOf(currentNum));
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void CheckIfWon(JLabel[][] mas) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Integer.parseInt(mas[i][j].getText()) == 2048) {
                    Frame frame = new Frame();
                    JOptionPane.showMessageDialog(frame, "Congratulations you won!!!");
                    System.exit(0);
                }

            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static boolean CheckIfLost(JLabel[][] mas) {
        JLabel[][] masCheck = new JLabel[4][4];
        int nullbr = 0;
        int firstCheckBr = 0;
        int secondCheckBr = 0;
        boolean firstCheck = false;
        boolean secondCheck = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                masCheck[i][j] = mas[i][j];
                if (Integer.parseInt(mas[i][j].getText()) == 0) {
                    nullbr++;
                }
            }
        }
        if (nullbr == 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    if (Integer.parseInt(masCheck[i][j].getText()) == Integer.parseInt(masCheck[i][j - 1].getText())) {
                        firstCheckBr++;
                    }
                }
            }
            if (firstCheckBr == 0) {
                firstCheck = true;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 4; j++) {
                    if (Integer.parseInt(masCheck[i][j].getText()) == Integer.parseInt(masCheck[i + 1][j].getText())) {
                        secondCheckBr++;
                    }
                }
            }
            if (secondCheckBr == 0) {
                secondCheck = true;
            }
            if (firstCheck) {
                if (secondCheck) {
                    return true;
                }
            }
        }

        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static int CheckBestNumber(JLabel[][] mas) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mas[i][j] == null) {
                    max = 0;
                } else if (Integer.parseInt(mas[i][j].getText()) > max) {
                    max = (Integer.parseInt(mas[i][j].getText()));
                }
            }
        }
        return max;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static JLabel[][] Coloring(JLabel[][] mas) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = Integer.parseInt(mas[i][j].getText());
                if (number == 0) {
                    mas[i][j].setBackground(Color.WHITE);
                }
                if (number == 2) {
                    mas[i][j].setBackground(Color.lightGray);
                }
                if (number == 4) {
                    mas[i][j].setBackground(new Color(255, 204, 153));
                }
                if (number == 8) {
                    mas[i][j].setBackground(new Color(255, 178, 102));
                }
                if (number == 16) {
                    mas[i][j].setBackground(new Color(255, 128, 0));
                }
                if (number == 32) {
                    mas[i][j].setBackground(new Color(255, 99, 0));
                }
                if (number == 64) {
                    mas[i][j].setBackground(new Color(255, 70, 0));
                }
                if (number == 128) {
                    mas[i][j].setBackground(Color.red);
                }
                if (number == 256) {
                    mas[i][j].setBackground(new Color(255, 255, 0));
                }
                if (number == 512) {
                    mas[i][j].setBackground(Color.YELLOW);
                }
                if (number == 1024) {
                    mas[i][j].setBackground(new Color(245, 230, 0));
                }
                if (number == 2048) {
                    mas[i][j].setBackground(new Color(245, 190, 0));
                }


            }
        }
        return mas;
    }

}
