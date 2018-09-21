package player.view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import player.contorller.LevelViewController;
import player.model.Board;
import player.model.Square;


/**
 * This class display a view for board
 * @author mxu2, zluo2
 */
public class JBoardView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 374398209794328382L;
	public Board board;
	public ArrayList<Square> squares = new ArrayList<Square>();
	public ArrayList<JSquareView> squareViews = new ArrayList<JSquareView>();
	public ArrayList<JSquareView> activesquares = new ArrayList<JSquareView>();
	public ArrayList<JSquareView> selectedsqv  = new ArrayList<JSquareView>();

	public ArrayList<String> str = new ArrayList<String>();

	/**
	 * JBoardView Constructor.
	 * @param board
	 */
	public JBoardView(Board board){
		this.board = board;
		board.assignLetterToNullSquares();
		this.squares = board.squares;
		Color navy = new Color(65, 105, 225);
		this.setBackground(navy);
		init();
	}

	/**
	 * Layout the JSuqareViews in assigned shape.
	 */
	public void init(){	
		this.setLayout(null);
		int k=0;
		for (int j = 0; j <=5; j++) {
			for (int i = 0; i <=5; i++) {
				Square sq = squares.get(k);
				JSquareView sqv;
				if(sq != null) {
					sqv = new JSquareView(sq,Color.orange);
					activesquares.add(sqv);
				} else {
					sqv = new JSquareView(sq,new Color(0,0,0,0) );
				}
				squareViews.add(k, sqv);
				sqv.setBounds(25 + i*80, 45 + j*80, 75, 75);
				this.add(sqv);
				k++;
			}		
		}
		for(JSquareView sqv: this.activesquares)
		{
			sqv.addMouseListener(new LevelViewController(this,sqv));
		}
	}
}
