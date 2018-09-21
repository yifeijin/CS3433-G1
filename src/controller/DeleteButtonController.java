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

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/*
 * NEED TO DELETE THE LEVEL FILE AS WELL
 */

/**
 * Controller object for delete button.
 * <p>
 * Deletes the view, and resets all the files about the level
 */
public class DeleteButtonController implements ActionListener {

    private LevelView lv;

    /**
     * Constructor.
     *
     * @param lv Level view for the button
     */
    public DeleteButtonController(LevelView lv) {
        this.lv = lv;
    }

    /**
     * Deletes all the files about the level.
     * <p>
     * Deletes all the files. Closes the window and open the builder window.
     *
     * @param e ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Deletes all the files about the level and copies the default setting to data file.
        File thisDataFile = lv.getModel().getDataFile();
        String type = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/" + thisDataFile.getName()));
            int defaultIndex = 0;

            for (int i = 0; i < 7; i++) {
                type = br.readLine();
            }

            File DefaultSetting = new File("data/" + type + "Default.txt");
            Files.copy(DefaultSetting.toPath(), thisDataFile.toPath(), REPLACE_EXISTING);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        File tmpFile = new File("data/tmp.txt");
        tmpFile.delete();


        /*
         * If the level number is smaller than current total level number, all the
         * data files with level greater this level number should have level number
         * decrement one. First finds this data file's level number and current total
         * level number.
         */
        BuilderWindow bw = new BuilderWindow(new BuilderModel());
//        int totalLevelNum = bw.getBuilderModel().getCurrentLevelNumber();
//        int thisLevelNum = lv.getModel().getCurrentLevelNumber();
//
//        if (thisLevelNum < totalLevelNum + 1) {
//            for (int i = thisLevelNum; i <= totalLevelNum; i++) {
//                File renameTo = new File("data/level" + i + ".txt");
//                File renameFrom = new File("data/level" + (i + 1) + ".txt");
//                if (renameTo.exists())
//                    System.err.println("level" + i + ".txt already exists");
//                boolean success = renameFrom.renameTo(renameTo);
//                if (!success) {
//                    System.err.println("DeleteButtonController: Rename fails");
//                }
//            }
//        }

        // Finally close the builder window and open the level view.
        bw.setVisible(true);
        lv.setVisible(false);
        lv.dispose();
    }
}
