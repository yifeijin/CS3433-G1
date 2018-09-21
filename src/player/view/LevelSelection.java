package player.view;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import player.model.Level;
import player.model.LoadedLevels;

public class LevelSelection extends JPanel {

	/**
	 * This class display the fifteen level buttons.
	 * @author zluo2, mxu2
	 */
	private static final long serialVersionUID = -2552355963865670826L;

	public LoadedLevels loadlv = new LoadedLevels();
	public ArrayList<Level> levels = loadlv.getLevels();
	public JButton[] levelbutton = new JButton[15];
	protected int scale = 3;

	/**
	 * Display correct ImageIcon for all levels.
	 * @return boardpane JPanel
	 */
	protected JPanel displayLevelselection() {
		JPanel boardpane = new JPanel();
		for (int i=0; i<15; i++) {
			this.loadlv.unlocklevels(i+1);
			ImageIcon levelview;
			Level templevel;
			levelbutton[i] = new JButton();
			levelbutton[i].setActionCommand("level" + (i+1));
			templevel = levels.get(i);
			levelview = setIcon(templevel);
			setScaledIcon(levelbutton[i], scale, levelview);
			boardpane.add(levelbutton[i]);
		} 
		return boardpane;
	}

	/**Set a scaled icon to the JButton.
	 * @param button
	 * @param scale
	 * @param img
	 */
	private void setScaledIcon(JButton button, int scale, ImageIcon img) {
		int width = img.getIconWidth();
		int newWidth = width/ scale;
		int height = img.getIconHeight();
		int newHeight = height/ scale;
		button.setIcon(new ImageIcon(img.getImage().getScaledInstance(newWidth, newHeight,
				java.awt.Image.SCALE_SMOOTH)));
	}
	/**
	 * Generate ImageIcon based on whether the level is locked.
	 * @param Level l
	 * @return ImageIcon
	 */
	public ImageIcon setIcon(Level l) {
		ImageIcon levelview = null;
		if (l.isLocked) {
			levelview = new ImageIcon("src/img/locklevel" + l.levelNumber+ ".png");
		} else if(!l.isLocked) {
			if((l.score == 0)||(l.score<l.record.pass) )
			{
				levelview = new ImageIcon("src/img/"+ l.levelNumber + "-0star.png");
			}else if(l.isPassed())
			{
				{
					levelview = new ImageIcon("src/img/"+ l.levelNumber+ "-1star.png");

					if(l.score >=l.record.twoStars)
					{
						levelview = new ImageIcon("src/img/"+ l.levelNumber+ "-2star.png");
						if(l.score >=l.record.threeStars)
						{
							levelview = new ImageIcon("src/img/"+ l.levelNumber+ "-3star.png");
						}
					}
				} 
			} 
		}
		return levelview;
	}
}