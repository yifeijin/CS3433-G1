package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Theme level model.
 *
 * Model for theme level.
 */
public class ThemeLevelModel extends LevelModel {

    String theme;
    String answers;

    /**
     * Constructor.
     *
     * @param dataFile           data file for this level
     * @param currentLevelNumber current level number
     */
    public ThemeLevelModel(File dataFile, int currentLevelNumber) {
        super(dataFile, currentLevelNumber);
    }

    /**
     * Complements the abstract class.
     * <p>
     * Sets the theme and answers field from the data file.
     */
    @Override
    public void levelInit() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/" + dataFile.getName()));

            for (int i = 0; i < 12; i++) {
                br.readLine();
            }

            theme = br.readLine();
            answers = br.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
