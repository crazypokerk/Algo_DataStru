package DesignPattern.BuilderPattern;

/**
 * @Date 2019/4/5 10:40
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();

        director.getABenzModel().run();
        director.getBBenzModle().run();
        director.getATeslaModle().run();
    }
}
