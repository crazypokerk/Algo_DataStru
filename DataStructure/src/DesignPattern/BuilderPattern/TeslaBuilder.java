package DesignPattern.BuilderPattern;

import java.util.ArrayList;

/**
 * @Date 2019/4/5 10:35
 */
public class TeslaBuilder extends CarBuilder {
    private TeslaModel tesla = new TeslaModel();
    @Override
    public void setSquence(ArrayList<String> sequence) {
        this.tesla.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.tesla;
    }
}
