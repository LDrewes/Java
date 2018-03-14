package keylistener;

/**
 * KeyListener: http://www.java2s.com/Code/JavaAPI/javax.swing/JPaneladdKeyListenerKeyListenerl.htm
 * 
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	JLabel player;

	public MyPanel() {
		this.setLayout(null);
		player = new JLabel("<< >>");
		player.setBorder(BorderFactory.createLineBorder(Color.black));
		player.setHorizontalAlignment(JLabel.CENTER);
		player.setOpaque(true);
		player.setBackground(Color.YELLOW);
		player.setBounds(250, 250, 50, 50);
		add(player);

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

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// ...
		}

	}

}
