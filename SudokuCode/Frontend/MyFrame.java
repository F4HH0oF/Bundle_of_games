package SudokuCode.Frontend;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(int width, int height, String title){
        this.setTitle(title);
        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
}
