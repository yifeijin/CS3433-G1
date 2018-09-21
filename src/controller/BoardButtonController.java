package controller;

import view.LevelView;
import view.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Controller object for buttons on the board.
 * <p>
 * Changes the board file while changing the press the button.
 */
public class BoardButtonController implements ActionListener {

    private LevelView lv;

    /**
     * Constructor.
     *
     * @param lv The level view which is being modified
     */
    public BoardButtonController(LevelView lv) {
        this.lv = lv;
    }

    /**
     * Changes corresponding button from 1/A to 0/A.
     * <p>
     * Creates a new txt file. All the data from the old file except the one being pressed on
     * is copied to new file. 0 in the file means letters could be put on it. 1 means no letter
     * is allowed on it. After the copy is done, the old file is deleted and the new file is
     * renamed to the new file.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton boardButton = (JButton) e.getSource();
        JButton[][] buttons = lv.getButtons();

        // find the index of the button in the button array
        int buttonIndex = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (buttons[i][j] == boardButton) {
                    buttonIndex = 6 * i + j;
                    break;
                }
            }
        }

        // Then change the board data in the data directory.
        int levelNum = lv.getModel().getCurrentLevelNumber();
        String oldFileName = "data/level" + levelNum + ".txt";
        String newFileName = "data/newLevel" + levelNum + ".txt";

        File oldFile = new File(oldFileName);   // file to be copied from
        File newFile = new File(newFileName);   // file to be copied to

        BufferedWriter bw = null;
        BufferedReader br = null;

        try {
            bw = new BufferedWriter(new FileWriter(newFileName));
            br = new BufferedReader(new FileReader(oldFileName));

            int c;                  // the char to copy
            char charTobeChanged;   // keep track of the char to be changed
            boolean isBeginOfLine = buttonIndex == 6 || buttonIndex == 12 || buttonIndex == 18 || buttonIndex == 24 || buttonIndex == 30;

            // write to the new file until the buttonIndex
            for (int i = 0; i < buttonIndex; i++) {
                c = br.read();
                bw.write(c);

                // if find new line, do not add i
                if (c == '\n') {
                    i--;
                }

                // write new line to the end and skip it if the buttonIndex is at the beginning of line
                if (i == buttonIndex - 1 && isBeginOfLine) {
                    bw.write('\n');
                    br.read();
                }
            }

            // remember the char to be changed
            charTobeChanged = (char) br.read();

            if (charTobeChanged == '1') {
                if (lv.getClass().getName().equals("view.ThemeView")) {
                    bw.write("A");
                } else bw.write("0");
            } else bw.write("1");

            // copy the left chars
            while ((c = br.read()) != -1) {
                bw.write(c);
            }
        } catch (Exception ex) {    // catch exception
            ex.printStackTrace();
        } finally {                 // finally close all the files
            try {
                if (br != null)
                    br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // After everything is complete, deletes the old file and updates rename the new file
        oldFile.delete();
        newFile.renameTo(oldFile);

        // If lv is a ThemeView, the comboBoxes also need to be reset
        if (lv.getClass().getName().equals("view.ThemeView")) {
            ((ThemeView) lv).init();
        } else lv.setPicture();
    }
}
