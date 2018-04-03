package shell_output;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;


/**
 * Voorbeeld om de output van een bat bestand 
 * te tonen in een JTextArea
 *
 */
public class Demo {

	MyPanel panel;
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.execute();
	}
	
	public Demo() {
		
		panel = new MyPanel();
		
		JFrame myFrame = new JFrame();
		myFrame.setSize(600, 600);
		myFrame.setContentPane(panel);
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Voer een shell script uit (kan ook .bat zijn) 
	 * en toon de output in de console en in het tekstveld.
	 */
	public void execute() {
		
		String batFile = "assets/scripts/time.sh";

		try {
			ProcessBuilder procBuild = new ProcessBuilder(batFile);
			Process proc = procBuild.start();
			InputStream streamIn = proc.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(streamIn));
			
			String batOutput = null;
			while ((batOutput = br.readLine()) != null) {
				// Schrijf naar de console
				System.out.println(batOutput);
				// Schrijf naar het tekstveld in het paneel
				panel.setOutput(batOutput);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
