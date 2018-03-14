package background;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	Image background;

	public MyPanel() {
		
		// Afbeelding inladen met een foutmelding als het pad onjuist is.
		try {
			background = ImageIO.read(new File("assets/images/goat.jpg"));
		} catch (IOException e) {
			System.out.println("Fout bij het laden van de voorgrond afbeelding. " + e.getMessage());
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Teken de achtergrond afbeelding
		g.drawImage(background, 0, 0, this);
	}
}
