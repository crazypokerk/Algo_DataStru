package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Date 2019/6/29 9:06
 */
public class MyInvocationHandler implements InvocationHandler {
	Object target;
	
	public MyInvocationHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("有用户请求登录。。。");
		Object res = method.invoke(target, args);
		
		System.out.println("用户登录成功。。。");
		return res;
		
		
	}
}
