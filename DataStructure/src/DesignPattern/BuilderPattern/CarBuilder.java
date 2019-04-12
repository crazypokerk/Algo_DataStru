package DesignPattern.BuilderPattern;

import java.util.ArrayList;

/**
 * @Date 2019/4/5 10:22
 */
public abstract class CarBuilder {
    //创建一个模型，要什么顺序，给你什么顺序
    public abstract void setSquence(ArrayList<String> sequence);

    //设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}
