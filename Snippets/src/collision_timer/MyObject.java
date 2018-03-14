package collision_timer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyObject extends JLabel {

	Timer timer;
	JLabel player;
	
	public MyObject(String label) {
		super(label);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		
		timer = new Timer(100, new TimerHandler());
		timer.start();
	}
	
	class TimerHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (checkCollision()) {
				setBackground(Color.RED);
				player.setBackground(Color.RED);
			} else {
				setBackground(Color.YELLOW);
				player.setBackground(Color.WHITE);
			}
		}
	}
	

	
	/**
	 * Methode om de overlap te bepalen
	 * 
	 * @return
	 */
	public boolean checkCollision() {
		
		if (player == null) {
			player = ((MyPanel) this.getParent()).getPlayer();
		}
		
		// Horizontaal
		if (this.getX() < player.getX() + player.getWidth() && this.getX() + this.getWidth() > player.getX()) {
			System.out.println("Horizontale overlap.");

			// Verticaal
			if (this.getY() < player.getY() + player.getHeight() && this.getY() + this.getHeight() > player.getY()) {
				System.out.println("En verticale overlap.");
				return true;
			}
		}
		return false;
	}
	
}
