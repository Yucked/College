import java.util.Arrays;

/**
 * 
 */

/**
 * @author Tajamul Rabbani
 *
 */
public final class VectorInt {
	private int[] array;
	private int index = 0;
	
	public VectorInt() {
		array = new int[10];
	}
	
	public VectorInt(int n) {
		array = new int[n];
	}
	
	public int get(int i) {
		return array[i];
	}
	
	public void add(int v) {
		array[index] = v;
		index++;
		
		if (!isResizeRequired()) {
			return;
		}
		
		resize();
	}
	
	public void add(int i, int v) {
		array[i] = v;
	}
	
	public int[] getAll() {
		return array;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(array);
	}
	
	public void main() {
		VectorInt vInt = new VectorInt(100);
		for (int i = 0; i < 100; i++) {
			vInt.add(i);
		}
		
		System.out.println(vInt);
	}
	
	private boolean isResizeRequired() {
		return index == array.length;
	}
	
	private void resize() {
		int[] temp = Arrays.copyOf(array, (int)(array.length * 1.5));
		array = temp;
	}
}
