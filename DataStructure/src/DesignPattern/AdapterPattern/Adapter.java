package DesignPattern.AdapterPattern;

/**
 * @Date 2019/4/11 9:54
 */
public class Adapter extends Power implements LaptopPlug,IphonePlug {
    @Override
    public void boot() {
        super.powerSupply220v();
    }

    @Override
    public void playR6() {
        System.out.println("开干，rush bbbbbb！");
    }

    @Override
    public void zzRW() {
        System.out.println("我跳起来打你的那个，杂志，流云行水，谁去帮我把盲僧的桌子掀了！");
    }

    @Override
    public void weChat() {
        super.powerSupply220v();
        System.out.println("有转换头了，充电充起来!");
    }

    @Override
    public void bilibili() {
        System.out.println("b站鬼畜，停不下来！");
    }
}
