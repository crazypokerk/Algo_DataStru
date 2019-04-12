package DesignPattern.SingletonPattern;

/**
 * @Date 2019/4/1 9:20
 */
/*
    基于volatile的解决方案
 */
public class DoubleCheckedLocking {
    private static volatile Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}


class Instance {

}
