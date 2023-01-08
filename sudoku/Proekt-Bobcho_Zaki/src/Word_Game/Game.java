package Word_Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

class ScoreBoardWindow extends JFrame {
    private JPanel contentPane;
    HashMap<String, Integer> Scoreboard = new HashMap<>();

    public ScoreBoardWindow() throws IOException {
        scoreBoard();
        setTitle("ScoreBoard-not including current game ");
        setSize(450, 250);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JButton button_Back = new JButton();
        // JButton button_Reset = new JButton();
        button_Back.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        button_Back.setBounds(20, 200, 80, 20);
        button_Back.setText("Back");
        setLocationRelativeTo(null);
        JLabel lbl_1 = new JLabel("1.");
        lbl_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_1.setBounds(20, 20, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_2 = new JLabel("2.");
        lbl_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_2.setBounds(20, 40, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_3 = new JLabel("3.");
        lbl_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_3.setBounds(20, 60, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_4 = new JLabel("4.");
        lbl_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_4.setBounds(20, 80, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_5 = new JLabel("5.");
        lbl_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_5.setBounds(20, 100, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_6 = new JLabel("6.");
        lbl_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_6.setBounds(20, 120, 80, 20);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        JLabel lbl_firstPlace = new JLabel("");
        lbl_firstPlace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_firstPlace.setBounds(40, 20, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_secondPlace = new JLabel("");
        lbl_secondPlace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_secondPlace.setBounds(40, 40, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_thirdPlace = new JLabel("");
        lbl_thirdPlace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_thirdPlace.setBounds(40, 60, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_forthPlace = new JLabel("");
        lbl_forthPlace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_forthPlace.setBounds(40, 80, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_fifthPlace = new JLabel("");
        lbl_fifthPlace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_fifthPlace.setBounds(40, 100, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_sixthPlace = new JLabel("");
        lbl_sixthPlace.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_sixthPlace.setBounds(40, 120, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_firstPlacePoints = new JLabel("");
        lbl_firstPlacePoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_firstPlacePoints.setBounds(100, 20, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_secondPlacePoints = new JLabel("");
        lbl_secondPlacePoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_secondPlacePoints.setBounds(100, 40, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_thirdPlacePoints = new JLabel("");
        lbl_thirdPlacePoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_thirdPlacePoints.setBounds(100, 60, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_forthPlacePoints = new JLabel("");
        lbl_forthPlacePoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_forthPlacePoints.setBounds(100, 80, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_fifthPlacePoints = new JLabel("");
        lbl_fifthPlacePoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_fifthPlacePoints.setBounds(100, 100, 80, 20);
        ////////////////////////////////////////////////////////////////////////
        JLabel lbl_sixthPlacePoints = new JLabel("");
        lbl_sixthPlacePoints.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lbl_sixthPlacePoints.setBounds(100, 120, 80, 20);
        //////////////////////////////////////////////////////////////////////////
        contentPane.add(lbl_1);
        contentPane.add(lbl_2);
        contentPane.add(lbl_3);
        contentPane.add(lbl_4);
        contentPane.add(lbl_5);
        contentPane.add(lbl_6);
        contentPane.add(lbl_firstPlace);
        contentPane.add(lbl_secondPlace);
        contentPane.add(lbl_thirdPlace);
        contentPane.add(lbl_forthPlace);
        contentPane.add(lbl_fifthPlace);
        contentPane.add(lbl_sixthPlace);
        contentPane.add(lbl_firstPlacePoints);
        contentPane.add(lbl_secondPlacePoints);
        contentPane.add(lbl_thirdPlacePoints);
        contentPane.add(lbl_forthPlacePoints);
        contentPane.add(lbl_fifthPlacePoints);
        contentPane.add(lbl_sixthPlacePoints);
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(Scoreboard.entrySet());
        Collections.sort(list1, new Comparator<>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });

        if (list1.isEmpty()) {
        } else {
            lbl_firstPlace.setText(list1.get(0).getKey());
            lbl_firstPlacePoints.setText(String.valueOf(list1.get(0).getValue()));

            if (list1.size() >= 2) {
                lbl_secondPlace.setText(list1.get(1).getKey());
                lbl_secondPlacePoints.setText(String.valueOf(list1.get(1).getValue()));
            }
            if (list1.size() >= 3) {
                lbl_thirdPlace.setText(list1.get(2).getKey());
                lbl_thirdPlacePoints.setText(String.valueOf(list1.get(2).getValue()));
            }
            if (list1.size() >= 4) {
                lbl_forthPlace.setText(list1.get(3).getKey());
                lbl_forthPlacePoints.setText(String.valueOf(list1.get(3).getValue()));
            }
            if (list1.size() >= 5) {
                lbl_fifthPlace.setText(list1.get(4).getKey());
                lbl_fifthPlacePoints.setText(String.valueOf(list1.get(4).getValue()));
            }
            if (list1.size() >= 6) {
                lbl_sixthPlace.setText(list1.get(5).getKey());
                lbl_sixthPlacePoints.setText(String.valueOf(list1.get(5).getValue()));
            }
        }

        button_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toBack();
                JFrame frame = new JFrame();
                frame.setVisible(true);
                frame.toBack();

            }
        });
    }

    public Map<String, Integer> scoreBoard() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        List<String> uniqueUsers = new ArrayList<>();
        for (String usernameData = reader.readLine(); usernameData != null; usernameData = reader.readLine()) {
            String[] data = usernameData.split(":");
            String name = data[0];
            String score = data[1];
            int currentBestScore = 0;
            if (!uniqueUsers.contains(name)) {
                uniqueUsers.add(name);
                if (Integer.parseInt(score) > currentBestScore) {
                    currentBestScore = Integer.parseInt(score);
                }
                Scoreboard.put(name, currentBestScore);
            } else if (uniqueUsers.contains(name)) {
                Scoreboard.put(name, bestScoreChecker(name));
            }
        }
        reader.close();
        return Scoreboard;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public int bestScoreChecker(String user) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        int bestUserScore;
        int currentBestScore = 0;
        for (String usernameData = reader.readLine(); usernameData != null; usernameData = reader.readLine()) {
            String[] data = usernameData.split(":");
            String name = data[0];
            bestUserScore = Integer.parseInt(data[1]);

            if (user.equals(name) && bestUserScore > currentBestScore) {
                currentBestScore = bestUserScore;
            }
        }
        reader.close();
        return currentBestScore;
    }

}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class BulgarianWindow extends JFrame {
    int[] probabilityMas = {1, 0, 1, 1, 0, 1, 1};
    List<String> usedWords = new ArrayList<>();
    List<Character> chosenLetters = new ArrayList<>();
    List<Character> allVocalLetters = new ArrayList<>();
    List<String> usernameList;
    String username;
    int sum = 0;
    int index;
    int bestScore = 0;

    public BulgarianWindow() throws IOException {
        setTitle("Игра на думи");
        int x = 1920;
        int y = 1080;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel BulgarianPanel = new JPanel();
        setContentPane(BulgarianPanel);
        setLayout(null);
        setLocationRelativeTo(null);


        allVocalLetters.add('а');
        allVocalLetters.add('и');
        allVocalLetters.add('ъ');
        allVocalLetters.add('у');
        allVocalLetters.add('е');

        JTextField tfWord = new JTextField();
        tfWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tfWord.setBounds(20, 120, 400, 30);
        BulgarianPanel.add(tfWord);
        JLabel naiDoburResultatNaCoweka = new JLabel("0");
        naiDoburResultatNaCoweka.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        naiDoburResultatNaCoweka.setBounds(540, 80, 120, 20);
        BulgarianPanel.add(naiDoburResultatNaCoweka);
        JLabel lblPointsForTheWord = new JLabel("Points for word");
        lblPointsForTheWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblPointsForTheWord.setBounds(20, 40, 120, 20);
        BulgarianPanel.add(lblPointsForTheWord);
        JLabel obshtResultat = new JLabel("0");
        obshtResultat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        obshtResultat.setBounds(530, 40, 120, 20);
        BulgarianPanel.add(obshtResultat);
        JLabel resultat = new JLabel("Result");
        resultat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        resultat.setBounds(460, 40, 120, 20);
        BulgarianPanel.add(resultat);
        JLabel lblWord = new JLabel("Word");
        lblWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblWord.setBounds(20, 80, 120, 20);
        BulgarianPanel.add(lblWord);
        JLabel naiDoburResultat = new JLabel("BestScore");
        naiDoburResultat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        naiDoburResultat.setBounds(460, 80, 120, 20);
        BulgarianPanel.add(naiDoburResultat);

        JButton tablo = new JButton();
        BulgarianPanel.add(tablo);
        tablo.setBounds(450, 120, 250, 30);
        tablo.setText("Резултати");

        JButton whod = new JButton();
        BulgarianPanel.add(whod);
        whod.setBounds(450, 160, 250, 30);
        whod.setText("Въведи");

        JButton nazad = new JButton();
        BulgarianPanel.add(nazad);
        nazad.setBounds(450, 200, 250, 30);
        nazad.setText("Назад");

        JButton izcisti = new JButton();
        BulgarianPanel.add(izcisti);
        izcisti.setBounds(450, 240, 250, 30);
        izcisti.setText("Изчисти");

        JButton izhod = new JButton();
        BulgarianPanel.add(izhod);
        izhod.setBounds(450, 280, 250, 30);
        izhod.setText("Стоп");


        usernameList = EnglishWindow.usernameAdder();
        username = JOptionPane.showInputDialog(null, "Въведи име");

        if (username.equals("") || username.isEmpty()) {
            while (username.equals(""))
                username = JOptionPane.showInputDialog(null, "Въведи име");
        }
        if (usernameList.contains(username)) {
            JOptionPane.showMessageDialog(null, "Здравей отново " + username);
            bestScore = EnglishWindow.bestScoreChecker(username);
            JOptionPane.showMessageDialog(null, "Твоят най-добър резултат досега е: " + bestScore);
            naiDoburResultatNaCoweka.setText(String.valueOf(bestScore));
        }

        JButton button_1 = new JButton();
        BulgarianPanel.add(button_1);
        button_1.setBounds(20, 200, 120, 30);
        JButton button_2 = new JButton();
        BulgarianPanel.add(button_2);
        button_2.setBounds(20, 240, 120, 30);
        JButton button_3 = new JButton();
        BulgarianPanel.add(button_3);
        button_3.setBounds(20, 280, 120, 30);
        JButton button_4 = new JButton();
        BulgarianPanel.add(button_4);
        button_4.setBounds(20, 160, 120, 30);
        JButton button_5 = new JButton();
        BulgarianPanel.add(button_5);
        button_5.setBounds(160, 200, 120, 30);
        JButton button_6 = new JButton();
        BulgarianPanel.add(button_6);
        button_6.setBounds(160, 240, 120, 30);
        JButton button_7 = new JButton();
        BulgarianPanel.add(button_7);
        button_7.setBounds(160, 280, 120, 30);
        JButton button_8 = new JButton();
        BulgarianPanel.add(button_8);
        button_8.setBounds(160, 160, 120, 30);
        JButton button_9 = new JButton();
        BulgarianPanel.add(button_9);
        button_9.setBounds(300, 200, 120, 30);
        JButton button_10 = new JButton();
        BulgarianPanel.add(button_10);
        button_10.setBounds(300, 240, 120, 30);
        JButton button_11 = new JButton();
        BulgarianPanel.add(button_11);
        button_11.setBounds(300, 280, 120, 30);
        JButton button_12 = new JButton();
        BulgarianPanel.add(button_12);
        button_12.setBounds(300, 160, 120, 30);

        char symbol1 = (char) BulgarianLetterGiver();
        button_1.setText(String.valueOf(symbol1));
        char symbol2 = (char) BulgarianLetterGiver();
        button_2.setText(String.valueOf(symbol2));
        char symbol3 = (char) BulgarianLetterGiver();
        button_3.setText(String.valueOf(symbol3));
        char symbol4 = (char) BulgarianLetterGiver();
        button_4.setText(String.valueOf(symbol4));
        char symbol5 = (char) BulgarianLetterGiver();
        button_5.setText(String.valueOf(symbol5));
        char symbol6 = (char) BulgarianLetterGiver();
        button_6.setText(String.valueOf(symbol6));
        char symbol7 = (char) BulgarianLetterGiver();
        button_7.setText(String.valueOf(symbol7));
        char symbol8 = (char) BulgarianLetterGiver();
        button_8.setText(String.valueOf(symbol8));
        char symbol9 = (char) BulgarianLetterGiver();
        button_9.setText(String.valueOf(symbol9));
        char symbol10 = (char) BulgarianLetterGiver();
        button_10.setText(String.valueOf(symbol10));
        char symbol11 = (char) BulgarianLetterGiver();
        button_11.setText(String.valueOf(symbol11));
        char symbol12 = (char) BulgarianLetterGiver();
        button_12.setText(String.valueOf(symbol12));

        ///////////////////////////////////////////////////////////////////////////////////////
        whod.addActionListener(e -> {
            String word = tfWord.getText();
            try {
                int points;
                if (wordChecker(word)) {
                    if (!usedWords.contains(word)) {
                        points = word.length();
                        sum = sum + points;
                        lblPointsForTheWord.setText(String.valueOf(points));//
                        obshtResultat.setText(String.valueOf(sum));
                        usedWords.add(word);
                    } else if (usedWords.contains(word)) {
                        JFrame frame = new JFrame("Опитай отново");
                        JOptionPane.showMessageDialog(frame, "Тази дума вече е използвана");
                    }
                } else {
                    JFrame frame = new JFrame("Няма такава дума");
                    JOptionPane.showMessageDialog(frame, "Думата която написахте не съществува");
                }
                tfWord.setText("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        izcisti.addActionListener(e -> {
            JFrame frame = new JFrame("Изчисти");
            if (JOptionPane.showConfirmDialog(frame, "Сигурен ли сте че искате да изчистите", " Изчисти", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                tfWord.setText("");
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        izhod.addActionListener(e -> {
            JFrame frame = new JFrame("Изход");
            if (JOptionPane.showConfirmDialog(frame, "Сигурен ли сте че искате да излезете от играта", "Изход", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                try {
                    if (obshtResultat.getText().equals("")) {
                        obshtResultat.setText("0");
                    }
                    EnglishWindow.usernameAndScoreWriter(username, Integer.parseInt(obshtResultat.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                sum = 0;
                System.exit(0);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_1.addActionListener(e -> {
            String symbolButton1 = button_1.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_2.addActionListener(e -> {
            String symbolButton1 = button_2.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_3.addActionListener(e -> {
            String symbolButton1 = button_3.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_4.addActionListener(e -> {
            String symbolButton1 = button_4.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_5.addActionListener(e -> {
            String symbolButton1 = button_5.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_6.addActionListener(e -> {
            String symbolButton1 = button_6.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_7.addActionListener(e -> {
            String symbolButton1 = button_7.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_8.addActionListener(e -> {
            String symbolButton1 = button_8.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_9.addActionListener(e -> {
            String symbolButton1 = button_9.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_10.addActionListener(e -> {
            String symbolButton1 = button_10.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_11.addActionListener(e -> {
            String symbolButton1 = button_11.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_12.addActionListener(e -> {
            String symbolButton1 = button_12.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        nazad.addActionListener(e -> {
            if (tfWord.getText().equals("")) {
                JFrame frame = new JFrame("Няма написана дума");
                JOptionPane.showMessageDialog(frame, "Няма дума за триене");
            }
            String word = tfWord.getText();
            String nWord = "";
            for (int i = 0; i < word.length() - 1; i++) {
                char symbol = word.charAt(i);
                nWord = nWord + symbol;
            }
            tfWord.setText(nWord);
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        tfWord.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if ((Character.isDefined(c))) {
                    e.consume();
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    if (obshtResultat.getText().equals("")) {
                        obshtResultat.setText("0");
                    }
                    EnglishWindow.usernameAndScoreWriter(username, Integer.parseInt(obshtResultat.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        tablo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardWindow frame = null;
                try {
                    frame = new ScoreBoardWindow();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.setVisible(true);
            }
        });
        JLabel label = new JLabel();
        BulgarianPanel.add(label);
        label.setBounds(0, 0, x, y);
        label.setVisible(true);
        ImageIcon bgFlag = new ImageIcon("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\bgFlag.jpg");
        Image img = bgFlag.getImage();
        Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledFlag = new ImageIcon(scaledImg);
        label.setIcon(scaledFlag);

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public int BulgarianLetterGiver() throws IOException {
        Random rand = new Random();
        String vocalLetters = "аъоуеи";
        String nonVocalLetters = "явртпсдфгхйклзьцжбнмшщюч";
        index = rand.nextInt(6);
        char symbol1;
        if (probabilityMas[index] == 1) {
            symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
        } else {
            symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
        }
        while (chosenLetters.contains(symbol1)) {
            if (probabilityMas[index] == 1) {
                symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
            } else if (probabilityMas[index] == 0) {
                if (chosenLetters.containsAll(allVocalLetters)) {
                    symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
                    chosenLetters.add(symbol1);
                    return symbol1;
                }
                symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
            }
        }
        chosenLetters.add(symbol1);
        return symbol1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean wordChecker(String word) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\bulgarianDictionary.txt"));
        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            if (word.equals(currentWord)) {
                return true;
            }
        }
        reader.close();
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class LanguageWindow extends JFrame {
    private JPanel languagePanel;

    public LanguageWindow() {
        setTitle("Languages");
        int x = 1920;
        int y = 1080;
        setSize(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        languagePanel = new JPanel();
        setContentPane(languagePanel);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel title = new JLabel("Welcome to WordGame");
        title.setBounds(x / 2 - x / 15 - 25, y / 10, x / 8, y / 20);
        title.setBorder(new LineBorder(Color.BLACK, 3));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.BLACK);
        languagePanel.add(title);


        JButton readyButton = new JButton();
        JRadioButton radioButtonBulgarian = new JRadioButton();
        JRadioButton radioButtonSpanish = new JRadioButton();
        JRadioButton radioButtonGerman = new JRadioButton();
        JRadioButton radioButtonEnglish = new JRadioButton();


        radioButtonBulgarian.setBounds(x / 2 - x / 15, y / 10 * 2, x / 10, y / 20);
        radioButtonSpanish.setBounds(x / 2 - x / 15, y / 10 * 3, x / 10, y / 20);
        radioButtonGerman.setBounds(x / 2 - x / 15, y / 10 * 4, x / 10, y / 20);
        radioButtonEnglish.setBounds(x / 2 - x / 15, y / 10 * 5, x / 10, y / 20);
        readyButton.setBounds(x / 2 - x / 15, y / 10 * 6, x / 10, y / 20);

        radioButtonBulgarian.setBackground(Color.WHITE);
        radioButtonEnglish.setBackground(Color.WHITE);
        radioButtonGerman.setBackground(Color.WHITE);
        radioButtonSpanish.setBackground(Color.WHITE);
        readyButton.setBackground(Color.WHITE);

        languagePanel.add(radioButtonBulgarian);
        languagePanel.add(radioButtonSpanish);
        languagePanel.add(radioButtonGerman);
        languagePanel.add(radioButtonEnglish);
        languagePanel.add(readyButton);

        readyButton.setText("ready");
        radioButtonBulgarian.setText("Bulgarian");
        radioButtonSpanish.setText("Spanish");
        radioButtonGerman.setText("German");
        radioButtonEnglish.setText("English");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonBulgarian);
        bg.add(radioButtonSpanish);
        bg.add(radioButtonGerman);
        bg.add(radioButtonEnglish);

        readyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // dispose();
                boolean b = true;
                if (radioButtonBulgarian.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play in Bulgarian", "Bulgarian", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        try {
                            BulgarianWindow frame = new BulgarianWindow();
                            frame.setVisible(true);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else {
//                        dispose();
//                        LanguageWindow frame = new LanguageWindow();
//                        frame.setVisible(true);
                    }
                    b = false;
                }
                if (radioButtonSpanish.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play in spanishDictionary", "spanishDictionary", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        try {
                            SpanishWindow spanishWindow = new SpanishWindow();
                            spanishWindow.setVisible(true);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else {
//                        dispose();
//                        LanguageWindow frame = new LanguageWindow();
//                        frame.setVisible(true);
                    }
                    b = false;
                }
                if (radioButtonGerman.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play in germanDictionary", "germanDictionary", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        try {
                            GermanWindow germanwindow = new GermanWindow();
                            germanwindow.setVisible(true);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else {
//                        dispose();
//                        LanguageWindow frame = new LanguageWindow();
//                        frame.setVisible(true);
                    }
                    b = false;
                }
                if (radioButtonEnglish.isSelected()) {
                    Frame frame1 = new Frame();
                    if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to play in English", "English", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                        dispose();
                        try {
                            EnglishWindow englishWindow = new EnglishWindow();
                            englishWindow.setVisible(true);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    } else {
//                        dispose();
//                        LanguageWindow frame = new LanguageWindow();
//                        frame.setVisible(true);
                    }
                    b = false;
                }

                if (b) {
                    Frame frame1 = new Frame();
                    JOptionPane.showMessageDialog(frame1, "Please select something");
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Frame frame1 = new Frame();
                if (JOptionPane.showConfirmDialog(frame1, "Are you sure you want to leave", "Leaving", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                } else {
                    dispose();
                    LanguageWindow frame = new LanguageWindow();
                    frame.setVisible(true);
                }
            }
        });
        JLabel label = new JLabel();
        languagePanel.setLayout(null);
        languagePanel.add(label);
        label.setBounds(0, 0, x, y);
        label.setVisible(true);
        ImageIcon books = new ImageIcon("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\book.jpg");
        Image img = books.getImage();
        Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBook = new ImageIcon(scaledImg);
        label.setIcon(scaledBook);
        Frame frame = new Frame();
        frame.setLocationRelativeTo(null);
        JOptionPane.showMessageDialog(frame, "Select language in which you want to play");

    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class EnglishWindow extends JFrame {
    int[] probabilityMas = {1, 0, 1, 1, 0, 1, 1};
    JLabel lblBestScoreChanger = new JLabel("0");
    List<String> usedWords = new ArrayList<>();
    List<Character> chosenLetters = new ArrayList<>();
    List<Character> allVocalLetters = new ArrayList<>();
    List<String> usernameList;

    String username;
    int sum = 0;
    int index;
    int bestScore = 0;
    private JPanel englishPanel;

    public EnglishWindow() throws IOException {
        usernameList = usernameAdder();
        username = JOptionPane.showInputDialog(null, "Enter username");

        if (username.equals("") || username.isEmpty()) {
            while (username.equals(""))
                username = JOptionPane.showInputDialog(null, "Enter username");
        }
        if (usernameList.contains(username)) {
            JOptionPane.showMessageDialog(null, "welcome back " + username);
            bestScore = bestScoreChecker(username);
            JOptionPane.showMessageDialog(null, "your best score for now is " + bestScore);
            lblBestScoreChanger.setText(String.valueOf(bestScore));
        }


        setTitle("WordGame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int x = 1920;
        int y = 1080;
        setSize(x, y);
        englishPanel = new JPanel();
        englishPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(englishPanel);
        englishPanel.setLayout(null);
        setLocationRelativeTo(null);

        JTextField tfWord = new JTextField();
        tfWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tfWord.setForeground(Color.WHITE);
        tfWord.setBounds(20, 120, 400, 30);
        englishPanel.add(tfWord);
        lblBestScoreChanger.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblBestScoreChanger.setForeground(Color.WHITE);
        lblBestScoreChanger.setBounds(540, 80, 120, 20);
        englishPanel.add(lblBestScoreChanger);
        JLabel lblPointsForTheWord = new JLabel("Points for word");
        lblPointsForTheWord.setForeground(Color.WHITE);
        lblPointsForTheWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblPointsForTheWord.setBounds(20, 40, 120, 20);
        englishPanel.add(lblPointsForTheWord);
        JLabel lblResultAll = new JLabel("0");
        lblResultAll.setForeground(Color.WHITE);
        lblResultAll.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResultAll.setBounds(530, 40, 120, 20);
        englishPanel.add(lblResultAll);
        JLabel lblResult = new JLabel("Result");
        lblResult.setForeground(Color.WHITE);
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResult.setBounds(460, 40, 120, 20);
        englishPanel.add(lblResult);
        JLabel lblWord = new JLabel("Word");
        lblWord.setForeground(Color.WHITE);
        lblWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblWord.setBounds(20, 80, 120, 20);
        englishPanel.add(lblWord);
        JLabel lblbestScore = new JLabel("BestScore");
        lblbestScore.setForeground(Color.WHITE);
        lblbestScore.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblbestScore.setBounds(460, 80, 120, 20);
        englishPanel.add(lblbestScore);
        JButton clear_Button = new JButton();
        englishPanel.add(clear_Button);
        clear_Button.setBounds(450, 200, 250, 30);
        clear_Button.setText("Clear");
        JButton enter_Button = new JButton();
        englishPanel.add(enter_Button);
        enter_Button.setBounds(450, 240, 250, 30);
        enter_Button.setText("Enter");
        JButton stop_Button = new JButton();
        englishPanel.add(stop_Button);
        stop_Button.setBounds(450, 280, 250, 30);
        stop_Button.setText("Stop");
        JButton button_Backspace = new JButton();
        englishPanel.add(button_Backspace);
        button_Backspace.setBounds(450, 160, 250, 30);
        button_Backspace.setText("Backspace");
        JButton button_ScoreBoard = new JButton();
        englishPanel.add(button_ScoreBoard);
        button_ScoreBoard.setBounds(450, 120, 250, 30);
        button_ScoreBoard.setText("ScoreBoard");


        JButton button_1 = new JButton();
        englishPanel.add(button_1);
        button_1.setBounds(20, 200, 120, 30);
        JButton button_2 = new JButton();
        englishPanel.add(button_2);
        button_2.setBounds(20, 240, 120, 30);
        JButton button_3 = new JButton();
        englishPanel.add(button_3);
        button_3.setBounds(20, 280, 120, 30);
        JButton button_4 = new JButton();
        englishPanel.add(button_4);
        button_4.setBounds(20, 160, 120, 30);
        JButton button_5 = new JButton();
        englishPanel.add(button_5);
        button_5.setBounds(160, 200, 120, 30);
        JButton button_6 = new JButton();
        englishPanel.add(button_6);
        button_6.setBounds(160, 240, 120, 30);
        JButton button_7 = new JButton();
        englishPanel.add(button_7);
        button_7.setBounds(160, 280, 120, 30);
        JButton button_8 = new JButton();
        englishPanel.add(button_8);
        button_8.setBounds(160, 160, 120, 30);
        JButton button_9 = new JButton();
        englishPanel.add(button_9);
        button_9.setBounds(300, 200, 120, 30);
        JButton button_10 = new JButton();
        englishPanel.add(button_10);
        button_10.setBounds(300, 240, 120, 30);
        JButton button_11 = new JButton();
        englishPanel.add(button_11);
        button_11.setBounds(300, 280, 120, 30);
        JButton button_12 = new JButton();
        englishPanel.add(button_12);
        button_12.setBounds(300, 160, 120, 30);


        char symbol1 = (char) EnglishLetterGiver();
        button_1.setText(String.valueOf(symbol1));
        char symbol2 = (char) EnglishLetterGiver();
        button_2.setText(String.valueOf(symbol2));
        char symbol3 = (char) EnglishLetterGiver();
        button_3.setText(String.valueOf(symbol3));
        char symbol4 = (char) EnglishLetterGiver();
        button_4.setText(String.valueOf(symbol4));
        char symbol5 = (char) EnglishLetterGiver();
        button_5.setText(String.valueOf(symbol5));
        char symbol6 = (char) EnglishLetterGiver();
        button_6.setText(String.valueOf(symbol6));
        char symbol7 = (char) EnglishLetterGiver();
        button_7.setText(String.valueOf(symbol7));
        char symbol8 = (char) EnglishLetterGiver();
        button_8.setText(String.valueOf(symbol8));
        char symbol9 = (char) EnglishLetterGiver();
        button_9.setText(String.valueOf(symbol9));
        char symbol10 = (char) EnglishLetterGiver();
        button_10.setText(String.valueOf(symbol10));
        char symbol11 = (char) EnglishLetterGiver();
        button_11.setText(String.valueOf(symbol11));
        char symbol12 = (char) EnglishLetterGiver();
        button_12.setText(String.valueOf(symbol12));
        ///////////////////////////////////////////////////////////////////////////////////////
        enter_Button.addActionListener(e -> {
            String word = tfWord.getText();
            try {
                int points;
                if (wordChecker(word)) {
                    if (!usedWords.contains(word)) {
                        points = word.length();
                        sum = sum + points;
                        lblPointsForTheWord.setText(String.valueOf(points));
                        lblResultAll.setText(String.valueOf(sum));
                        usedWords.add(word);
                    } else if (usedWords.contains(word)) {
                        JFrame frame = new JFrame("Try again");
                        JOptionPane.showMessageDialog(frame, "You have written this word already");
                    }
                } else {
                    JFrame frame = new JFrame("No such word exception");
                    JOptionPane.showMessageDialog(frame, "There is no such word ");

                }
                tfWord.setText("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        clear_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Clear");
            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to clear", " Clear", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                tfWord.setText("");
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        stop_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Exit");
            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", " Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                try {
                    if (lblResultAll.getText().equals("")) {
                        lblResultAll.setText("0");
                    }
                    usernameAndScoreWriter(username, Integer.parseInt(lblResultAll.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                sum = 0;
                System.exit(0);
            }

        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_1.addActionListener(e -> {
            String symbolButton1 = button_1.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_2.addActionListener(e -> {
            String symbolButton1 = button_2.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_3.addActionListener(e -> {
            String symbolButton1 = button_3.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_4.addActionListener(e -> {
            String symbolButton1 = button_4.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_5.addActionListener(e -> {
            String symbolButton1 = button_5.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_6.addActionListener(e -> {
            String symbolButton1 = button_6.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_7.addActionListener(e -> {
            String symbolButton1 = button_7.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_8.addActionListener(e -> {
            String symbolButton1 = button_8.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_9.addActionListener(e -> {
            String symbolButton1 = button_9.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_10.addActionListener(e -> {
            String symbolButton1 = button_10.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_11.addActionListener(e -> {
            String symbolButton1 = button_11.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_12.addActionListener(e -> {
            String symbolButton1 = button_12.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_Backspace.addActionListener(e -> {
            if (tfWord.getText().equals("")) {
                JFrame frame = new JFrame("No word written");
                JOptionPane.showMessageDialog(frame, "There is no word to backspace");
            }
            String word = tfWord.getText();
            String nWord = "";
            for (int i = 0; i < word.length() - 1; i++) {
                char symbol = word.charAt(i);
                nWord = nWord + symbol;
            }
            tfWord.setText(nWord);
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        tfWord.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if ((Character.isDefined(c))) {
                    e.consume();
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    if (lblResultAll.getText().equals("")) {
                        lblResultAll.setText("0");
                    }
                    usernameAndScoreWriter(username, Integer.parseInt(lblResultAll.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });

        button_ScoreBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardWindow frame = null;
                try {
                    frame = new ScoreBoardWindow();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.setVisible(true);
            }
        });
        JLabel label = new JLabel();
        englishPanel.add(label);
        label.setBounds(0, 0, x, y);
        label.setVisible(true);
        ImageIcon engFlag = new ImageIcon("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\englishFlag.jpg");
        Image img = engFlag.getImage();
        Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledFlag = new ImageIcon(scaledImg);
        label.setIcon(scaledFlag);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int EnglishLetterGiver() {
        Random rand = new Random();
        String vocalLetters = "aeuio";
        String nonVocalLetters = "qwrtypsdfghjklzxcvbnm";
        index = rand.nextInt(6);
        char symbol1;
        if (probabilityMas[index] == 1) {
            symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
        } else {
            symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
        }
        while (chosenLetters.contains(symbol1)) {
            if (probabilityMas[index] == 1) {
                symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
            } else if (probabilityMas[index] == 0) {
                if (chosenLetters.containsAll(allVocalLetters)) {
                    symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
                    chosenLetters.add(symbol1);
                    return symbol1;
                }
                symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
            }
        }
        chosenLetters.add(symbol1);
        return symbol1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean wordChecker(String word) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\englishDictionary"));
        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            if (word.equals(currentWord)) {
                return true;
            }
        }
        reader.close();
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public static void usernameAndScoreWriter(String username, int score) throws IOException {
        String usernameNew;
        usernameNew = username;
        int scoreNew;
        scoreNew = score;
        String file = "output.txt";
        FileWriter fw = new FileWriter(file, true);
        fw.write(usernameNew + ":" + scoreNew + "\n");
        fw.close();
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public static List<String> usernameAdder() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        List<String> uniqueUsers = new ArrayList<>();
        for (String usernameData = reader.readLine(); usernameData != null; usernameData = reader.readLine()) {
            String[] data = usernameData.split(":");
            String name = data[0];
            if (!uniqueUsers.contains(name)) {
                uniqueUsers.add(name);
            }
        }
        reader.close();
        return uniqueUsers;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public static int bestScoreChecker(String user) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        int bestUserScore;
        int currentBestScore = 0;
        for (String usernameData = reader.readLine(); usernameData != null; usernameData = reader.readLine()) {
            String[] data = usernameData.split(":");
            String name = data[0];
            bestUserScore = Integer.parseInt(data[1]);
            if (user.equals(name) && bestUserScore > currentBestScore) {
                currentBestScore = bestUserScore;
            }
        }
        reader.close();
        return currentBestScore;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class SpanishWindow extends JFrame {
    int[] probabilityMas = {1, 0, 1, 1, 0, 1, 1};
    JLabel lblBestScoreChanger = new JLabel("0");
    List<String> usedWords = new ArrayList<>();
    List<Character> chosenLetters = new ArrayList<>();
    List<Character> allVocalLetters = new ArrayList<>();
    List<String> usernameList;

    String username;
    int sum = 0;
    int index;
    int bestScore = 0;
    private JPanel spanishPanel;

    public SpanishWindow() throws IOException {
        usernameList = EnglishWindow.usernameAdder();
        username = JOptionPane.showInputDialog(null, "Introduzca su nombre de usuario");

        if (username.equals("") || username.isEmpty()) {
            while (username.equals(""))
                username = JOptionPane.showInputDialog(null, "Introduzca su nombre de usuario");
        }
        if (usernameList.contains(username)) {
            JOptionPane.showMessageDialog(null, "Bienvenido de nuevo " + username);
            bestScore = EnglishWindow.bestScoreChecker(username);
            JOptionPane.showMessageDialog(null, "Tu mejor puntaje por ahora es " + bestScore);
            lblBestScoreChanger.setText(String.valueOf(bestScore));
        }


        setTitle("Juego de palabras");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int x = 1920;
        int y = 1080;
        setSize(x,y);
        spanishPanel = new JPanel();
        spanishPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(spanishPanel);
        spanishPanel.setLayout(null);
        setLocationRelativeTo(null);

        allVocalLetters.add('а');
        allVocalLetters.add('u');
        allVocalLetters.add('e');
        allVocalLetters.add('i');
        allVocalLetters.add('o');

        JTextField tfWord = new JTextField();
        tfWord.setForeground(Color.WHITE);
        tfWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tfWord.setBounds(20, 120, 400, 30);
        spanishPanel.add(tfWord);
        lblBestScoreChanger.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblBestScoreChanger.setForeground(Color.WHITE);
        lblBestScoreChanger.setBounds(540, 80, 120, 20);
        spanishPanel.add(lblBestScoreChanger);
        JLabel lblPointsForTheWord = new JLabel("Points for word");
        lblPointsForTheWord.setForeground(Color.WHITE);
        lblPointsForTheWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblPointsForTheWord.setBounds(20, 40, 120, 20);
        spanishPanel.add(lblPointsForTheWord);
        JLabel lblResultAll = new JLabel("0");
        lblResultAll.setForeground(Color.WHITE);
        lblResultAll.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResultAll.setBounds(530, 40, 120, 20);
        spanishPanel.add(lblResultAll);
        JLabel lblResult = new JLabel("Result");
        lblResult.setForeground(Color.WHITE);
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResult.setBounds(460, 40, 120, 20);
        spanishPanel.add(lblResult);
        JLabel lblWord = new JLabel("Word");
        lblWord.setForeground(Color.WHITE);
        lblWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblWord.setBounds(20, 80, 120, 20);
        spanishPanel.add(lblWord);
        JLabel lblbestScore = new JLabel("BestScore");
        lblbestScore.setForeground(Color.WHITE);
        lblbestScore.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblbestScore.setBounds(460, 80, 120, 20);
        spanishPanel.add(lblbestScore);
        JButton clear_Button = new JButton();
        spanishPanel.add(clear_Button);
        clear_Button.setBounds(450, 200, 250, 30);
        clear_Button.setText("Clear");
        JButton enter_Button = new JButton();
        spanishPanel.add(enter_Button);
        enter_Button.setBounds(450, 240, 250, 30);
        enter_Button.setText("Enter");
        JButton stop_Button = new JButton();
        spanishPanel.add(stop_Button);
        stop_Button.setBounds(450, 280, 250, 30);
        stop_Button.setText("Stop");
        JButton button_Backspace = new JButton();
        spanishPanel.add(button_Backspace);
        button_Backspace.setBounds(450, 160, 250, 30);
        button_Backspace.setText("Backspace");
        JButton button_ScoreBoard = new JButton();
        spanishPanel.add(button_ScoreBoard);
        button_ScoreBoard.setBounds(450, 120, 250, 30);
        button_ScoreBoard.setText("ScoreBoard");


        JButton button_1 = new JButton();
        spanishPanel.add(button_1);
        button_1.setBounds(20, 200, 120, 30);
        JButton button_2 = new JButton();
        spanishPanel.add(button_2);
        button_2.setBounds(20, 240, 120, 30);
        JButton button_3 = new JButton();
        spanishPanel.add(button_3);
        button_3.setBounds(20, 280, 120, 30);
        JButton button_4 = new JButton();
        spanishPanel.add(button_4);
        button_4.setBounds(20, 160, 120, 30);
        JButton button_5 = new JButton();
        spanishPanel.add(button_5);
        button_5.setBounds(160, 200, 120, 30);
        JButton button_6 = new JButton();
        spanishPanel.add(button_6);
        button_6.setBounds(160, 240, 120, 30);
        JButton button_7 = new JButton();
        spanishPanel.add(button_7);
        button_7.setBounds(160, 280, 120, 30);
        JButton button_8 = new JButton();
        spanishPanel.add(button_8);
        button_8.setBounds(160, 160, 120, 30);
        JButton button_9 = new JButton();
        spanishPanel.add(button_9);
        button_9.setBounds(300, 200, 120, 30);
        JButton button_10 = new JButton();
        spanishPanel.add(button_10);
        button_10.setBounds(300, 240, 120, 30);
        JButton button_11 = new JButton();
        spanishPanel.add(button_11);
        button_11.setBounds(300, 280, 120, 30);
        JButton button_12 = new JButton();
        spanishPanel.add(button_12);
        button_12.setBounds(300, 160, 120, 30);


        char symbol1 = (char) SpanishLetterGiver();
        button_1.setText(String.valueOf(symbol1));
        char symbol2 = (char) SpanishLetterGiver();
        button_2.setText(String.valueOf(symbol2));
        char symbol3 = (char) SpanishLetterGiver();
        button_3.setText(String.valueOf(symbol3));
        char symbol4 = (char) SpanishLetterGiver();
        button_4.setText(String.valueOf(symbol4));
        char symbol5 = (char) SpanishLetterGiver();
        button_5.setText(String.valueOf(symbol5));
        char symbol6 = (char) SpanishLetterGiver();
        button_6.setText(String.valueOf(symbol6));
        char symbol7 = (char) SpanishLetterGiver();
        button_7.setText(String.valueOf(symbol7));
        char symbol8 = (char) SpanishLetterGiver();
        button_8.setText(String.valueOf(symbol8));
        char symbol9 = (char) SpanishLetterGiver();
        button_9.setText(String.valueOf(symbol9));
        char symbol10 = (char) SpanishLetterGiver();
        button_10.setText(String.valueOf(symbol10));
        char symbol11 = (char) SpanishLetterGiver();
        button_11.setText(String.valueOf(symbol11));
        char symbol12 = (char) SpanishLetterGiver();
        button_12.setText(String.valueOf(symbol12));
        ///////////////////////////////////////////////////////////////////////////////////////
        enter_Button.addActionListener(e -> {
            String word = tfWord.getText();
            try {
                int points;
                if (wordChecker(word)) {
                    if (!usedWords.contains(word)) {
                        points = word.length();
                        sum = sum + points;
                        lblPointsForTheWord.setText(String.valueOf(points));
                        lblResultAll.setText(String.valueOf(sum));
                        usedWords.add(word);
                    } else if (usedWords.contains(word)) {
                        JFrame frame = new JFrame("Try again");
                        JOptionPane.showMessageDialog(frame, "You have written this word already");
                    }
                } else {
                    JFrame frame = new JFrame("No such word exception");
                    JOptionPane.showMessageDialog(frame, "There is no such word ");

                }
                tfWord.setText("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        clear_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Clear");
            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to clear", " Clear", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                tfWord.setText("");
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        stop_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Exit");
            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", " Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                try {
                    if (lblResultAll.getText().equals("")) {
                        lblResultAll.setText("0");
                    }
                    EnglishWindow.usernameAndScoreWriter(username, Integer.parseInt(lblResultAll.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                sum = 0;
                System.exit(0);
            }

        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_1.addActionListener(e -> {
            String symbolButton1 = button_1.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_2.addActionListener(e -> {
            String symbolButton1 = button_2.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_3.addActionListener(e -> {
            String symbolButton1 = button_3.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_4.addActionListener(e -> {
            String symbolButton1 = button_4.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_5.addActionListener(e -> {
            String symbolButton1 = button_5.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_6.addActionListener(e -> {
            String symbolButton1 = button_6.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_7.addActionListener(e -> {
            String symbolButton1 = button_7.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_8.addActionListener(e -> {
            String symbolButton1 = button_8.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_9.addActionListener(e -> {
            String symbolButton1 = button_9.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_10.addActionListener(e -> {
            String symbolButton1 = button_10.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_11.addActionListener(e -> {
            String symbolButton1 = button_11.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_12.addActionListener(e -> {
            String symbolButton1 = button_12.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_Backspace.addActionListener(e -> {
            if (tfWord.getText().equals("")) {
                JFrame frame = new JFrame("No word written");
                JOptionPane.showMessageDialog(frame, "There is no word to backspace");
            }
            String word = tfWord.getText();
            String nWord = "";
            for (int i = 0; i < word.length() - 1; i++) {
                char symbol = word.charAt(i);
                nWord = nWord + symbol;
            }
            tfWord.setText(nWord);
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        tfWord.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if ((Character.isDefined(c))) {
                    e.consume();
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    if (lblResultAll.getText().equals("")) {
                        lblResultAll.setText("0");
                    }
                    EnglishWindow.usernameAndScoreWriter(username, Integer.parseInt(lblResultAll.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });

        button_ScoreBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardWindow frame = null;
                try {
                    frame = new ScoreBoardWindow();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.setVisible(true);
            }
        });
        JLabel label = new JLabel();
        spanishPanel.add(label);
        label.setBounds(0, 0, x, y);
        label.setVisible(true);
        ImageIcon engFlag = new ImageIcon("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\spain-flag-pic.jpg");
        Image img = engFlag.getImage();
        Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledFlag = new ImageIcon(scaledImg);
        label.setIcon(scaledFlag);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int SpanishLetterGiver() throws IOException {
        Random rand = new Random();
        String vocalLetters = "aeiou";
        String nonVocalLetters = "bcdfghjklmnñpqrstvwxyz";
        index = rand.nextInt(6);
        char symbol1;
        if (probabilityMas[index] == 1) {
            symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
        } else {
            symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
        }
        while (chosenLetters.contains(symbol1)) {
            if (probabilityMas[index] == 1) {
                symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
            } else if (probabilityMas[index] == 0) {
                if (chosenLetters.containsAll(allVocalLetters)) {
                    symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
                    chosenLetters.add(symbol1);
                    return symbol1;
                }
                symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
            }
        }
        chosenLetters.add(symbol1);
        return symbol1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean wordChecker(String word) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\spanishDictionary"));
        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            if (word.equals(currentWord)) {
                return true;
            }
        }
        reader.close();
        return false;
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class GermanWindow extends JFrame {

    private JPanel germanPanel;
    int[] probabilityMas = {1, 0, 1, 1, 0, 1, 1};
    JLabel lblBestScoreChanger = new JLabel("0");
    List<String> usedWords = new ArrayList<>();
    List<Character> chosenLetters = new ArrayList<>();
    List<Character> allVocalLetters = new ArrayList<>();
    List<String> usernameList;
    String username;
    int sum = 0;
    int index;
    int bestScore = 0;

    public GermanWindow() throws IOException {
        usernameList = EnglishWindow.usernameAdder();
        username = JOptionPane.showInputDialog(null, "Geben Sie Ihren Benutzernamen ein");

        if (username.equals("") || username.isEmpty()) {
            while (username.equals(""))
                username = JOptionPane.showInputDialog(null, "Geben Sie Ihren Benutzernamen ein");
        }
        if (usernameList.contains(username)) {
            JOptionPane.showMessageDialog(null, "\n" + "Willkommen zurück " + username);
            bestScore = EnglishWindow.bestScoreChecker(username);
            JOptionPane.showMessageDialog(null, "Ihre beste Punktzahl für jetzt ist " + bestScore);
            lblBestScoreChanger.setText(String.valueOf(bestScore));
        }

        setTitle("WordSpiel");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int x=1920,y=1080;
        setSize(x,y);
        germanPanel = new JPanel();
        germanPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(germanPanel);
        germanPanel.setLayout(null);
        setLocationRelativeTo(null);

        allVocalLetters.add('i');
        allVocalLetters.add('o');
        allVocalLetters.add('u');
        allVocalLetters.add('e');
        allVocalLetters.add('a');


        JTextField tfWord = new JTextField();
        tfWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        tfWord.setBounds(20, 120, 400, 30);
        germanPanel.add(tfWord);
        lblBestScoreChanger.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblBestScoreChanger.setForeground(Color.WHITE);
        lblBestScoreChanger.setBounds(540, 80, 120, 20);
        germanPanel.add(lblBestScoreChanger);
        JLabel lblPointsForTheWord = new JLabel("Word punkte");
        lblPointsForTheWord.setForeground(Color.WHITE);
        lblPointsForTheWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblPointsForTheWord.setBounds(20, 40, 120, 20);
        germanPanel.add(lblPointsForTheWord);
        JLabel lblResultAll = new JLabel("0");
        lblResultAll.setForeground(Color.WHITE);
        lblResultAll.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResultAll.setBounds(530, 40, 120, 20);
        germanPanel.add(lblResultAll);
        JLabel lblResult = new JLabel("Resultat");
        lblResult.setForeground(Color.WHITE);
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResult.setBounds(450, 40, 120, 20);
        germanPanel.add(lblResult);
        JLabel lblWord = new JLabel("Word");
        lblWord.setForeground(Color.WHITE);
        lblWord.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblWord.setBounds(20, 80, 120, 20);
        germanPanel.add(lblWord);
        JLabel lblbestScore = new JLabel("BestePunkte");
        lblbestScore.setForeground(Color.WHITE);
        lblbestScore.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblbestScore.setBounds(450, 80, 120, 20);
        germanPanel.add(lblbestScore);
        JButton clear_Button = new JButton();
        germanPanel.add(clear_Button);
        clear_Button.setBounds(450, 200, 250, 30);
        clear_Button.setText("Klar");
        JButton enter_Button = new JButton();
        germanPanel.add(enter_Button);
        enter_Button.setBounds(450, 240, 250, 30);
        enter_Button.setText("Eintreten");
        JButton stop_Button = new JButton();
        germanPanel.add(stop_Button);
        stop_Button.setBounds(450, 280, 250, 30);
        stop_Button.setText("Ausgang");
        JButton button_Backspace = new JButton();
        germanPanel.add(button_Backspace);
        button_Backspace.setBounds(450, 160, 250, 30);
        button_Backspace.setText("Rücktaste");
        JButton button_ScoreBoard = new JButton();
        germanPanel.add(button_ScoreBoard);
        button_ScoreBoard.setBounds(450, 120, 250, 30);
        button_ScoreBoard.setText("Anzeigetafel");


        JButton button_1 = new JButton();
        germanPanel.add(button_1);
        button_1.setBounds(20, 200, 120, 30);
        JButton button_2 = new JButton();
        germanPanel.add(button_2);
        button_2.setBounds(20, 240, 120, 30);
        JButton button_3 = new JButton();
        germanPanel.add(button_3);
        button_3.setBounds(20, 280, 120, 30);
        JButton button_4 = new JButton();
        germanPanel.add(button_4);
        button_4.setBounds(20, 160, 120, 30);
        JButton button_5 = new JButton();
        germanPanel.add(button_5);
        button_5.setBounds(160, 200, 120, 30);
        JButton button_6 = new JButton();
        germanPanel.add(button_6);
        button_6.setBounds(160, 240, 120, 30);
        JButton button_7 = new JButton();
        germanPanel.add(button_7);
        button_7.setBounds(160, 280, 120, 30);
        JButton button_8 = new JButton();
        germanPanel.add(button_8);
        button_8.setBounds(160, 160, 120, 30);
        JButton button_9 = new JButton();
        germanPanel.add(button_9);
        button_9.setBounds(300, 200, 120, 30);
        JButton button_10 = new JButton();
        germanPanel.add(button_10);
        button_10.setBounds(300, 240, 120, 30);
        JButton button_11 = new JButton();
        germanPanel.add(button_11);
        button_11.setBounds(300, 280, 120, 30);
        JButton button_12 = new JButton();
        germanPanel.add(button_12);
        button_12.setBounds(300, 160, 120, 30);


        char symbol1 = (char) GermanLetterGiver();
        button_1.setText(String.valueOf(symbol1));
        char symbol2 = (char) GermanLetterGiver();
        button_2.setText(String.valueOf(symbol2));
        char symbol3 = (char) GermanLetterGiver();
        button_3.setText(String.valueOf(symbol3));
        char symbol4 = (char) GermanLetterGiver();
        button_4.setText(String.valueOf(symbol4));
        char symbol5 = (char) GermanLetterGiver();
        button_5.setText(String.valueOf(symbol5));
        char symbol6 = (char) GermanLetterGiver();
        button_6.setText(String.valueOf(symbol6));
        char symbol7 = (char) GermanLetterGiver();
        button_7.setText(String.valueOf(symbol7));
        char symbol8 = (char) GermanLetterGiver();
        button_8.setText(String.valueOf(symbol8));
        char symbol9 = (char) GermanLetterGiver();
        button_9.setText(String.valueOf(symbol9));
        char symbol10 = (char) GermanLetterGiver();
        button_10.setText(String.valueOf(symbol10));
        char symbol11 = (char) GermanLetterGiver();
        button_11.setText(String.valueOf(symbol11));
        char symbol12 = (char) GermanLetterGiver();
        button_12.setText(String.valueOf(symbol12));
        ///////////////////////////////////////////////////////////////////////////////////////
        enter_Button.addActionListener(e -> {
            String word = tfWord.getText();
            try {
                int points;
                if (wordChecker(word)) {
                    if (!usedWords.contains(word)) {
                        points = word.length();
                        sum = sum + points;
                        lblPointsForTheWord.setText(String.valueOf(points));
                        lblResultAll.setText(String.valueOf(sum));
                        usedWords.add(word);
                    } else if (usedWords.contains(word)) {
                        JFrame frame = new JFrame("Versuchen Sie es nochmal");
                        JOptionPane.showMessageDialog(frame, "Sie haben dieses Wort bereits geschrieben");
                    }
                } else {
                    JFrame frame = new JFrame("Keine solche Wort");
                    JOptionPane.showMessageDialog(frame, "Keine solche Wort");

                }
                tfWord.setText("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        clear_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Klar");
            if (JOptionPane.showConfirmDialog(frame, "Bestätigen Sie, wenn Sie löschen möchten", " Klar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                tfWord.setText("");
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        stop_Button.addActionListener(e -> {
            JFrame frame = new JFrame("Ausgang");
            if (JOptionPane.showConfirmDialog(frame, "Bestätigen Sie, wenn Sie beenden möchten", " Ausgang", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                try {
                    if (lblResultAll.getText().equals("")) {
                        lblResultAll.setText("0");
                    }
                    EnglishWindow.usernameAndScoreWriter(username, Integer.parseInt(lblResultAll.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                sum = 0;
                System.exit(0);
            }

        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_1.addActionListener(e -> {
            String symbolButton1 = button_1.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_2.addActionListener(e -> {
            String symbolButton1 = button_2.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_3.addActionListener(e -> {
            String symbolButton1 = button_3.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_4.addActionListener(e -> {
            String symbolButton1 = button_4.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_5.addActionListener(e -> {
            String symbolButton1 = button_5.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_6.addActionListener(e -> {
            String symbolButton1 = button_6.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_7.addActionListener(e -> {
            String symbolButton1 = button_7.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_8.addActionListener(e -> {
            String symbolButton1 = button_8.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_9.addActionListener(e -> {
            String symbolButton1 = button_9.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_10.addActionListener(e -> {
            String symbolButton1 = button_10.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_11.addActionListener(e -> {
            String symbolButton1 = button_11.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        button_12.addActionListener(e -> {
            String symbolButton1 = button_12.getText();
            String symbolButton2 = tfWord.getText();
            tfWord.setText(String.join("", symbolButton2, symbolButton1));
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        button_Backspace.addActionListener(e -> {
            if (tfWord.getText().equals("")) {
                JFrame frame = new JFrame("Kein Word geschrieben");
                JOptionPane.showMessageDialog(frame, "Es gibt kein Wort für die Rücktaste");
            }
            String word = tfWord.getText();
            String nWord = "";
            for (int i = 0; i < word.length() - 1; i++) {
                char symbol = word.charAt(i);
                nWord = nWord + symbol;
            }
            tfWord.setText(nWord);
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        tfWord.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();
                if ((Character.isDefined(c))) {
                    e.consume();
                }
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    if (lblResultAll.getText().equals("")) {
                        lblResultAll.setText("0");
                    }
                    EnglishWindow.usernameAndScoreWriter(username, Integer.parseInt(lblResultAll.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });

        button_ScoreBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreBoardWindow frame = null;
                try {
                    frame = new ScoreBoardWindow();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frame.setVisible(true);
            }
        });
        JLabel label = new JLabel();
        germanPanel.add(label);
        label.setBounds(0, 0, x, y);
        label.setVisible(true);
        ImageIcon gerFlag = new ImageIcon("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\germanFlag.png");
        Image img = gerFlag.getImage();
        Image scaledImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledFlag = new ImageIcon(scaledImg);
        label.setIcon(scaledFlag);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int GermanLetterGiver() throws IOException {
        Random rand = new Random();
        String vocalLetters = "aeuio";
        String nonVocalLetters = "qwrtypsdfghjklzxcvbnmßäöü";
        index = rand.nextInt(6);
        char symbol1;
        if (probabilityMas[index] == 1) {
            symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
        } else {
            symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
        }
        while (chosenLetters.contains(symbol1)) {
            if (probabilityMas[index] == 1) {
                symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
            } else if (probabilityMas[index] == 0) {
                if (chosenLetters.containsAll(allVocalLetters)) {
                    symbol1 = nonVocalLetters.charAt(rand.nextInt(nonVocalLetters.length()));
                    chosenLetters.add(symbol1);
                    return symbol1;
                }
                symbol1 = vocalLetters.charAt(rand.nextInt(vocalLetters.length()));
            }
        }
        chosenLetters.add(symbol1);
        return symbol1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean wordChecker(String word) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\bobi_\\IdeaProjects\\fundamentals\\src\\Word_Game\\germanDictionary"));
        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            if (word.equalsIgnoreCase(currentWord)) {
                return true;
            }
        }
        reader.close();
        return false;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Game extends JFrame {
    public Game() throws IOException {
        LanguageWindow languageWindow = new LanguageWindow();

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        Game game = new Game();
    }

}
//Добавяне на проверка за дължината на username за да не се слива с резултата на Scoreboarda

