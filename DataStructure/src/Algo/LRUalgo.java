package Algo;

import java.util.HashMap;

/**
 * LRU算法实现
 *
 * @Date 2019/3/13 10:18
 */
class Node {
    int key;
    int value;
    Node next;
    Node pre;

    public Node(int key, int value, Node pre, Node next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}

public class LRUalgo {
    int capacity;
    int count;//cache size
    Node head;
    Node tail;
    HashMap<Integer, Node> hm;

    public LRUalgo(int capacity) { //only initial 2 Node is enough, head/tail
        this.capacity = capacity;
        this.count = 2;
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-2, -2, this.head, null);
        this.head.next = this.tail;
        hm = new HashMap<Integer, Node>();
        hm.put(this.head.key, this.head);
        hm.put(this.tail.key, this.tail);
    }

    public int get(int key) {
        int value = -1;
        if (hm.containsKey(key)) {
            Node nd = hm.get(key);
            value = nd.value;
            detachNode(nd); //detach nd from current place
            insertToHead(nd); //insert nd into head
        }
        return value;
    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) { //update
            Node nd = hm.get(key);
            nd.value = value;
            //move to head
            detachNode(nd); //detach nd from current place
            insertToHead(nd); //insert nd into head
        } else { //add
            Node newNd = new Node(key, value, null, this.head);
            this.head.pre = newNd; //insert into head
            this.head = newNd;
            hm.put(key, newNd); //add into hashMap
            this.count++;
            if (this.count > capacity) { //need delete node
                removeNode();
            }
        }
    }

    //common func
    public void insertToHead(Node nd) {
        this.head.pre = nd;
        nd.next = this.head;
        nd.pre = null;
        this.head = nd;
    }

    public void detachNode(Node nd) {
        nd.pre.next = nd.next;
        if (nd.next != null) {
            nd.next.pre = nd.pre;
        } else {
            this.tail = nd.pre;
        }
    }

    public void removeNode() { //remove from tail
        int tailKey = this.tail.key;
        this.tail = this.tail.pre;
        this.tail.next = null;
        hm.remove(tailKey);
        this.count--;
    }

    public void printCache() {
        System.out.println("\nPRINT CACHE ------ ");
        System.out.println("count: " + count);
        System.out.println("From head:");
        Node p = this.head;
        while (p != null) {
            System.out.println("key: " + p.key + " value: " + p.value);
            p = p.next;
        }
        System.out.println("From tail:");
        p = this.tail;
        while (p != null) {
            System.out.println("key: " + p.key + " value: " + p.value);
            p = p.pre;
        }

    }

    public static void main(String[] args) {
        LRUalgo lc = new LRUalgo(3);
        lc.printCache();

        lc.put(1, 1);
        lc.put(2, 2);
        lc.put(3, 3);
        lc.printCache();

        lc.get(2);
        lc.printCache();

        lc.put(4, 4);
        lc.printCache();

        lc.get(1);
        lc.printCache();

        lc.put(3, 33);
        lc.printCache();
    }
}
