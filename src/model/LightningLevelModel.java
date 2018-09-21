package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Lightning level model object.
 * <p>
 * Contains all info about lightning level.
 */
public class LightningLevelModel extends LevelModel {

    int time;   // time required by the level

    /**
     * Constructor
     *
     * @param dataFile           Data file for the level model
     * @param currentLevelNumber level of current level
     */
    public LightningLevelModel(File dataFile, int currentLevelNumber) {
        super(dataFile, currentLevelNumber);
    }


    /**
     * Complements the abstract class.
     * <p>
     * Sets the time field from datafile.
     */
    @Override
    public void levelInit() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/" + dataFile.getName()));

            for (int i = 0; i < 11; i++) {
                br.readLine();
            }

            time = Integer.parseInt(br.readLine());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
