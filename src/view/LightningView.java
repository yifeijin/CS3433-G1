package view;

import controller.TextFieldFocusController;
import model.LevelModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Lightning view object.
 * <p>
 * All the view settings about the lightning view.
 */
public class LightningView extends LevelView {

    private static final long serialVersionUID = 710512659799751830L;

    JTextField timeField;

    /**
     * Constructor.
     *
     * @param model Level model
     */
    public LightningView(LevelModel model) {
        super(model);
        init();
    }

    /**
     * Initializes the lightning View.
     * <p>
     * Sets all the components about the lightning view.
     */
    public void init() {
        String[] info = readInfo();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Lightening Builder");
        setBounds(20, 20, 720, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel title = new JLabel("LIGHTNING LEVEL");
        title.setFont(new Font("Phosphate", Font.BOLD, 58));
        title.setForeground(Color.ORANGE);
        title.setBounds(165, 6, 458, 47);
        contentPane.add(title);

        JLabel makeBoard = new JLabel("Make Board");
        makeBoard.setFont(new Font("Phosphate", Font.BOLD, 26));
        makeBoard.setBounds(29, 51, 174, 47);
        contentPane.add(makeBoard);

        JLabel timeLabel = new JLabel("TOTAL TIME");
        timeLabel.setFont(new Font("Phosphate", Font.BOLD, 26));
        timeLabel.setBounds(400, 51, 144, 47);
        contentPane.add(timeLabel);

        JLabel lblNewLabel = new JLabel("Please enter a positive number (suggest100-300)");
        lblNewLabel.setBounds(400, 87, 314, 16);
        contentPane.add(lblNewLabel);

        if (info[12].equals("0")) {
            timeField = new JTextField("Enter a number");
        } else timeField = new JTextField(info[12]);
        timeField.setBounds(400, 110, 144, 33);
        contentPane.add(timeField);
        timeField.setColumns(10);

        JLabel secondsLabel = new JLabel("Seconds");
        secondsLabel.setFont(new Font("Phosphate", Font.BOLD, 27));
        secondsLabel.setBounds(578, 118, 108, 25);
        contentPane.add(secondsLabel);

        JLabel starLeverage = new JLabel("STAR LEVERAGE");
        starLeverage.setFont(new Font("Phosphate", Font.BOLD, 26));
        starLeverage.setBounds(400, 155, 174, 41);
        contentPane.add(starLeverage);

        JLabel oneStarLabel = new JLabel("One Star Word Number");
        oneStarLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        oneStarLabel.setBounds(400, 208, 255, 16);
        contentPane.add(oneStarLabel);

        JLabel lblPoints = new JLabel("Two Star Word Number");
        lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblPoints.setBounds(400, 251, 261, 16);
        contentPane.add(lblPoints);

        JLabel lblPointsForReaching = new JLabel("Three Star Word Number");
        lblPointsForReaching.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
        lblPointsForReaching.setBounds(400, 292, 261, 16);
        contentPane.add(lblPointsForReaching);

        if (info[7].equals("0")) {
            oneStarField = new JTextField("Enter a number");
        } else oneStarField = new JTextField(info[7]);
        oneStarField.setBounds(594, 203, 120, 26);
        contentPane.add(oneStarField);
        oneStarField.setColumns(10);

        if (info[8].equals("0")) {
            twoStarField = new JTextField("Enter a number");
        } else twoStarField = new JTextField(info[8]);
        twoStarField.setBounds(594, 246, 120, 26);
        contentPane.add(twoStarField);
        twoStarField.setColumns(10);

        if (info[9].equals("0")) {
            threeStarField = new JTextField("Enter a number");
        } else threeStarField = new JTextField(info[9]);
        threeStarField.setBounds(594, 287, 120, 26);
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

        // install controller
        oneStarField.addFocusListener(new TextFieldFocusController(oneStarField));
        twoStarField.addFocusListener(new TextFieldFocusController(twoStarField));
        threeStarField.addFocusListener(new TextFieldFocusController(threeStarField));
        timeField.addFocusListener(new TextFieldFocusController(timeField));
    }

    /**
     * @return time field
     */
    public JTextField getTime() {
        return timeField;
    }
}
