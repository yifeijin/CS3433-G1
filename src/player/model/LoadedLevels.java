package player.model;

import java.util.ArrayList;

import player.contorller.LoadLevelController;

/**
 * Store the ArrayList of Levels that load from txt file.
 * @author zluo2
 *
 */
public class LoadedLevels {

	private ArrayList<Level> levels = new ArrayList<Level>();

	public LoadedLevels()
	{
		init();
	}
	/**
	 * Load and store levels
	 */
	private void init() {
		new LoadLevelController(getLevels());
	}
	/**
	 * Get a loaded level based on levelnum.
	 * @param levelnum
	 * @return level
	 */
	public Level getLevel(int levelnum) {
		Level lv = null;
		lv = getLevels().get(levelnum-1);
		return lv;
	}

	/**
	 * Get loaded levels.
	 * @return arraylist levels
	 */
	public ArrayList<Level> getLevels() {
		return levels;
	}
	/**
	 * Unlock the next level.
	 * @param levelnum
	 * @return booelan
	 */
	public boolean unlocklevels(int levelnum) {
		Level lv = null;
		Level nextlv = null;
		lv = getLevels().get(levelnum-1);
		if((lv.isPassed())&&(levelnum<=14)) {
			nextlv = getLevels().get(levelnum);
			nextlv.isLocked = false;
		}
		return true;
	}
}
