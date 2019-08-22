package JUC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CyclicBarrier;

/**
 * @Date 2019/5/10 10:54
 */
public class CyclicBarrierDemo {
	private static final int NUMBER = 7;
	CyclicBarrier cb = new CyclicBarrier(NUMBER, () -> {
	
	});
	
	public static void main(String[] args) {
		Collections.synchronizedCollection(new ArrayList<>());
		
	}
}
