package JUC;

/**
 * @Date 2019/5/9 10:49
 */
public class NotifyWaitDemo {
	public static void main(String[] args) {
		ShareData s = new ShareData();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					s.decr();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t111").start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					s.incr();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t222").start();
		
	}
}

class ShareData {
	private int number = 0;
	
	public synchronized void incr() throws InterruptedException {
		//1判断
		while (number != 0) {
			this.wait();
		}
		//2干活
		++number;
		System.out.println(Thread.currentThread().getName() + "\t" + number);
		//3通知
		this.notifyAll();
	}
	
	public synchronized void decr() throws InterruptedException {
		while (number == 0) {
			this.wait();
		}
		--number;
		System.out.println(Thread.currentThread().getName() + "\t" + number);
		notifyAll();
	}
}
