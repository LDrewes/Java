package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Voorbeeld om naar een csv bestand te schrijven
 * 
 * @author drewes
 *
 */
public class WriteDemo {

	public static void main(String[] args) throws IOException {

		String csvFile = "assets/csv/namen.csv";
		
		// In nederland is het scheidingsteken een ;.
		String delimeter = ";";

		// Test data maken
		String[][] data = new String[10][3];
		for (int i=0; i<10; i++) {
			data[i][0] = String.valueOf(i);
			data[i][1] = "Voornaam " + i;
			data[i][2] = "Achternaam " + i;
		}
		
		// Write object maken
		BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));

		// Per rijen de cellen samenvoegen tot een string
		for (int i=0; i<10; i++) {

			try {
				String line = String.join(delimeter, data[i]);
				writer.write(line);
				System.out.println("Writing: " + line);
				writer.newLine();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		writer.close();
	}
}
