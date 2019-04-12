package DesignPattern.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Date 2019/4/6 10:42
 */
public class R6PlayerIH implements InvocationHandler {
    //被代理者
    Class cls = null;
    //被代理的实例
    Object obj = null;

    //我要代理谁
    public R6PlayerIH(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj, args);

        //如果是登录，要发送一个安全提醒
        if (method.getName().equalsIgnoreCase("loginUbisoft")) {
            System.out.println("老九号又被盗啦！！！");
        }

        return result;
    }
}
