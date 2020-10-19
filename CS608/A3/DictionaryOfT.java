import java.lang.reflect.Array;
import java.util.Arrays;

public class DictionaryOfT<TKey extends Comparable<TKey>, TValue> {
	private int currentIndex = 0;
	private Pair<TKey, TValue>[] pairs;

	@SuppressWarnings("unchecked")
	public DictionaryOfT() {
		pairs = (Pair<TKey, TValue>[]) Array.newInstance(Pair.class, 10);
	}

	public void insert(TKey key, TValue value) {
		if (this.isResizeRequired()) {
			this.resize();
		}

		pairs[currentIndex] = new Pair<TKey, TValue>(key, value, currentIndex);
		currentIndex++;
	}

	public TValue lookup(TKey key) {
		Pair<TKey, TValue> found = null;

		for (Pair<TKey, TValue> pair : pairs) {
			if (!pair.getKey().equals(key)) {
				continue;
			}

			found = pair;
			break;
		}

		return found.getValue();
	}

	public void delete(TKey key) {
		for (Pair<TKey, TValue> pair : pairs) {
			if (!pair.getKey().equals(key)) {
				continue;
			}

			int index = pair.getIndex();
			while (index < currentIndex) {
				int nIndex = index + 1;
				
				if (nIndex == currentIndex) {
					pairs[--nIndex] = null;
					break;
				}
				
				Pair<TKey, TValue> nPair = pairs[nIndex];
				if (nPair == null) {
					break;
				}
				
				nPair.setIndex(nIndex);
				pairs[index] = nPair;
				index++;
			}
			
			break;
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(pairs);
	}

	private boolean isResizeRequired() {
		return currentIndex == pairs.length;
	}

	private void resize() {
		Pair<TKey, TValue>[] temp = Arrays.copyOf(pairs, (int) (pairs.length + 10));
		pairs = temp;
	}
}
