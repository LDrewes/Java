package collision_object;

/**
 * Overlap bepalen in een controller klasse.
 * 
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	MyObject player;
	MyObject target;

	public MyPanel() {
		this.setLayout(null);
		
		// Player object
		player = new MyObject("<< >>");
		player.setBounds(310, 310, 50, 50);
		add(player);

		// Target om te raken
		target = new MyObject("HIT ME!");
		target.setBounds(250, 250, 50, 50);
		target.setBackground(Color.GREEN);
		add(target);

		// Zorg dat het panel de focus kan krijgen om te luisteren.
		this.setFocusable(true);
		this.addKeyListener(new KeyHandler());

	}

	

	/**
	 * Inner class voor de keyListener
	 * 
	 * @author drewes
	 *
	 */
	class KeyHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// ...
		}

		@Override
		public void keyPressed(KeyEvent e) {

			int keyCode = e.getKeyCode();

			int x = (int) player.getX();
			int y = (int) player.getY();

			if (keyCode == KeyEvent.VK_RIGHT) {
				player.setBounds(x + 5, y, 50, 50);
			} else if (keyCode == KeyEvent.VK_LEFT) {
				player.setBounds(x - 5, y, 50, 50);
			} else if (keyCode == KeyEvent.VK_UP) {
				player.setBounds(x, y - 5, 50, 50);
			} else if (keyCode == KeyEvent.VK_DOWN) {
				player.setBounds(x, y + 5, 50, 50);
			}

			player.checkCollision(target);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// ...
		}

	}

}
