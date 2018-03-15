package movement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyObject extends JLabel {

	Timer timer;
	int id;

	public MyObject(int id) {

		super(String.valueOf(id));

		this.id = id;

		this.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setBounds(275, 10, 50, 50);
		
		timer = new Timer(10, new MoveHandler());
		timer.start();
	}

	private void moveDown() {
		//System.out.println("...move down ("+id+")");
		this.setBounds(getX(), getY() + 1, 50, 50);
		
		if (this.getY() > 100) {
			System.out.println("Te laag > verwijder het object");
			timer.stop();
			((MyPanel) this.getParent()).removeObject(this);
		}
	}

	class MoveHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			moveDown();
		}
	}
	
	@Override
	public String toString() {
		return "MyObject " + id;
	}

}
