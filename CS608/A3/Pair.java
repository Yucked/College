
public class Pair<TKey, TValue> {
	private final TKey key;
	private TValue value;
	private int index;

	public Pair(TKey key, TValue value, int index) {
		this.key = key;
		this.value = value;
		this.index = index;
	}

	public final TKey getKey() {
		return key;
	}

	public final TValue getValue() {
		return value;
	}

	public final void setValue(TValue value) {
		this.value = value;
	}

	public final int getIndex() {
		return index;
	}

	public final void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
		return String.format("%d -> (%s, %s)", index, key, value);
	}
}