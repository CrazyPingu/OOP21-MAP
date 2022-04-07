package utilis;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GbcDimension extends GridBagConstraints {

	private static final long serialVersionUID = -6983927223360889689L;

	public GbcDimension(int gridx) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
	}

	public GbcDimension(int gridx, int gridy) {
		GridBagConstraints gbc = new GbcDimension(gridx);
		gbc.gridy = gridy;
	}

	public GbcDimension(int gridx, int gridy, int ipadx) {
		GridBagConstraints gbc = new GbcDimension(gridx, gridy);
		gbc.ipadx = ipadx;
	}

	public GbcDimension(int gridx, int gridy, int ipadx, int ipady) {
		GridBagConstraints gbc = new GbcDimension(gridx, gridy, ipadx);
		gbc.ipady = ipady;
	}

	public GbcDimension(int gridx, int gridy, int ipadx, int ipady, Insets insets) {
		GridBagConstraints gbc = new GbcDimension(gridx, gridy, ipadx, ipady);
		gbc.insets = insets;
	}

}
