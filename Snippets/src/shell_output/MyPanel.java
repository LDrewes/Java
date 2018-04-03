package shell_output;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyPanel extends JPanel {

	private JTextArea tf;
	private JScrollPane scroll;

	public MyPanel() {

		tf = new JTextArea();
		scroll = new JScrollPane(tf, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tf.setPreferredSize(new Dimension(400, 200));
		tf.setMaximumSize(new Dimension(10000, 200));
		this.add(scroll);
	}
	
	public void setOutput(String message){
		tf.append(message);
		tf.append("\n");
	}
}
