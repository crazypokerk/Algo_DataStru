package Algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TTTTTTT implements Comparator, Comparable {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new LinkedHashMap(10, 0.75f, true);

        hashMap.put(3, 11);
        hashMap.put(1, 12);
        hashMap.put(5, 23);
        hashMap.put(2, 22);

        hashMap.put(3, 88);
        hashMap.get(5);

        for (Map.Entry e :
                hashMap.entrySet()) {
            System.out.println(e.getKey());
        }

    }

    public TTTTTTT() {
        super();

    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
