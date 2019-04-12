package DesignPattern.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @Date 2019/4/6 10:44
 */
public class ClinetIH {

    public static void main(String[] args) {
        //定义一个痴迷R6的哈哈怪
        BossPlayer player = new BossPlayer("老九");
        //定义一个handler
        InvocationHandler handler = new R6PlayerIH(player);
        //开始打游戏，记下时间戳
        System.out.println("开始时间是： 2019-4-16 10:00:00");
        //获得类的class loader
        ClassLoader cl = player.getClass().getClassLoader();
        //动态产生一个代理人
        R6GamePlayer proxy = (R6GamePlayer) Proxy.newProxyInstance(cl, new Class[]{R6GamePlayer.class}, handler);
        //登录
        proxy.loginUbisoft("DJgoooooo", "hahahahaha");
        //杀队友
        proxy.teamKill();
        //开包
        proxy.clearCush();
        System.out.println("游戏结束时间：" + new Date());
    }
}
