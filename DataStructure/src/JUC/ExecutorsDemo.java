package JUC;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Date 2019/5/10 15:01
 */
public class ExecutorsDemo {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> result = null;
		
		try {
			for (int i = 0; i < 15; i++) {
				result = service.submit(() -> {
					System.out.println(Thread.currentThread().getName());
					return new Random().nextInt(10);
				});
				System.out.println(result.get());
			}
		} catch (Exception e) {
		
		} finally {
			service.shutdown();
		}
	}
}
