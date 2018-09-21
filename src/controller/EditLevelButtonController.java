package controller;

import model.LightningLevelModel;
import model.PuzzleLevelModel;
import model.ThemeLevelModel;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Edit existing button controller.
 * <p>
 * Edits all the buttons already created by the builder.
 */
public class EditLevelButtonController implements ActionListener {

    private BuilderWindow bw;

    /**
     * Constructor.
     *
     * @param bw builder window to be closed.
     */
    public EditLevelButtonController(BuilderWindow bw) {
        this.bw = bw;
    }

    /**
     * Enters the level already exists.
     * <p>
     * Closes the current builder window and enters the level view. Creates
     * a tmp tile to store original data in case does not save.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Find the corresponding index of the button in the button array
        JButton levelButton = (JButton) e.getSource();

        int buttonIndex = 0;
        for (int i = 0; i < 16; i++) {
            if (bw.getButtons()[i] == levelButton) {
                buttonIndex = i;
                break;
            }
        }


        // Start reading lines and find the mode of the data file
        int levelNum = buttonIndex + 1;
        String type = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("data/level" + levelNum + ".txt"));
            for (int i = 0; i < 7; i++) {
                type = br.readLine();
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
        }

        // Before start, make a copy of the data file in case not save it
        File dataFile = new File("data/level" + levelNum + ".txt");
        File tmpFile = new File("data/tmp.txt");
        try {
            Files.copy(dataFile.toPath(), tmpFile.toPath(), REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // create new level view according to the mode
        LevelView lv = null;
        switch (type) {
            case "Lightning":
                lv = new LightningView(new LightningLevelModel(dataFile, levelNum));
                break;
            case "Theme":
                lv = new ThemeView(new ThemeLevelModel(dataFile, levelNum));
                break;
            case "Puzzle":
                lv = new PuzzleView(new PuzzleLevelModel(dataFile, levelNum));
                break;
        }

        // Closes the builder window and opens the level view
        lv.setVisible(true);
        bw.setVisible(false);
        bw.dispose();

    }
}
