package DesignPattern.ObserverPattren;

import java.util.ArrayList;

/**
 * @Date 2019/4/12 8:53
 */
public class ZhuGeLiang implements Observable,IZhuGeLiang{
    //定义一个变长数组，存放所有观察者
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for (Observer ob : observers) {
            ob.update(context);
        }
    }

    //诸葛亮要谋划计策了
    public void planB() {
        System.out.println("诸葛亮：开始谋划计策了...");
        //通知所有观察者
        this.notifyObservers("诸葛亮在密谋");
    }

    //诸葛亮要准备起兵了
    public void attack() {
        System.out.println("诸葛亮：准备战斗了...");
        this.notifyObservers("诸葛亮要起兵");
    }
}
