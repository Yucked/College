import java.util.Arrays;

/**
 * 
 */

/**
 * @author Tajamul Rabbani
 *
 */
public final class Vector<T> {
	private T[] array;
	private int index = 0;
	
	@SuppressWarnings("unchecked")
	public Vector() {
		array = (T[])new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public Vector(int n) {
		array = (T[])new Object[n];
	}
	
	public T get(int i) {
		return array[i];
	}
	
	public void add(T v) {
		array[index] = v;
		index++;
		
		if (!isResizeRequired()) {
			return;
		}
		
		resize();
	}
	
	public void add(int i, T v) {
		array[i] = v;
	}
	
	public T[] getAll() {
		return array;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(array);
	}
	
	public void main() {
		Vector<String> vStr = new Vector<String>();
		for (int i = 0; i < 100; i++) {
			vStr.add(String.format("%d", i));
		}
		
		System.out.println(vStr);
	}
	
	private boolean isResizeRequired() {
		return index == array.length;
	}
	
	private void resize() {
		T[] temp = Arrays.copyOf(array, (int)(array.length + 10));
		array = temp;
	}
}
