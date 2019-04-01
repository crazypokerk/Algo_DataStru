package Threaddddd;

/**
 * @Date 2019/4/1 9:23
 */
/*
    基于类初始化的解决方案
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance;
    }
}
