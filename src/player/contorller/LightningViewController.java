package player.contorller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import player.model.LightningLevel;
import player.model.Square;
import player.view.JBoardView;
import player.view.JSquareView;
import player.view.LightningView;

/**
 * Controller for Lightning View.
 * <p>
 * Introduction:
 * It handle all buttons on Lightning View.
 * It shows the changes on Lightning View and update the data in
 * entity classes.
 * @author zluo2
 *
 */
public class LightningViewController implements ActionListener {

	protected JBoardView bv;
	protected LightningView lv;
	private ArrayList<JSquareView> sv = new ArrayList<JSquareView>();
	private ArrayList<String> str;
	private LightningLevel level;

	/**
	 * Contructor for LightningView.
	 * @param lv
	 * @param level
	 */
	public LightningViewController(LightningView lv, LightningLevel level) {
		this.bv = lv.board;
		this.lv = lv;
		this.level = level;
		this.sv = bv.selectedsqv;
		this.str = bv.str;
	}
	
	/**
	 * Handle the sumit button, resetboard.
	 * @param e actinevent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("SUBMIT"))
		{
			for(JSquareView sqv: sv) 
			{
				sqv.setBackground(Color.orange);
			}

			String listString = "";

			if(isConnect()) 
			{
				for (String s : str)
				{
					listString += s;
				}
			}
			str.clear();
			if(level.inWordTable(listString)&&listString.length()>2)
			{
				level.solvedWords.add(listString);
				level.score = level.countScore(listString);
				lv.score.setText("SCORE:"+level.score);

				//Display flow up;
				bv.removeAll();
				for(JSquareView sqv: sv){
					sqv.square.setLetter(null);;
				}
				flowup();
				sv.clear();
				level.board.assignLetterToNullSquares();
				bv.init();
				bv.revalidate();
				bv.repaint();
				//Change star pictures
				changeIcon();
				//Add string to selected words
				ArrayList<String> str = new ArrayList<String>();
				str.add(listString);
				lv.model.addElement(str);
			}
			else 
			{
				str.clear();
				sv.clear();
			}
		} 
		else if (e.getActionCommand().equals("RESET BOARD"))
		{
			for(JSquareView sqv: sv) 
			{
				sqv.setBackground(Color.orange);

			}
			str.clear();
			sv.clear();

			bv.removeAll();
			bv.board.assignLetterToAllSquares();
			bv.init();
			bv.revalidate();
			bv.repaint();
			level.solvedWords.clear();
			level.score = 0;
			lv.score.setText("SCORE:" +level.score);	
			changeIcon();
			lv.model.clear();
			ArrayList<String> str = new ArrayList<String>();
			str.add("Selected Word:");
			lv.model.addElement(str);
		}
		else return;
	}
	/**
	 * Check the selected squares are all connected.
	 * @return boolean
	 */
	public boolean isConnect() {
		int dis=0, dis2=0;
		for(int i=0; i<sv.size()-1;i++)
		{
			int row1 = sv.get(i).square.getRow();
			int col1 = sv.get(i).square.getColumn();
			int row2 = sv.get(i+1).square.getRow();
			int col2 = sv.get(i+1).square.getColumn();
			dis = Math.abs(row1 - row2);
			dis2 = Math.abs(col1 - col2);
			if(dis>1||dis2>1)
			{
				return false;
			} 
		}
		return true;
	}
	/**
	 * Change the stars based on the current score.
	 * 
	 */
	public void changeIcon() {

		if(level.isPassed())
		{
			int scale = 7;
			ImageIcon hightlightstar = new ImageIcon("src/img/star2.png");
			int width = hightlightstar.getIconWidth();
			int newWidth = width/ scale;
			int height = hightlightstar.getIconWidth();
			int newHeight = height/ scale;
			lv.firstStar.setIcon(new ImageIcon(hightlightstar.getImage().getScaledInstance(newWidth, newHeight,
					java.awt.Image.SCALE_SMOOTH)));
			if(level.score >=level.record.twoStars)
			{
				lv.secondStar.setIcon(new ImageIcon(hightlightstar.getImage().getScaledInstance(newWidth, newHeight,
						java.awt.Image.SCALE_SMOOTH)));
				if(level.score >=level.record.threeStars)
				{
					lv.thirdStar.setIcon(new ImageIcon(hightlightstar.getImage().getScaledInstance(newWidth, newHeight,
							java.awt.Image.SCALE_SMOOTH)));
				}
			} 
		} 
		else {
			ImageIcon star = new ImageIcon("src/img/star.png");
			lv.firstStar.setIcon(star);
			lv.secondStar.setIcon(star);
			lv.thirdStar.setIcon(star);
		}
	}
	/**
	 * Flow up the letters to fill the selected word.
	 */
	public void flowup() {
		for(JSquareView actsqv: sv){
			int row = actsqv.square.getRow();
			int col = actsqv.square.getColumn();
			Square nextsq;
			Square presq;
			while(row<=5) {
				presq = level.board.getSquare(row, col);
				row++;
				nextsq = level.board.getSquare(row, col);
				if(nextsq!=null&&presq!=null){
					if(nextsq.getLetter() != null){
						level.board.getSquare(row-1,col).setLetter(nextsq.getLetter());
						nextsq.setLetter(null);
					}
				}
			}
		}
	}
}


