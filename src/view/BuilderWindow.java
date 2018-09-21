package view;

import controller.CreateNewLightningController;
import controller.CreateNewPuzzleController;
import controller.CreateNewThemeController;
import controller.EditLevelButtonController;
import model.BuilderModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Builder window object.
 * <p>
 * start builder window.
 */
public class BuilderWindow extends JFrame {

    private static final long serialVersionUID = 2423303482244263105L;

    JButton[] buttons = new JButton[15];    // 15 buttons represents 15 levels
    JButton puzzleButton;
    JButton lightningButton;
    JButton themeButton;
    BuilderModel builderModel;

    /**
     * Constructor.
     *
     * @param model Model for the builder window.
     */
    public BuilderWindow(BuilderModel model) {
        this.builderModel = model;
        init();
    }

    /**
     * Initializes the builder window and sets the controllers.
     * <p>
     * Setup all the components and controller for the frame.
     */
    public void init() {
        setBounds(20, 20, 720, 700);
        setTitle("Vanadium LetterCraze Builder");
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Header = new JLabel("Build LetterCraze\n");
        Header.setBounds(20, 6, 507, 47);
        Header.setForeground(Color.ORANGE);
        Header.setFont(new Font("Phosphate", Font.BOLD, 56));
        Header.setBackground(Color.BLACK);
        contentPane.add(Header);

        JLabel Contributor = new JLabel("Yifei Jin, Emily Hao, Ming Xu, Fan Mo, Zixin Luo");
        Contributor.setBounds(18, 50, 298, 16);
        Contributor.setForeground(Color.ORANGE);
        Contributor.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        contentPane.add(Contributor);

        puzzleButton = new JButton("NEW PUZZLE LEVEL");
        puzzleButton.setBackground(Color.PINK);
        puzzleButton.setForeground(Color.ORANGE);
        puzzleButton.setFont(new Font("Phosphate", Font.BOLD, 20));
        puzzleButton.setBounds(31, 587, 196, 54);
        contentPane.add(puzzleButton);

        lightningButton = new JButton("NEW LIGHTENING LEVEL");
        lightningButton.setBackground(Color.PINK);
        lightningButton.setForeground(Color.ORANGE);
        lightningButton.setFont(new Font("Phosphate", Font.BOLD, 20));
        lightningButton.setBounds(255, 587, 230, 54);
        contentPane.add(lightningButton);

        themeButton = new JButton("NEW THEME LEVEL");
        themeButton.setBackground(Color.PINK);
        themeButton.setForeground(Color.ORANGE);
        themeButton.setFont(new Font("Phosphate", Font.BOLD, 20));
        themeButton.setBounds(513, 587, 196, 54);
        contentPane.add(themeButton);

        drawLevelButtons(contentPane);

        // install controller
        puzzleButton.addActionListener(new CreateNewPuzzleController(this));
        lightningButton.addActionListener(new CreateNewLightningController(this));
        themeButton.addActionListener(new CreateNewThemeController(this));

    }


    /**
     * Draw all the level buttons.
     * <p>
     * Draw all the level buttons according to the number of current level and set the pictures.
     *
     * @param contentPane The JFrame to draw
     */
    public void drawLevelButtons(JPanel contentPane) {

        int LevelNum = builderModel.getCurrentLevelNumber();

        // case level number smaller than 5
        if (LevelNum <= 5) {

            for (int i = 0; i < LevelNum; i++) {
                buttons[i] = new JButton("");
                buttons[i].setBounds(40 + 130 * i, 90, 90, 90);
                contentPane.add(buttons[i]);
                buttons[i].setIcon(new ImageIcon("img/level" + (i + 1) + ".png"));
            }

            // case level number smaller than 10
        } else if (LevelNum <= 10) {

            for (int i = 0; i < 5; i++) {
                buttons[i] = new JButton("");
                buttons[i].setBounds(40 + 130 * i, 90, 90, 90);
                contentPane.add(buttons[i]);
                buttons[i].setIcon(new ImageIcon("img/level" + (i + 1) + ".png"));
            }

            for (int i = 5; i < LevelNum; i++) {
                buttons[i] = new JButton("");
                buttons[i].setBounds(40 + 130 * (i - 5), 235, 90, 90);
                contentPane.add(buttons[i]);
                buttons[i].setIcon(new ImageIcon("img/level" + (i + 1) + ".png"));
            }

            // case level number smaller than 15
        } else if (LevelNum <= 15) {

            for (int i = 0; i < 5; i++) {
                buttons[i] = new JButton("");
                buttons[i].setBounds(40 + 130 * i, 90, 90, 90);
                contentPane.add(buttons[i]);
                buttons[i].setIcon(new ImageIcon("img/level" + (i + 1) + ".png"));
            }

            for (int i = 5; i < 10; i++) {
                buttons[i] = new JButton("");
                buttons[i].setBounds(40 + 130 * (i - 5), 235, 90, 90);
                contentPane.add(buttons[i]);
                buttons[i].setIcon(new ImageIcon("img/level" + (i + 1) + ".png"));
            }

            for (int i = 10; i < LevelNum; i++) {
                buttons[i] = new JButton("");
                buttons[i].setBounds(40 + 130 * (i - 10), 380, 90, 90);
                contentPane.add(buttons[i]);
                buttons[i].setIcon(new ImageIcon("img/level" + (i + 1) + ".png"));
            }
        }

        for (int i = 0; i < LevelNum; i++) {
            buttons[i].addActionListener(new EditLevelButtonController(this));
        }
    }

    /**
     * @return buttons for 15 levels
     */
    public JButton[] getButtons() {
        return buttons;
    }

    /**
     * @return PuzzleButton
     */
    public JButton getPuzzleButton() {
        return puzzleButton;
    }

    /**
     * @return Lightning Button
     */
    public JButton getLightningButton() {
        return lightningButton;
    }

    /**
     * @return Theme Button
     */
    public JButton getThemeButton() {
        return themeButton;
    }

    /**
     * @return Builder model
     */
    public BuilderModel getBuilderModel() {
        return builderModel;
    }
}
