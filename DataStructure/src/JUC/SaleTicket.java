package JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date 2019/5/9 9:33
 */
public class SaleTicket {
	public static void main(String[] args) {
		Ticket t = new Ticket();
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        t.sale();
//      }
//    },"fuck1").start();
//
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        t.sale();
//      }
//    },"fuck2").start();
//
//   new Thread(new Runnable() {
//      @Override
//      public void run() {
//        t.sale();
//      }
//    },"fuck3").start();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) t.sale();
		}, "fuck1").start();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) t.sale();
		}, "fuck2").start();
		new Thread(() -> {
			for (int i = 0; i < 30; i++) t.sale();
		}, "fuck3").start();
		
	}
}

class Ticket {
	private int ticket = 30;
	private Lock lock = new ReentrantLock();
	
	public void sale() {
		lock.lock();
		try {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "\t " +
						"卖出第:" + (ticket--) + "\t 还剩下: " + ticket);
			}
		} finally {
			lock.unlock();
		}
	}
}
