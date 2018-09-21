package view;

import controller.ComboBoxController;
import controller.TextFieldFocusController;
import model.LevelModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Theme view object.
 * <p>
 * Represents the theme view for the builder side.
 */
public class ThemeView extends LevelView {

    private static final long serialVersionUID = -3368241332820383898L;

    private String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "QU", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private JTextField themeField;
    private JTextField answerField;
    private JComboBox[][] comboBoxes = new JComboBox[6][6];
    private int[][] comboBoxesFlag = new int[6][6];

    /**
     * Constructor.
     *
     * @param model Level Model.
     */
    public ThemeView(LevelModel model) {
        super(model);
        init();
    }

    /**
     * Initializes the theme view.
     * <p>
     * Initializes the theme view and sets all the controllers.
     */
    public void init() {
        String[] info = readInfo();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Theme Builder");
        setBounds(20, 20, 720, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("THEME LEVEL");
        title.setFont(new Font("Phosphate", Font.BOLD, 58));
        title.setForeground(Color.ORANGE);
        title.setBounds(165, 6, 458, 47);
        contentPane.add(title);

        JLabel makeBoard = new JLabel("Make Board");
        makeBoard.setFont(new Font("Phosphate", Font.BOLD, 26));
        makeBoard.setBounds(29, 51, 174, 47);
        contentPane.add(makeBoard);

        JLabel maxLabel = new JLabel("SET THEME");
        maxLabel.setFont(new Font("Phosphate", Font.BOLD, 26));
        maxLabel.setBounds(400, 54, 144, 41);
        contentPane.add(maxLabel);

        if (info[12].equals("0")) {
            themeField = new JTextField("Enter the theme");
        } else themeField = new JTextField(info[12]);
        themeField.setBounds(400, 94, 174, 33);
        themeField.setSelectionStart(0);
        themeField.setSelectionEnd(themeField.getText().length());
        contentPane.add(themeField);
        themeField.setColumns(10);

        JLabel answerLabel = new JLabel("SET ANSWERS");
        answerLabel.setFont(new Font("Phosphate", Font.BOLD, 26));
        answerLabel.setBounds(400, 132, 161, 47);
        contentPane.add(answerLabel);

        JLabel answerLabel2 = new JLabel("Please enter at least three words related to the theme");
        answerLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        answerLabel2.setBounds(399, 163, 314, 33);
        contentPane.add(answerLabel2);

        if (info[13].equals("0")) {
            answerField = new JTextField("Enter the answers");
        } else answerField = new JTextField(info[13]);
        answerField.setColumns(10);
        answerField.setBounds(400, 191, 212, 33);
        contentPane.add(answerField);

        JLabel starLeverage = new JLabel("STAR LEVERAGE");
        starLeverage.setFont(new Font("Phosphate", Font.BOLD, 26));
        starLeverage.setBounds(400, 225, 174, 41);
        contentPane.add(starLeverage);

        JLabel oneStarLabel = new JLabel("One Star Word Number");
        oneStarLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        oneStarLabel.setBounds(400, 273, 120, 16);
        contentPane.add(oneStarLabel);

        JLabel lblPoints = new JLabel("Two Star Word Number");
        lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblPoints.setBounds(400, 301, 134, 16);
        contentPane.add(lblPoints);

        JLabel lblPointsForReaching = new JLabel("Three Star Word Number");
        lblPointsForReaching.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblPointsForReaching.setBounds(400, 329, 134, 16);
        contentPane.add(lblPointsForReaching);

        if (info[7].equals("0")) {
            oneStarField = new JTextField("Enter a number");
        } else oneStarField = new JTextField(info[7]);
        oneStarField.setBounds(593, 261, 120, 26);
        contentPane.add(oneStarField);
        oneStarField.setColumns(10);

        if (info[8].equals("0")) {
            twoStarField = new JTextField("Enter a number");
        } else twoStarField = new JTextField(info[8]);
        twoStarField.setBounds(592, 294, 120, 26);
        contentPane.add(twoStarField);
        twoStarField.setColumns(10);

        if (info[9].equals("0")) {
            threeStarField = new JTextField("Enter a number");
        } else threeStarField = new JTextField(info[9]);
        threeStarField.setBounds(593, 329, 120, 26);
        contentPane.add(threeStarField);
        threeStarField.setColumns(10);

        saveButton = new JButton("SAVE");
        saveButton.setFont(new Font("Phosphate", Font.BOLD, 48));
        saveButton.setForeground(Color.GREEN);
        saveButton.setBounds(462, 398, 180, 50);
        contentPane.add(saveButton);

        deleteButton = new JButton("DELETE");
        deleteButton.setFont(new Font("Phosphate", Font.BOLD, 48));
        deleteButton.setForeground(Color.RED);
        deleteButton.setBounds(462, 460, 180, 50);
        contentPane.add(deleteButton);

        returnButton = new JButton("RETURN");
        returnButton.setFont(new Font("Phosphate", Font.BOLD, 48));
        returnButton.setForeground(Color.BLACK);
        returnButton.setBounds(462, 522, 180, 50);
        contentPane.add(returnButton);

        drawBoard(contentPane);
        drawComboBoxes(contentPane);

        // installs controller
        oneStarField.addFocusListener(new TextFieldFocusController(oneStarField));
        twoStarField.addFocusListener(new TextFieldFocusController(twoStarField));
        threeStarField.addFocusListener(new TextFieldFocusController(threeStarField));
        answerField.addFocusListener(new TextFieldFocusController(answerField));
        themeField.addFocusListener(new TextFieldFocusController(themeField));
    }

    /**
     * Draws all the comboBoxes.
     * <p>
     * Draws all the comboBoxes and sets its default value according to the data file.
     */
    public void drawComboBoxes(JPanel contentPane) {
        File dataFile = this.getModel().getDataFile();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data/" + dataFile.getName()));

            // Sets up the flag from the data file
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    int c = br.read();

                    if (c == '\n') {
                        j--;
                    } else comboBoxesFlag[i][j] = c;
                }
            }

            br = new BufferedReader(new FileReader("data/" + dataFile.getName()));
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (comboBoxesFlag[i][j] != '1') {

                        int letter = comboBoxesFlag[i][j];
                        int defaultIndex = 0;
                        for (int k = 0; k < 26; k++) {
                            if (letters[k].equals(String.valueOf((char) letter))) {
                                defaultIndex = k;
                            }
                        }

                        comboBoxes[i][j] = new JComboBox(letters);
                        comboBoxes[i][j].setBounds(3 + 65 * j, 146 + 79 * i, 62, 27);
                        comboBoxes[i][j].setSelectedIndex(defaultIndex);
                        comboBoxes[i][j].addActionListener(new ComboBoxController(this));
                        contentPane.add(comboBoxes[i][j]);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * @return Theme field
     */
    public JTextField getThemeField() {
        return themeField;
    }

    /**
     * @return Answer field
     */
    public JTextField getAnswerField() {
        return answerField;
    }

    /**
     * @return ComboBoxes
     */
    public JComboBox[][] getComboBoxes() {
        return comboBoxes;
    }

    /**
     * @return Alphabet String
     */
    public String[] getLetters() {
        return letters;
    }
}
