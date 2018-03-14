package movement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel {

	MyObject car;
	Timer timer;
	int counter;

	public MyPanel() {
		
		this.setLayout(null);
		
		timer = new Timer(2000, new AddCarTimerHandler());
		timer.start();
	}

	class AddCarTimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			add(new MyObject(++counter));
			System.out.println("Komt-ie! ("+counter+")");
		}
	}

}
