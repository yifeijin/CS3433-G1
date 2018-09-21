package player.contorller;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.lang.Math;
import player.model.Level;
import player.model.Square;
import player.view.JBoardView;
import player.view.JSquareView;
import player.view.LevelView;

/**
 * Controller on general buttons for all three type of levels.
 * <p>
 * Introduction:
 * It handle the word select for all three levels. In addition,
 * it also contains the controller for all buttons on puzzle level.
 * @author zluo2
 *
 */
public class LevelViewController extends MouseAdapter implements ActionListener{

	protected JBoardView bv;
	protected LevelView lv;
	private ArrayList<JSquareView> sv = new ArrayList<JSquareView>();
	private JSquareView sqv;
	private ArrayList<String> str;
	private Level level;
	private ArrayList<String> stage;

	/**
	 * One version of constructor for LevelViewController.
	 * @param lv
	 * @param level
	 */
	public LevelViewController(LevelView lv, Level level) {
		this.bv = lv.board; 
		this.lv = lv;
		this.level = level; 
		this.sv = bv.selectedsqv;
		this.str = bv.str;
	}
	/**
	 * One version of constructor for LevelViewController.
	 * @param bv
	 * @param sqv
	 */
	public LevelViewController(JBoardView bv, JSquareView sqv) {
		this.bv = bv;
		this.sqv = sqv;
		this.sv = bv.selectedsqv;
		this.str = bv.str;
	}

	/**
	 * Moseadapter on JSquareViews.
	 * <p>
	 * Allow mouse click on All active JSquareViews.
	 * It will hightlight the selected suqares and store the
	 * selected squares.
	 * @param bv
	 * @param sqv
	 */
	public void mouseClicked(MouseEvent event)
	{	
		if (event.getButton() == MouseEvent.BUTTON1 )
		{
			if(sqv.getBackground()==Color.orange)
			{
				sqv.setBackground(Color.green);
				str.add(sqv.square.getLetter());
				sv.add(sqv);
			} else if(sqv.getBackground()==Color.green)
			{
				sqv.setBackground(Color.orange);
				str.remove(sqv.square.getLetter());
				sv.remove(sqv);   
			}		
		}
	}

	/**
	 * Contoller for all buttons on puzzle view.
	 * <p>
	 * Handle submit a word, undo a move and reset board.
	 * It also updates the score.
	 * @param e actionevent
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int usedmoves = level.getusedmove();
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
				level.stages.add(level.board.getLetters());
				// increase used moves
				level.solvedWords.add(listString);
				usedmoves++;
				int maxmoves = level.getmaxmove();
				if(usedmoves >= maxmoves) {
					level.setusedmove(level.getmaxmove());
					lv.submit.setEnabled(false);
				} else {
					level.setusedmove(usedmoves);
				}
				//Display new num of used moves
				lv.setMovesLeft("MOVES LEFT:"+(maxmoves-usedmoves));
				// Record and display new score
				level.score += level.countScore(listString);
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
			level.stages.clear();
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
			lv.score.setText("SCORE: " +level.score);	
			changeIcon();
			lv.model.clear();
			ArrayList<String> str = new ArrayList<String>();
			str.add("Selected Word:");
			lv.model.addElement(str);
			level.setusedmove(0);
			lv.setMovesLeft("MOVES LEFT: "+level.getmaxmove());
		}
		else if (e.getActionCommand().equals("UNDO"))
		{
			for(JSquareView sqv: sv) 
			{
				sqv.setBackground(Color.orange);

			}
			if(lv.model.size()>1) {		
				String listString = "";
				for (String s : lv.model.getElementAt(lv.model.size()-1))
				{
					listString += s;
				}
				level.solvedWords.remove(listString);
				str.clear();
				sv.clear();	
				level.score = level.score - level.countScore(listString);
				lv.model.remove(lv.model.size()-1);
				lv.score.setText("SCORE:"+level.score);
				changeIcon();
				level.setusedmove(level.getusedmove()-1);
				lv.setMovesLeft("MOVES LEFT:"+ (level.getmaxmove()-level.getusedmove()));
				if(!(lv.submit.isEnabled())) {
					lv.submit.setEnabled(true);
				}
				stage = level.stages.get(level.stages.size()-1);
				bv.removeAll();
				bv.board.assignGivenLetters(stage);
				level.stages.remove(level.stages.size()-1);
				bv.init();
				bv.revalidate();
				bv.repaint();
			}
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
			if(level.score >level.record.twoStars)
			{
				lv.secondStar.setIcon(new ImageIcon(hightlightstar.getImage().getScaledInstance(newWidth, newHeight,
						java.awt.Image.SCALE_SMOOTH)));
				if(level.score >level.record.threeStars)
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
		for(JSquareView sqv: sv){
			int row = sqv.square.getRow();
			int col = sqv.square.getColumn();
			int inactive_count = 0;
			while(row<=4&&row>=0)
			{
				Square sq = bv.board.getSquare(row, col);
				Square nextsq = bv.board.getSquare(row+1, col);
				if(nextsq == null)
				{
					inactive_count++;
				}
				else if(nextsq != null)
				{
					if(nextsq.getLetter()!=null) {
						if(inactive_count>0)
						{
							bv.board.getSquare(row-(inactive_count+1), col).setLetter(nextsq.getLetter());
							nextsq.setLetter(null);
						}
						else if(inactive_count==0)
						{
							sq.setLetter(nextsq.getLetter());
							nextsq.setLetter(null);
						}
					}
				}
				row++;
			}
		}
	}
}




