/**
 * Homework #1
 */
package hw1;

/**
 * @author Tajamul Rabbani
 * Class for sorting strings given through cmd.
 */
public class Calculator {

	/**
	 * The entry point of the application.
	 * @param args Arguments passed through command line.
	 */
	public static void main(String[] args) {		
		try {
			String arg = args[0];
			if (isNumber(arg)) {
				simpleCalculate(args);
			}else if ("+-/*".indexOf(arg) != -1) {
				arrayCalculate(args);
			}else {
				System.out.println("Invalid value(s) provided.");
				System.exit(-1);
			}
		}catch(Exception ex) {
			System.out.println(ex);
			System.exit(-1);
		}
	}
	
	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void simpleCalculate(String[] args) 
			throws Exception {
		char op = args[1].charAt(0);
		double valOne = Double.valueOf(args[0]);
		double valTwo = Double.valueOf(args[2]);
		
		double result = calculate(op, valOne, valTwo);
		System.out.println(result);
	}
	
	public static void arrayCalculate(String[] args) 
			throws Exception {
		char op = args[0].charAt(0);
		double result = Double.valueOf(args[1]);
		for (int i = 2; i < args.length; i++) {
			result = calculate(op, result, Double.valueOf(args[i]));
		}
		
		System.out.println(result);
	}

	/**
	 * 
	 * @param op
	 * @param valOne
	 * @param valTwo
	 * @return
	 * @throws Exception
	 */
	public static double calculate(char op, double valOne, double valTwo) 
			throws Exception {
		switch(op) {
		case '+':
			return valOne + valTwo;
			
		case '-':
			return valOne - valTwo;
			
		case '*':
			return valOne * valTwo;
			
		case '/':
			return valOne / valTwo;
			
			default:
				throw new Exception("Invalid operator provided.");
		}
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
}
