package SudokuCode.Frontend;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static SudokuCode.Frontend.SudokuMain.icWhite;

public class SudokuButton extends JButton {
    private static HashMap<Integer, Point> map = new HashMap<>();
    private boolean drawnOn;

    static {
        map.put(1, new Point(5, 9));
        map.put(2, new Point(21, 9));
        map.put(3, new Point(34, 9));
        map.put(4, new Point(5, 22));
        map.put(5, new Point(21, 21));
        map.put(6, new Point(34, 21));
        map.put(7, new Point(5, 34));
        map.put(8, new Point(21, 34));
        map.put(9, new Point(34, 34));
    }

    List<Integer> possible;
    List<Integer> drawn;

    SudokuButton(int i, int j) {
        drawn = new ArrayList<>();
        this.setIcon(new ImageIcon(icWhite.getImage().getScaledInstance(41, 41, Image.SCALE_DEFAULT)));
        this.setForeground(Color.black);
        this.setFont(new Font("Arial Black", Font.PLAIN, 20));
        this.setBorder(new LineBorder(Color.BLACK));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.CENTER);
        this.setBounds(31 + j * 42, 31 + i * 42, 41, 41);
        this.setMargin(new Insets(2, 2, 2, 2));
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font forPencil = new Font("Calibre", Font.PLAIN, 10);
        g.setFont(forPencil);


        for (Integer i : drawn) {

            int x = (int) map.get(i).getX();
            int y = (int) map.get(i).getY();
            if (i == SudokuMain.parameters.getSelection()) {
                g.setColor(Color.RED);
            } else g.setColor(Color.black);
            g.drawString(i + "", x, y);

        }


    }

    public boolean isDrawnOn() {
        return drawnOn;
    }

    public void drawnOn() {
        this.drawnOn = true;
    }
    public void removeDrawnOn(){
        this.drawnOn = false;
    }
}
