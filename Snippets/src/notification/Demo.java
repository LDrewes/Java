package notification;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.File;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

public class Demo {

	public static void main(String[] args) throws AWTException, MalformedURLException {
		if (SystemTray.isSupported()) {
			Demo td = new Demo();
			td.displayTray();
		} else {
			System.err.println("System tray not supported!");
		}
	}

	public void displayTray() throws AWTException, MalformedURLException {
		
		// Obtain only one instance of the SystemTray object
		SystemTray tray = SystemTray.getSystemTray();

		try {
			Image image = ImageIO.read(new File("assets/images/cat.png"));
			TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		
			// Let the system resize the image if needed
			trayIcon.setImageAutoSize(true);
			
			// Set tooltip text for the tray icon
			trayIcon.setToolTip("System tray icon demo");
			tray.add(trayIcon);
			trayIcon.displayMessage("Hi...", "Notification demo", MessageType.INFO);
		} catch (Exception e) {
			System.out.println("Couldn't find icon file: " + e.getMessage());
		}

	}
}
