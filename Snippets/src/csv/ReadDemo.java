package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Voorbeeld om een csv bestand in te lezen.
 * @author drewes
 *
 */
public class ReadDemo {

	public static void main(String[] args) throws IOException {
		
		String csvFile = "assets/csv/namen.csv";
        String line = "";
        String delimiter = ";";
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        
        try {

            while ((line = bufferedReader.readLine()) != null) {

                String[] row = line.split(delimiter);
                System.out.println("Parsed: | " + row[0] + " | " + row[1] + " | " + row[2] + " | ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
