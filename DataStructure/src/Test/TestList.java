package Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @Date 2019/7/21 16:33
 */
public class TestList {
	public static void main(String[] args) {
//		List<Integer> list = new ArrayList();
//
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);

//		for (Integer o : list) {
//			if (o == 3) {
//				list.remove(o);
//			}
//		}

//		Iterator<Integer> iterator = list.iterator();
//
//		while (iterator.hasNext()) {
//			int num = iterator.next();
//			if (num == 3) {
//				iterator.remove();
//			}
//		}

//		System.out.println(list);
		
		
		//Element[] elements = {new Element(1), new Element(2), new Element(3)};

//		List<Element> arrayList = Arrays.asList(elements);
//
//		arrayList.add(new Element(4));
//		System.out.println(arrayList);
		
		//List list1 = Arrays.stream(elements).collect(Collectors.toList());
		
		//list1.add(new Element(5));

//		new Thread(()->{
//			System.out.println(11);
//			System.out.println(22);
//		}).start();
		
		/*double a = 0.1;
		double b = 0.2;*/

//		BigDecimal bi = new BigDecimal(0.1);
//		BigDecimal b = new BigDecimal(0.2);
//
//		BigDecimal bigDecimal = bi.valueOf(0.1);
//
//		String s = "";
//		s.toCharArray();
//		Map<String, Object> map = new HashMap<>();
//
//		Lock lock = new ReentrantLock();
//		Condition condition = lock.newCondition();
//
//		lock.lock();
//		try{
//
//		}finally {
//
//		}

//		int a = 2;
//
//		while (a==23);
//
//		System.out.println("ssss");
//
//		String[] aaa = {"dasd", "Dasdas", "grew"};
//
//		List<String> list = Arrays.stream(aaa).collect(Collectors.toList());
//
//		list.add("sads");
//
//		for (String s : list) {
//			System.out.println(s);
//		}
		
		int i = 33;
		i &= 1;
		System.out.println(i);
	}
}

class Element {
	private int num;
	
	public Element(int num) {
		this.num = num;
	}
}

class FooBar {
	private int n;
	private int st = 1;
	ReentrantLock lock = new ReentrantLock();
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	
	public FooBar(int n) {
		this.n = n;
	}
	
	public void foo(Runnable printFoo) throws InterruptedException {
		lock.lock();
		try {
			for (int i = 0; i < n; i++) {
				if (st != 1) {
					condition1.await();
				}
				st = 2;
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				condition2.signal();
			}
		} finally {
			lock.unlock();
		}
	}
	
	public void bar(Runnable printBar) throws InterruptedException {
		lock.lock();
		try {
			for (int i = 0; i < n; i++) {
				if (st != 2) {
					condition2.await();
				}
				st = 1;
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				condition1.signal();
			}
		} finally {
			lock.unlock();
			
		}
		
	}
}

