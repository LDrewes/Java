package background;

import javax.swing.JFrame;

public class Demo {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(648, 365);
		frame.setTitle("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new MyPanel());
		frame.setVisible(true);

	}

}