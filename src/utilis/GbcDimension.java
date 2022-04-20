package utilis;

import java.awt.GridBagConstraints;
import java.awt.Insets;
/**
 * 
 * Class to simplify the usage of the GridBagConstraints, adding more constructor
 *
 */
public class GbcDimension extends GridBagConstraints {

	private static final long serialVersionUID = -6983927223360889689L;

	/**
	 * {@inheritDoc}
	 */
	public GbcDimension(int gridx) {
		super();
		this.gridx = gridx;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public GbcDimension(int gridx, int gridy) {
		super();
		this.gridx = gridx;
		this.gridy = gridy;
	}

	/**
	 * {@inheritDoc}
	 */
	public GbcDimension(int gridx, int gridy, int ipadx) {
		super();
		this.gridx = gridx;
		this.gridy = gridy;
		this.ipadx = ipadx;
	}

	/**
	 * {@inheritDoc}
	 */
	public GbcDimension(int gridx, int gridy, int ipadx, int ipady) {
		super();
		this.gridx = gridx;
		this.gridy = gridy;
		this.ipadx = ipadx;
		this.ipady = ipady;
	}

	/**
	 * {@inheritDoc}
	 */
	public GbcDimension(int gridx, int gridy, int ipadx, int ipady, Insets insets) {
		super();
		this.gridx = gridx;
		this.gridy = gridy;
		this.ipadx = ipadx;
		this.ipady = ipady;
		this.insets = insets;
	}

}
