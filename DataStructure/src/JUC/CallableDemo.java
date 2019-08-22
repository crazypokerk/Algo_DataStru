package JUC;

import java.util.concurrent.*;

/**
 * @Date 2019/5/10 9:31
 */
public class CallableDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask f = new FutureTask<Object>(() -> {
			Object o = new Object();
			return o;
		});
		f.get();
		new Thread(f).start();
	}
}

