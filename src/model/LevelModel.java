package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Level model object.
 * <p>
 * Abstract class for all the level models.
 */
public abstract class LevelModel {

    File dataFile;          // use default when create new. pass in from EditLevelButtonController when edit.
    int currentLevelNumber; // pass in from EnterLevelController when create new. Useless when edit.
    int oneStar;
    int twoStar;
    int threeStar;

    /**
     * Constructor.
     *
     * @param dataFile           The file contains all the data about the level
     * @param currentLevelNumber The number of level this level has
     */
    public LevelModel(File dataFile, int currentLevelNumber) {
        this.currentLevelNumber = currentLevelNumber;
        this.dataFile = dataFile;
        init();
        levelInit();
    }

    /**
     * Initializes the level model.
     * <p>
     * Gets the star information from the data file and stores in the fields.
     */
    public void init() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data/" + dataFile.getName()));

            for (int i = 0; i < 7; i++) {
                br.readLine();
            }

            String one = br.readLine();
            String two = br.readLine();
            String three = br.readLine();

            oneStar = Integer.parseInt(one);
            twoStar = Integer.parseInt(two);
            threeStar = Integer.parseInt(three);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Abstract class for specific level Initialization.
     */
    public abstract void levelInit();

    /**
     * @return Data file
     */
    public File getDataFile() {
        return dataFile;
    }

    /**
     * @return Current level number
     */
    public int getCurrentLevelNumber() {
        return currentLevelNumber;
    }

    /**
     * @return One star number
     */
    public int getOneStar() {
        return oneStar;
    }

    /**
     * @return two star number
     */
    public int getTwoStar() {
        return twoStar;
    }

    /**
     * @return three star number
     */
    public int getThreeStar() {
        return threeStar;
    }
}
