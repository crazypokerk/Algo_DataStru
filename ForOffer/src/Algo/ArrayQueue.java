package Algo;

public class ArrayQueue {
    private String[] items;
    private int n;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capaticy) {
        items = new String[capaticy];
        n = capaticy;
    }

    //入队
    public boolean enqueue(String item) {
        if (tail == n) {
            if (head == 0) {
                //tail == 0&& head == 0表示队列里面放满了元素
                return false;
            }
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }
}
