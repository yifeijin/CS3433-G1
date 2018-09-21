package controller;

import view.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Controller for ComboBox.
 * <p>
 * Allows the user to select words in themeLevel.
 */
public class ComboBoxController implements ActionListener {

    ThemeView tv;

    /**
     * Constructor.
     *
     * @param tv ThemeView to be listened
     */
    public ComboBoxController(ThemeView tv) {
        this.tv = tv;
    }

    /**
     * Writes to the data file while selecting a item from the ComboBox.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String[] letters = tv.getLetters();
        int selectIndex = comboBox.getSelectedIndex();
        // Sets it back to Q to make it easy to read in data file for player
        letters[16] = "Q";

        // finds the index of the comboBox
        int comboBoxIndex = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (comboBox == tv.getComboBoxes()[i][j]) {
                    comboBoxIndex = 6 * i + j;
                    break;
                }
            }
        }

        File oldFile = tv.getModel().getDataFile();

        String newFileName = "data/newLevel.txt";
        File newFile = new File(newFileName);

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("data/" + oldFile.getName()));
            bw = new BufferedWriter(new FileWriter(newFileName));

            int c;                  // the char to copy
            boolean isBeginOfLine = comboBoxIndex == 6 || comboBoxIndex == 12 || comboBoxIndex == 18 || comboBoxIndex == 24 || comboBoxIndex == 30;

            // Writes to the new file until the buttonIndex
            for (int i = 0; i < comboBoxIndex; i++) {
                c = br.read();
                bw.write(c);

                if (c == '\n') {
                    i--;
                }

                // Writes new line to the end and skips it if the buttonIndex is at the beginning of line
                if (i == comboBoxIndex - 1 && isBeginOfLine) {
                    bw.write('\n');
                    br.read();
                }
            }

            // Skips the char to be changed and writes the letter selected from comboBox
            br.read();
            bw.write(letters[selectIndex]);

            // Copies the left chars
            while ((c = br.read()) != -1) {
                bw.write(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // After everything is complete, deletes the old file and updates rename the new file
        oldFile.delete();
        newFile.renameTo(oldFile);

        // Resets all the pictures on the button
        tv.init();
    }
}
