package DesignPattern.FlyweightPattern;

import java.util.HashMap;

/**
 * @Date 2019/4/15 13:50
 */
public class SpecialForceFactory {
	//池容器
	private static HashMap<String, SpecialForceInfo> pool = new HashMap<>();
	
	//干员报名信息的对象工厂
	//从池中获得对象
	public static SpecialForceInfo getSpecialForceInfo(String key) {
		//设置返回对象
		SpecialForceInfo result = null;
		//池中没有该对象，则建立，并放入池中
		if (!pool.containsKey(key)) {
			System.out.println(key + "---建立对象，并放置到池中---");
			result = new ConcreteSpecialForceInfo(key);
			pool.put(key, result);
		} else {
			result = pool.get(key);
			System.out.println(key + "---直接从池中取得---");
		}
		return result;
	}
}
