package DynamicProxy;

import java.lang.reflect.Proxy;
import java.util.Stack;

/**
 * @Date 2019/6/29 9:17
 */
public class Main {
	public static void main(String[] args) {
		login ac = new AccountLoginImpl();
		
		
		MyInvocationHandler handler = new MyInvocationHandler(ac);
		
		login proxy = (login) Proxy.newProxyInstance(AccountLoginImpl.class.getClassLoader(), ac.getClass().getInterfaces(), handler);
		
		proxy.accountLogin();
		
		
		int sum = 0;
		sum += '3';
		System.out.println(sum);
		
		StringBuilder sb = new StringBuilder("dasda");
		String substring = sb.substring(2);
		System.out.println(substring);
	}
}
