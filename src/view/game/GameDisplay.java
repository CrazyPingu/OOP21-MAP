package view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;


public class GameDisplay extends JPanel{


	private static final long serialVersionUID = 5038270668520802248L;
	public GameDisplay() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.black);
		JPanel top = new JPanel();
		top.setOpaque(false);
		JPanel action = new JPanel();
		action.setOpaque(false);
		
		this.add(top, BorderLayout.NORTH);
		this.add(action, BorderLayout.SOUTH);
	}
}
