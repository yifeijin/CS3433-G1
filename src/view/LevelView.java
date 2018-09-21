package view;

import controller.BoardButtonController;
import controller.DeleteButtonController;
import controller.ReturnButtonController;
import controller.SaveButtonController;
import model.LevelModel;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Abstract object for level view.
 * <p>
 * Contains all common info about the level view.
 */
public abstract class LevelView extends JFrame {

    private static final long serialVersionUID = 8498203868660232046L;

    JButton saveButton;
    JButton deleteButton;
    JButton returnButton;
    JTextField oneStarField;
    JTextField twoStarField;
    JTextField threeStarField;
    JButton[][] buttons = new JButton[6][6];
    ImageIcon orangeSquare = new ImageIcon("img/Orange.png");
    ImageIcon greySquare = new ImageIcon("img/Grey.png");
    LevelModel model;

    /**
     * Constructor.
     *
     * @param model Level model.
     */
    LevelView(LevelModel model) {
        this.model = model;
    }

    /**
     * Draws squares.
     * <p>
     * Draws 36 buttons in the level view and set controllers.
     *
     * @param contentPane
     */
    void drawBoard(JPanel contentPane) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setBounds(6 + 65 * j, 94 + 80 * i, 50, 50);
                contentPane.add(buttons[i][j]);
                buttons[i][j].addActionListener(new BoardButtonController(this));
            }
        }

        setPicture();

        // install controller
        returnButton.addActionListener(new ReturnButtonController(this));
        saveButton.addActionListener(new SaveButtonController(this));
        deleteButton.addActionListener(new DeleteButtonController(this));
    }

    /**
     * Sets the pictures on the buttons.
     * <p>
     * Sets pictures on the buttons according to the corresponding board.txt file.
     * 1 is set to orange square and letters are allowed to put on it. 0 is set to
     * grey square and no letter is allowed.
     */
    public void setPicture() {

        String fileName = "data/" + model.getDataFile().getName();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(fileName));
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    int c = br.read();

                    if (c == '1') {
                        buttons[i][j].setIcon(orangeSquare);
                    } else if (c != '\n'){
                        buttons[i][j].setIcon(greySquare);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {        // close the bufferReader
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
     * Reads information from the data file.
     * <p>
     * Reads information form the data file and stores in a String array.
     *
     * @return the string array stored to.
     */
    public String[] readInfo() {
        File dataFile = model.getDataFile();
        String[] ret = new String[20];
        int index = 0;
        String s;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data/" + dataFile.getName()));
            while ((s = br.readLine()) != null) {
                ret[index] = s;
                index++;
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

        return ret;
    }

    /**
     * @return save button
     */
    public JButton getSaveButton() {
        return saveButton;
    }

    /**
     * @return delete button
     */
    public JButton getDeleteButton() {
        return deleteButton;
    }

    /**
     * @return return button
     */
    public JButton getReturnButton() {
        return returnButton;
    }

    /**
     * @return one star field
     */
    public JTextField getOneStarField() {
        return oneStarField;
    }

    /**
     * @return two star field
     */
    public JTextField getTwoStarField() {
        return twoStarField;
    }

    /**
     * @return three star field
     */
    public JTextField getThreeStarField() {
        return threeStarField;
    }

    /**
     * @return board button array
     */
    public JButton[][] getButtons() {
        return buttons;
    }

    /**
     * @return level model
     */
    public LevelModel getModel() {
        return model;
    }
}
