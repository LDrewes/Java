package icon;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Voorbeeld voor het gebruiken van een image icon in een JButton.
 * Op dezelfde manier kun je een icon gebruiken in bijvoorbeeld een JLabel
 * @author drewes
 *
 */
public class MyPanel extends JPanel {

	JButton button;
	String path = "assets/images/cat.png";

	public MyPanel() {
		button = new JButton();
		
		// Afbeelding inladen met foutafhandeling
		try {
			Image img = ImageIO.read(new File(path));
			button.setIcon(new ImageIcon(img));
		} catch (Exception e) {
			System.out.println("Couldn't find file: " + path + ", " + e.getMessage());
		}

		// Padding
		button.setMargin(new Insets(10, 10, 10, 10));
		// Geen achtergrond
		button.setBackground(Color.CYAN);
		// Geen border
		button.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// ActionListener
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Miauw!");				
			}
		});
		
		// Voeg de button toe aan het JPanel
		add(button);
	}

}
