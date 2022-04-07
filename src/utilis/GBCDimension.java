package utilis;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBCDimension {
	public static GridBagConstraints setDimension(int gridx) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridx;
		return gbc;
	}

	public static GridBagConstraints setDimension(int gridx, int gridy) {
		GridBagConstraints gbc = GBCDimension.setDimension(gridx);
		gbc.gridy = gridy;
		return gbc;
	}

	public static GridBagConstraints setDimension(int gridx, int gridy, int ipadx) {
		GridBagConstraints gbc = GBCDimension.setDimension(gridx, gridy);
		gbc.ipadx = ipadx;
		return gbc;
	}

	public static GridBagConstraints setDimension(int gridx, int gridy, int ipadx, int ipady) {
		GridBagConstraints gbc = GBCDimension.setDimension(gridx, gridy, ipadx);
		gbc.ipady = ipady;
		return gbc;
	}

	public static GridBagConstraints setDimension(int gridx, int gridy, int ipadx, int ipady, Insets insets) {
		GridBagConstraints gbc = GBCDimension.setDimension(gridx, gridy, ipadx, ipady);
		gbc.insets = insets;
		return gbc;
	}

}
