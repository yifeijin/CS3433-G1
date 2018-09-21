package controller;

import model.ThemeLevelModel;
import view.BuilderWindow;
import view.ThemeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Create new theme controller.
 * <p>
 * Creates a new theme view.
 */
public class CreateNewThemeController implements ActionListener {

    private BuilderWindow bw;

    /**
     * Constructor.
     *
     * @param bw builder window to be closed.
     */
    public CreateNewThemeController(BuilderWindow bw) {
        this.bw = bw;
    }

    /**
     * Creates a new theme view and the dataFile. If there are already 15 levels, a message dialog
     * will pop up.
     *
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int currentLevelNum = bw.getBuilderModel().getCurrentLevelNumber();

        File defaultSetting = new File("data/level" + (currentLevelNum + 1) + ".txt");
        File defaultFile = new File("data/ThemeDefault.txt");
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

        ThemeView lv = new ThemeView(new ThemeLevelModel(defaultSetting, currentLevelNum + 1));
        lv.setVisible(true);
        bw.setVisible(false);
        bw.dispose();
    }

}
