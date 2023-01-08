package SudokuCode.Frontend;

import javax.swing.*;
import java.awt.*;

public class SudokuPanel extends JPanel {
    public SudokuPanel(JFrame f) {
        this.setSize(f.getSize());
        this.setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i < 4; i++) {
            g2.drawLine(30, 30 + i * 42 * 3, 408, 30 + i * 42 * 3);
            g2.drawLine(30 + i * 42 * 3, 30, 30 + i * 42 * 3, 408);
        }
    }

}
