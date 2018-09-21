package controller;

import model.PuzzleLevelModel;
import view.BuilderWindow;
import view.PuzzleView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Create new puzzle controller.
 * <p>
 * Creates a new puzzle level.
 */
public class CreateNewPuzzleController implements ActionListener {

    private BuilderWindow bw;

    /**
     * Constructor.
     *
     * @param bw builder window to be closed
     */
    public CreateNewPuzzleController(BuilderWindow bw) {
        this.bw = bw;
    }

    /**
     * Creates a new Puzzle view and the dataFile. If there are already 15 levels, a message dialog
     * will pop up.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int currentLevelNum = bw.getBuilderModel().getCurrentLevelNumber();
        File defaultSetting = new File("data/level" + (currentLevelNum + 1) + ".txt");
        File defaultFile = new File("data/PuzzleDefault.txt");
        File tmpFile = new File("data/tmp.txt");

        if (currentLevelNum + 1 > 15) {
            JOptionPane.showMessageDialog(null, "Max of 15 levels allowed", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Files.copy(defaultFile.toPath(), defaultSetting.toPath(), REPLACE_EXISTING);
            Files.copy(defaultFile.toPath(), tmpFile.toPath(), REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        PuzzleView lv = new PuzzleView(new PuzzleLevelModel(defaultSetting, currentLevelNum + 1));
        lv.setVisible(true);
        bw.setVisible(false);
        bw.dispose();
    }
}
