package controller;

import model.BuilderModel;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Controller object for save button.
 * <p>
 * Save all the changes made in the level.
 */
public class SaveButtonController implements ActionListener {

    private LevelView lv;

    /**
     * Constructor
     *
     * @param lv Level view to save
     */
    public SaveButtonController(LevelView lv) {
        this.lv = lv;
    }

    /**
     * Save all the changes made in the level.
     * <p>
     * Deletes the tmp file created when enters the level. Quits the level
     * view and open the builder window.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Deletes the tmp.txt file
        File tmpFile = new File("data/tmp.txt");
        tmpFile.delete();

        // Save all the inputs
        String oneStar = lv.getOneStarField().getText();
        String twoStar = lv.getTwoStarField().getText();
        String threeStar = lv.getThreeStarField().getText();

        try {
            int oneStarNum = Integer.parseInt(oneStar);
            int twoStarNum = Integer.parseInt(twoStar);
            int threeStarNum = Integer.parseInt(threeStar);

            if (threeStarNum < twoStarNum || twoStarNum < oneStarNum || oneStarNum < 1) {
                JOptionPane.showMessageDialog(null, "One star, greater than zero, should be smaller than two star, which should be smaller than three star", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Points or number of word should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File oldFile = lv.getModel().getDataFile();
        String oldFileName = oldFile.getName();
        String newFileName = "data/NewSetting.txt";

        File newFile = new File(newFileName);

        BufferedReader br = null;
        BufferedWriter bw = null;

        /*
         * Copies all the new setting to a new file. Deletes the old file, and
         * replaces the new file to the old file.
         */
        try {
            br = new BufferedReader(new FileReader("data/" + oldFileName));
            bw = new BufferedWriter(new FileWriter(newFileName));

            // Reads and write first 7 lines
            for (int i = 0; i < 7; i++) {
                bw.write(br.readLine() + '\n');
            }

            // Skips three lines
            for (int i = 0; i < 3; i++) {
                br.readLine();
            }

            bw.write(oneStar + '\n');
            bw.write(twoStar + '\n');
            bw.write(threeStar + '\n');

            if (lv.getClass().getName().equals("view.PuzzleView")) {
                String maxMove = ((PuzzleView) lv).getMaxMove().getText();
                try {
                    int maxMoveNum = Integer.parseInt(maxMove);
                    if (maxMoveNum < 1) {
                        JOptionPane.showMessageDialog(null, "Maximum move can only be positive", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "maxMove can only be positive integer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                br.readLine();
                bw.write(maxMove + '\n');
            } else bw.write(br.readLine() + '\n');

            if (lv.getClass().getName().equals("view.LightningView")) {
                String time = ((LightningView) lv).getTime().getText();
                try {
                    int timeNum = Integer.parseInt(time);
                    if (timeNum < 1) {
                        JOptionPane.showMessageDialog(null, "Time in second can only be positive integer", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Time in second can only be positive integer", "Error", JOptionPane.ERROR_MESSAGE);
                }
                br.readLine();
                bw.write(time + '\n');
            } else bw.write(br.readLine() + '\n');

            if (lv.getClass().getName().equals("view.ThemeView")) {
                String theme = ((ThemeView) lv).getThemeField().getText();
                String answers = ((ThemeView) lv).getAnswerField().getText();
                br.readLine();
                br.readLine();
                bw.write(theme + '\n' + answers + '\n');
            } else {
                for (int i = 0; i < 2; i++)
                    bw.write(br.readLine() + '\n');
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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

        oldFile.delete();
        newFile.renameTo(oldFile);


        // Closes the view and reopens the builder window
        BuilderWindow builderWindow = new BuilderWindow(new BuilderModel());
        builderWindow.setVisible(true);
        lv.setVisible(false);
        lv.dispose();
    }
}
