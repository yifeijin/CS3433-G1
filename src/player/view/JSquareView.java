package player.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import player.model.Square;


/**
 * represent a square view object
 * @author mxu2,zluo2
 */

public class JSquareView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3587290736161600557L;
	public Square square;
	protected JLabel letters;
	Color color;
	
	/**
	 * JSquareView Constructor.
	 * @param square
	 * @param color
	 */
	public JSquareView(Square square, Color color){
		this.square = square;
		this.color = color;
		this.setBackground(color);
		addLetter();
	}
	/**
	 * add a letter to a square.
	 */
	public void addLetter() {
		if(square != null) {
			String s = square.getLetter();
				letters = new JLabel(s);
				letters.setFont(new Font("Garamond", Font.PLAIN, 60));
				this.add(letters);
		}	
	}

	/**
	 * draw square
	 */
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawRect(0,0, 75, 75);
	}
}

