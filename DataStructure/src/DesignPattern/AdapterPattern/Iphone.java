package DesignPattern.AdapterPattern;

/**
 * @Date 2019/4/11 10:09
 */
public class Iphone implements IphonePlug {
    @Override
    public void weChat() {
        System.out.println("呀，手机快没电了！没有转换头！");
    }

    @Override
    public void bilibili() {
        System.out.println("还没看完。。。");
    }
}
