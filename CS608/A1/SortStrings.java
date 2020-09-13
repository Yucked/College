/**
 * Homework #1
 */
package hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tajamul Rabbani
 * Class for sorting strings given through cmd.
 */
public class SortStrings {

	/**
	 * The entry point of the application.
	 * @param args Arguments passed through command line.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<String>();
		String input = "";
		
		for(;;) {
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("---")) {
				break;
			}
			
			inputs.add(input);
		}
		
		String[] results = inputs.toArray(new String[0]);
		Arrays.sort(results);
		for(String item : results) {
			System.out.println(item);
		}
		scanner.close();
	}
}
