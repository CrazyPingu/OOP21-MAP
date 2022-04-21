package view.game;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import view.game.central.GameArea;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = 3295995931719233232L;

	public TopPanel() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
//		Log log = new Log();
//		this.add(log, new GbcDimension(0, 0, Constant.WIDTH / 5, 2 * Constant.HEIGHT / 3));
		
		GameArea gameArea = new GameArea();
		
//		Stats stats = new stats();
//		this.add(log, new GbcDimension(2, 0, Constant.WIDTH / 5, 2 * Constant.HEIGHT / 3));		
	}

}
