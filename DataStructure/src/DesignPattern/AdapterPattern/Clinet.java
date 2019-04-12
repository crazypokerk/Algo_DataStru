package DesignPattern.AdapterPattern;

/**
 * @Date 2019/4/11 9:58
 */
public class Clinet {
    public static void main(String[] args) {
        //原有的业务逻辑
        LaptopPlug plug = new Laptop();
        plug.boot();
        plug.playR6();
        plug.zzRW();

        System.out.println("--------------------------");

        //现在增加了适配器角色后的业务逻辑
        LaptopPlug plug1 = new Adapter();
        plug1.boot();
        plug1.playR6();
        plug1.zzRW();

        System.out.println("--------------------------");

        IphonePlug plug2 = new Adapter();
        plug2.weChat();
        plug2.bilibili();
    }
}
