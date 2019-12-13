

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Models a Cell in the game of Tic Tac Toe
 * @author kabaram
 *
 */
public class Cell extends JButton {
	// the value of this cell: 0 - unused, 1 - X, 2 - O
	private int value;


	/**
	 * Initializes an unoccupied cell.
	 */
	public Cell() {
		value = 0;
		setBackground(Color.GREEN);
	}
	
	/**
	 * Changes the value and picture on this cell after being clicked.
	 * @param v the new value of this cell
	 */
	public void setValue(int v) {
		value = v;
		if (value == 1) {
			setBackground(Color.RED);
		}
		else {
			setBackground(Color.YELLOW);
		}
	}
	
	/**
	 * @return the value of this cell.
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Resets this cell to 0 and removes picture
	 */
	public void reset() {
		value = 0;
		setIcon(null);
		setEnabled(true);
	}
	
	/**
	 * Returns true if this cell's value matches other cell's value
	 */
	public boolean equals(Cell other) {
		return this.value == other.value;
	}

}
