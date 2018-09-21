package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Builder model object.
 * <p>
 * Contains all the elements needed for builder window
 */
public class BuilderModel {

    private int currentLevelNumber;

    /**
     * Constructor.
     */
    public BuilderModel() {
        this.currentLevelNumber = getNumFiles();
    }

    /**
     * Checks the data file, and counts the number of level files exist.
     *
     * @return the number of datafiles, which is the current level number
     */
    public int getNumFiles() {
        int numFiles = 0;

        for (int i = 1; i <= 15; i++) {
            File dataFile = new File("data/level" + i + ".txt");
            if (dataFile.exists()) {
                numFiles++;
            }
        }

        return numFiles;
    }

    public int getNumFilesByType(String type) {
        BufferedReader br = null;
        int typeNum = 0;

        try {
            for (int i = 1; i <= currentLevelNumber; i++) {
                br = new BufferedReader(new FileReader("data/level" + i + ".txt"));
                for (int j = 0; j < 7; j++) {
                    if (br.readLine().equals(type)) {
                        typeNum++;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return typeNum;
    }

    /**
     * @return Current level number
     */
    public int getCurrentLevelNumber() {
        return currentLevelNumber;
    }

    /**
     * Only used in test case.
     *
     * @param levelNum level number to be set
     */
    public void setCurrentLevelNumber(int levelNum) {
        this.currentLevelNumber = levelNum;
    }
}
