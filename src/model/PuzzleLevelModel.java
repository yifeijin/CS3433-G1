package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Puzzle Level Model.
 *
 * Model for puzzle level.
 */
public class PuzzleLevelModel extends LevelModel {

    int maxMove;

    /**
     * Constructor.
     *
     * @param dataFile           Data file for the level model
     * @param currentLevelNumber Current level number
     */
    public PuzzleLevelModel(File dataFile, int currentLevelNumber) {
        super(dataFile, currentLevelNumber);
    }

    /**
     * Complements the abstract class.
     * <p>
     * Sets the max move field from datafile.
     */
    @Override
    public void levelInit() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/" + dataFile.getName()));

            for (int i = 0; i < 10; i++) {
                br.readLine();
            }

            maxMove = Integer.parseInt(br.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
