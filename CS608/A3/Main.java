import java.util.concurrent.ThreadLocalRandom;

public final class Main {

	private final Dictionary dic;
	private final DictionaryOfT<Integer, Integer> gen;
	
	public Main() {
		dic = new Dictionary();
		gen = new DictionaryOfT<Integer, Integer>();
	}

	public static void main(String[] args) {
		new Main().test();
	}
	
	private void test() {
		test_insert();
		test_lookup();
		//test_delete();
		
		System.out.println(
				"\n====================================================================================\n"
				+ "GENERIC DICTIONARY TEST"
				+ "\n====================================================================================\n");
		
		test_insertT();
		test_lookupT();
		//test_deleteT();
	}

	private void test_insert() {
		for (int i = 0; i < 100; i++) {
			dic.insert(String.format("%d", i), String.format("This is the value of %d", i));
		}

		System.out.println(dic);
	}
	
	private void test_lookup() {
		for(int i = 0; i < 50; i++) {
			int random = ThreadLocalRandom.current().nextInt(0, 99);
			String value = dic.lookup(String.format("%d", random));
			System.out.println(String.format("Random index is: %d and value of index is: %s", random, value));
		}
	}
	
	private void test_delete() {
		for(int i = 0; i < 50; i++) {
			int random = ThreadLocalRandom.current().nextInt(0, 99);
			dic.delete(String.format("%d", random));
		}
		
		System.out.println(dic);
	}
	
	private void test_insertT() {
		for (int i = 0; i < 100; i++) {
			gen.insert(i, i);
		}

		System.out.println(dic);
	}
	
	private void test_lookupT() {
		for(int i = 0; i < 50; i++) {
			int random = ThreadLocalRandom.current().nextInt(0, 99);
			int value = gen.lookup(random);
			System.out.println(String.format("Random index is: %d and value of index is: %d", random, value));
		}
	}
	
	private void test_deleteT() {
		gen.delete(5);
		gen.delete(0);
		System.out.println(dic);
	}
}