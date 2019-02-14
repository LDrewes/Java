package csv_arraylist;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Voorbeeld om een csv bestand in te lezen.
 * @author drewes
 *
 */
public class ReadDemo {

	// Het bronbestand met de woorden
	private static final String source = "assets/csv/6letterwoorden.txt";
	// Een arraylist van Strings
	private ArrayList<String> list = new ArrayList<String>();
	// Het geselecteerde woord
	private String word;
	
	
	/**
	 * Main methode
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		new ReadDemo();
	}
	
	/**
	 * De constructor importeert de woorden
	 * en selecteert een willekeurige waaarde.
	 */
	public ReadDemo() {
		
		// Importeer de woorden
		importWords();
		// Debug 
		System.out.println(list.toString());
		
		word = selectWord();
		// Debug
		System.out.println("Geselecteerd: " + word);
	}
	
	
	/**
	 * Importeer de woordenlijst
	 * @param bestandsNaam
	 * @return
	 */
	public void importWords() {
		BufferedReader in;
		String line;
		try {
			in = new BufferedReader(new FileReader(source));
			while ((line = in.readLine()) != null) {
				try {
					list.add(line);
					// Debug 
					System.out.println("Add " + line + " to list.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Kan bestand niet vinden");
		} catch (IOException e) {
			System.out.println("Fout bij het lezen of sluiten bestand");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Fout bij het lezen of sluiten bestand");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Selecteer een random woord uit de lijst
	 */
	public String selectWord() {
		int index = (int) (Math.random() * (list.size() - 1));
		return (String) list.get(index);
	}
}
