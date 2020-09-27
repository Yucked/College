import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author Tajamul Rabbani
 *
 */
public class Assignment2part3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Double> v = new Vector<>(10);		
		for (int i = 0; i < 10000; i++) {
			double random = ThreadLocalRandom.current().nextDouble(0.0, 10.0);
			v.add(random);
		}
		
		Supplier<Stream<Double>> supplier = () -> Arrays.stream(v.getAll());
		getCount(supplier.get(), 0, 1);
		getCount(supplier.get(), 1, 2);
		getCount(supplier.get(), 2, 3);
		getCount(supplier.get(), 3, 4);
		getCount(supplier.get(), 4, 5);
		getCount(supplier.get(), 5, 6);
		getCount(supplier.get(), 6, 7);
		getCount(supplier.get(), 7, 8);
		getCount(supplier.get(), 8, 9);
		getCount(supplier.get(), 9, 10);
				
	}
	
	private static void getCount(Stream<Double> stream, int inclusive, int exclusive) {
		long count =  stream
				.filter(x -> x != null)
				.filter(x -> x <= inclusive && x < exclusive)
				.count();
		System.out.printf("There are %d between %d and %d%n", count, inclusive, exclusive);
	}

}
