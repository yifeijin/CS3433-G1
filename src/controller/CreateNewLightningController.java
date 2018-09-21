package controller;

import model.LightningLevelModel;
import view.BuilderWindow;
import view.LightningView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Create new lightning controller.
 * <p>
 * Creates a new lightning view.
 */
public class CreateNewLightningController implements ActionListener {

    private BuilderWindow bw;

    /**
     * Constructor.
     *
     * @param bw builder window to be close
     */
    public CreateNewLightningController(BuilderWindow bw) {
        this.bw = bw;
    }

    /**
     * Creates a new lightning view and the dataFile. If there are already 15 levels, a message dialog
     * will pop up.
     *
     * @param e actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int currentLevelNum = bw.getBuilderModel().getCurrentLevelNumber();

        // Checks the number of datafiles already exist
        if (currentLevelNum + 1 > 15) {
            JOptionPane.showMessageDialog(null, "Max of 15 levels allowed", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File defaultSetting = new File("data/level" + (currentLevelNum + 1) + ".txt");
        File defaultFile = new File("data/LightningDefault.txt");
        File tmpFile = new File("data/tmp.txt");

        try {
            Files.copy(defaultFile.toPath(), defaultSetting.toPath(), REPLACE_EXISTING);
            Files.copy(defaultFile.toPath(), tmpFile.toPath(), REPLACE_EXISTING);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Closes the builder window and opens level view.
        LightningView lv = new LightningView(new LightningLevelModel(defaultSetting, currentLevelNum + 1));
        lv.setVisible(true);
        bw.setVisible(false);
        bw.dispose();
    }
}

