package DesignPattern.ChainPatten;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Date 2019/4/16 20:13
 */
public class Client {
	public static void main(String[] args) {
		//随机生成几种货币类型
		Random random = new Random();
		ArrayList<IMoney> arrayList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(new Money(random.nextInt(5), "我想存钱"));
		}
		//定义四个请示对象
		BankHandler rmb = new RMB();
		BankHandler usd = new USD();
		BankHandler eur = new EUR();
		BankHandler jpy = new JPY();
		//设置处理顺序
		rmb.setNext(usd);
		usd.setNext(eur);
		eur.setNext(jpy);
		for (IMoney m : arrayList) {
			rmb.HandleMessage(m);
		}
	}
}
