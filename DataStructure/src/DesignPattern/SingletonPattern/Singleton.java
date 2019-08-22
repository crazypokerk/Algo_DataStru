package DesignPattern.SingletonPattern;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Date 2019/4/24 16:11
 */
/*
    CAS实现单例模式
 */
public class Singleton {
	private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();
	
	private Singleton() {
	
	}
	
	public static Singleton getInstance() {
		for (; ; ) {
			Singleton singleton = INSTANCE.get();
			if (singleton != null) {
				return singleton;
			}
			
			singleton = new Singleton();
			if (INSTANCE.compareAndSet(null, singleton)) {
				return singleton;
			}
		}
	}
}
