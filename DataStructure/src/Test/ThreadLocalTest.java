package Test;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @Date 2019/8/17 10:16
 */
public class ThreadLocalTest {
	
	
	public static void main(String[] args) {
		ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
		Thread t1 = new Thread(() -> {
			stringThreadLocal.set("Thread-aaa");
			System.out.println((Thread.currentThread().getName() + " " + stringThreadLocal.get()));
			
			stringThreadLocal.remove();
		});
		
		t1.start();
		
		
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " " + stringThreadLocal.get());
			
			stringThreadLocal.set("Thread-bbb");
			
			System.out.println(Thread.currentThread().getName() + " " + stringThreadLocal.get());
			
			stringThreadLocal.remove();
		});
		
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stringThreadLocal.set("Main");
		System.out.println(Thread.currentThread().toString() + " " + stringThreadLocal.get());
		stringThreadLocal.remove();
	}
	
}
