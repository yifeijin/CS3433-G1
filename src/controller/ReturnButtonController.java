package controller;

import model.BuilderModel;
import view.BuilderWindow;
import view.LevelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Controller object for the return button.
 * <p>
 * Returns back to window builder without saving.
 */
public class ReturnButtonController implements ActionListener {

    private LevelView lv;

    /**
     * Constructor.
     *
     * @param lv Level view to quit.
     */
    public ReturnButtonController(LevelView lv) {
        this.lv = lv;
    }

    /**
     * Returns back to window builder without saving.
     * <p>
     * Deletes all the tmp files about the level, and keep the original data.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // delete the board.txt and set original temporary copy as board.txt
        int currentLevelNum = lv.getModel().getCurrentLevelNumber();
        String dataFileName = "data/level" + currentLevelNum + ".txt";
        File dataFile = new File(dataFileName);
        File tmpFile = new File("data/tmp.txt");

        BufferedReader br;
        String type = "";

        try {
            br = new BufferedReader(new FileReader(dataFileName));
            for (int i = 0; i < 7; i++) {
                type = br.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		/*
         * If the dataFile is the same as the default file, which means it is a
		 * newly created file, then deletes both the dataFile and the tmpFile.
		 */
        File puzzleDefaultFile = new File("data/PuzzleDefault.txt");
        File themeDefaultFile = new File("data/ThemeDefault.txt");
        File LightningDefaultFile = new File("data/LightningDefault.txt");
        byte[] puzzleByte = null;
        byte[] themeByte = null;
        byte[] lightningByte = null;
        byte[] dataFileByte = null;
        try {
            puzzleByte = Files.readAllBytes(puzzleDefaultFile.toPath());
            themeByte = Files.readAllBytes(themeDefaultFile.toPath());
            lightningByte = Files.readAllBytes(LightningDefaultFile.toPath());
            dataFileByte = Files.readAllBytes(dataFile.toPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Compares default setting and data file.
        if ((type.equals("Puzzle") && Arrays.equals(puzzleByte, dataFileByte))
                || (type.equals("Theme") && Arrays.equals(themeByte, dataFileByte))
                || (type.equals("Lightning") && Arrays.equals(lightningByte, dataFileByte))) {
            dataFile.delete();
            tmpFile.delete();

            BuilderWindow bw = new BuilderWindow(new BuilderModel());
            bw.setVisible(true);
            lv.setVisible(false);
            lv.dispose();
            return;
        }

        // Replaces datafile with tmpFile
        dataFile.delete();
        tmpFile.renameTo(dataFile);

        // Closes the level view and reopens the builder window
        BuilderWindow builderWindow = new BuilderWindow(new BuilderModel());
        builderWindow.setVisible(true);
        lv.setVisible(false);
        lv.dispose();
    }
}
