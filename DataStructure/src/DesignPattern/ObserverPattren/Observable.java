package DesignPattern.ObserverPattren;

public interface Observable {
    //增加一个观察者
    void addObserver(Observer observer);

    //删除一个观察者
    void deleteObserver(Observer observer);

    //既然要观察，我发生了改变他也应该有所动作，通知观察者
    void notifyObservers(String context);
}
