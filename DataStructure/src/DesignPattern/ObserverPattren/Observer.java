package DesignPattern.ObserverPattren;

public interface Observer {
    //一旦发现别人有动静，就立马行动起来
    void update(String context);
}
