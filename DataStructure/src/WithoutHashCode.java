import java.util.HashMap;
import java.util.Objects;

/**
 * @Date 2019/4/3 21:39
 */
class Key {
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	
	public Key(Integer id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Key key = (Key) o;
		return id.equals(key.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

public class WithoutHashCode {
	public static void main(String[] args) {
		Key k1 = new Key(1);
		Key k2 = new Key(1);
		Key k3 = new Key(2);
		HashMap<Key, Key> hm = new HashMap<Key, Key>();
		hm.put(k1, k3);
		hm.put(k3, k2);
		System.out.println(hm.get(k1));
		System.out.println(hm.get(k3));
		System.out.println(k1);
		System.out.println(k2);
		System.out.println(k3);
	}
}
