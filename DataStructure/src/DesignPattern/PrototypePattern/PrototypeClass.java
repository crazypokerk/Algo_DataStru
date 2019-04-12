package DesignPattern.PrototypePattern;

/**
 * @Date 2019/4/8 19:01
 */
public class PrototypeClass implements Cloneable {
    //重写父类Object方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
