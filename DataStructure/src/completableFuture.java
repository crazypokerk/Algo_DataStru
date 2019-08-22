import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Date 2019/4/23 10:02
 */
public class completableFuture {
	public static void main(String[] args) {
	
	}
	
	CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
		System.out.println("T1 ,洗水壶。。。");
		sleep(1, TimeUnit.SECONDS);
		
		System.out.println("T1 ,烧开水。。。");
		sleep(15, TimeUnit.SECONDS);
	});
	
	CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
		System.out.println(" T2 ,洗茶壶。。。");
		sleep(1, TimeUnit.SECONDS);
		
		System.out.println(" T2 ,洗茶杯。。。");
		sleep(2, TimeUnit.SECONDS);
		
		System.out.println(" T2 ,拿茶叶。。。");
		sleep(1, TimeUnit.SECONDS);
		
		return "龙井";
	});
	
	CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
		System.out.println("T1 :拿到茶叶：" + tf);
		System.out.println("T1 :泡茶。。。");
		return "上茶：" + tf;
	});
	
	
	void sleep(int t, TimeUnit unit) {
		try {
			unit.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
