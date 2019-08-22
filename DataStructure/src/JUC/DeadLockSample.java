package JUC;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2019/4/26 10:29
 */
public class DeadLockSample extends Thread {
	private String first;
	private String second;
	
	public DeadLockSample(String name, String first, String second) {
		super(name);
		this.first = first;
		this.second = second;
	}
	
	@Override
	public void run() {
		synchronized (first) {
			System.out.println(this.getName() + " obtained: " + first);
			try {
				Thread.sleep(1000L);
				synchronized (second) {
					System.out.println(this.getName() + " obtained: " + second);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
		Runnable dlCheck = new Runnable() {
			@Override
			public void run() {
				long[] threadIdS = mxBean.findDeadlockedThreads();
				if (threadIdS != null) {
					ThreadInfo[] threadInfos = mxBean.getThreadInfo(threadIdS);
					System.out.println("检测到死锁：");
					for (ThreadInfo t : threadInfos) {
						System.out.println(t.getThreadName() + " " + t.getThreadId());
					}
				}
			}
		};
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
		//稍等5秒，然后5秒做一次死锁扫描
		scheduledExecutorService.scheduleAtFixedRate(dlCheck, 5, 5, TimeUnit.SECONDS);
		
		String lockA = "lockA";
		String lockB = "lockB";
		DeadLockSample t1 = new DeadLockSample("Thread1", lockA, lockB);
		DeadLockSample t2 = new DeadLockSample("Thread2", lockB, lockA);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
