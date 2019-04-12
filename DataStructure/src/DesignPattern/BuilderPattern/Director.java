package DesignPattern.BuilderPattern;

import java.util.ArrayList;

/**
 * @Date 2019/4/4 13:57
 */
public class Director {
    private ArrayList<String> sequence = new ArrayList<>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private TeslaBuilder teslaBuilder = new TeslaBuilder();

    public BenzModel getABenzModel() {
        //清理场景，必须！
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSquence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getBBenzModle() {
        //清理场景，必须！
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("alarm");
        this.benzBuilder.setSquence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public TeslaModel getATeslaModle() {
        //清理场景，必须！
        this.sequence.clear();
        this.sequence.add("stop");
        this.sequence.add("engineBoom");
        this.teslaBuilder.setSquence(sequence);
        return (TeslaModel) this.teslaBuilder.getCarModel();
    }
}
