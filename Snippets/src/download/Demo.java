package download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Downloading a file from the internet to the local file system.
 * 
 * @author drewes
 *
 */
public class Demo {

	public static void main(String[] args) throws IOException {
		InputStream in = null;
		FileOutputStream out = null;
		String path = "assets/downloads/";
		try {
			//URL url = new URL(
			//		"http://www.catster.com/wp-content/uploads/2017/08/A-fluffy-cat-looking-funny-surprised-or-concerned.jpg");
			
			URL url = new URL("http://yivesmirror.com/files/spigot/spigot-latest.jar");
			
			System.out.println("Starting download");
			long t1 = System.currentTimeMillis();

			// Maak een connectie met het internet
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

			in = conn.getInputStream();
			
			// Haal de bestandsnaam uit de url
			String filePath = url.getPath();
			String fileName = filePath.substring(filePath.lastIndexOf('/') + 1, filePath.length());
			System.out.println("Filename: " + fileName);
			
			// OutputStream - maak een nieuw bestand aan.
			out = new FileOutputStream(path + fileName);
			
			// Read data into buffer and then write to the output file
			byte[] buffer = new byte[8192];
			int bytesRead;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			long t2 = System.currentTimeMillis();
			System.out.println("Time for download & save file in millis:" + (t2 - t1));
		
		} catch (Exception e) {
			System.out.println("Erorr while execting the program: " + e.getMessage());
		} finally {
			// Close the resources correctly
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
