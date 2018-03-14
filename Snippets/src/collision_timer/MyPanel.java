package collision_timer;

/**
 * Overlap bepalen in een controller klasse.
 * 
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private JLabel player;
	private MyObject target;

	public MyPanel() {
		this.setLayout(null);

		// Player object
		player = new JLabel("<< >>");
		player.setBorder(BorderFactory.createLineBorder(Color.black));
		player.setHorizontalAlignment(JLabel.CENTER);
		player.setBounds(310, 310, 50, 50);
		player.setOpaque(true);
		player.setBackground(Color.WHITE);
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
	 * Getter voor de player
	 * @return
	 */
	public JLabel getPlayer() {
		return player;
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
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// ...
		}

	}

}
