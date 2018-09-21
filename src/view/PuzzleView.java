package view;

import controller.TextFieldFocusController;
import model.LevelModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Puzzle view object.
 * <p>
 * Represents the puzzle view for builder side.
 */
public class PuzzleView extends LevelView {

    private static final long serialVersionUID = 6057176093646866281L;

    JTextField maxMove;

    /**
     * Constructor.
     *
     * @param model Level model.
     */
    public PuzzleView(LevelModel model) {
        super(model);
        init();
    }


    /**
     * Initializes the puzzle view.
     * <p>
     * Initializes the puzzle view and all the controllers.
     */
    private void init() {
        String[] info = readInfo();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Puzzle Builder");
        setBounds(20, 20, 720, 700);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("PUZZLE LEVEL");
        title.setFont(new Font("Phosphate", Font.BOLD, 58));
        title.setForeground(Color.ORANGE);
        title.setBounds(165, 6, 359, 47);
        contentPane.add(title);

        JLabel makeBoard = new JLabel("Make Board");
        makeBoard.setFont(new Font("Phosphate", Font.BOLD, 26));
        makeBoard.setBounds(29, 51, 174, 47);
        contentPane.add(makeBoard);

        JLabel maxLabel = new JLabel("MAX MOVE");
        maxLabel.setFont(new Font("Phosphate", Font.BOLD, 26));
        maxLabel.setBounds(400, 51, 144, 47);
        contentPane.add(maxLabel);

        JLabel lblNewLabel = new JLabel("Please enter a positive number (suggest10-30)");
        lblNewLabel.setBounds(400, 87, 314, 16);
        contentPane.add(lblNewLabel);

        if (info[10].equals("0")) {
            maxMove = new JTextField("Enter the max move");
        } else maxMove = new JTextField(info[10]);
        maxMove.setBounds(400, 110, 144, 33);
        contentPane.add(maxMove);
        maxMove.setColumns(10);

        JLabel starLeverage = new JLabel("STAR LEVERAGE");
        starLeverage.setFont(new Font("Phosphate", Font.BOLD, 26));
        starLeverage.setBounds(400, 155, 174, 41);
        contentPane.add(starLeverage);

        JLabel oneStarLabel = new JLabel("Points for Reaching One Star");
        oneStarLabel.setBounds(400, 208, 196, 16);
        contentPane.add(oneStarLabel);

        JLabel lblPoints = new JLabel("Points for Reaching Two Star");
        lblPoints.setBounds(400, 251, 180, 16);
        contentPane.add(lblPoints);

        JLabel lblPointsForReaching = new JLabel("Points for Reaching Three Star");
        lblPointsForReaching.setBounds(400, 292, 196, 16);
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
        maxMove.addFocusListener(new TextFieldFocusController(maxMove));
    }

    /**
     * Get max move.
     *
     * @return Max number of moves
     */
    public JTextField getMaxMove() {
        return maxMove;
    }

}
