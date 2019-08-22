package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date 2019/5/10 9:02
 */
public class ThreadOrderAccess {
	public static void main(String[] args) {
		ShareModel sm = new ShareModel();
		
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				sm.print5(i);
			}
		}, "t1").start();
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				sm.print10(i);
			}
		}, "t2").start();
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				sm.print15(i);
			}
		}, "t3").start();
		
	}
}

class ShareModel {
	private int number = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	public void print5(int loop) {
		//1判断
		lock.lock();
		try {
			while (number != 1) {
				c1.await();
			}
			
			//2干活
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + "i:" + i + "  " + "loop：" + loop);
			}
			//3通知
			number = 2;
			c2.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void print10(int loop) {
		//1判断
		lock.lock();
		try {
			while (number != 2) {
				c2.await();
			}
			
			//2干活
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "i:" + i + "  " + "loop：" + loop);
			}
			//3通知
			number = 3;
			c3.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void print15(int loop) {
		//1判断
		lock.lock();
		try {
			while (number != 3) {
				c3.await();
			}
			
			//2干活
			for (int i = 0; i < 15; i++) {
				System.out.println(Thread.currentThread().getName() + "i:" + i + "  " + "loop：" + loop);
			}
			//3通知
			number = 1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
