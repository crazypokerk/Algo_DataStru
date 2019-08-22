package JUC;

import java.util.concurrent.CountDownLatch;

/**
 * @Date 2019/5/10 10:35
 */
public class CountDownLatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch cd = new CountDownLatch(4);

//    for (int i = 1; i <=6; i++) {
//      new Thread(()->{
//        System.out.println(Thread.currentThread().getName()+"\t 国被灭");
//        cd.countDown();
//      },CountryEnums.forEachCountry(i).getRetMsg()).start();
//    }
//    cd.await();
//    System.out.println("统一六国");
		for (int i = 1; i <= 4; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "\t 季过完啦");
				cd.countDown();
			}, SeasonEnums.foreachSeasons(i).getSeas()).start();
		}
		cd.await();
		System.out.println("一轮季节！");
	}
}
