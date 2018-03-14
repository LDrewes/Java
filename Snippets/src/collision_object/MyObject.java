package collision_object;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class MyObject extends JLabel {

	public MyObject(String label) {
		super(label);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
	}
	
	/**
	 * Methode om de overlap te bepalen
	 * 
	 * @return
	 */
	public boolean checkCollision(MyObject compare) {

		// Horizontaal
		if (this.getX() < compare.getX() + compare.getWidth() && this.getX() + this.getWidth() > compare.getX()) {
			System.out.println("Horizontale overlap.");

			// Verticaal
			if (this.getY() < compare.getY() + compare.getHeight() && this.getY() + this.getHeight() > compare.getY()) {
				System.out.println("Verticale overlap.");
				this.setBackground(Color.RED);
				return true;
			}
		}
		return false;
	}
	
}
