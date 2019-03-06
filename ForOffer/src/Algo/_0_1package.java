package Algo;

public class _0_1package {
    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    // currentWeight 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
    // weight 背包重量；itemsWeight 表示每个物品的重量；number 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public void f(int i, int currentWeight, int[] itemsWeight, int number, int weight) {
        if (currentWeight == weight || i == number) { // currentWeight==weight 表示装满了 ;i==number 表示已经考察完所有的物品
            if (currentWeight > maxW) maxW = currentWeight;
            return;
        }
        f(i + 1, currentWeight, itemsWeight, number, weight);
        if (currentWeight + itemsWeight[i] <= weight) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i + 1, currentWeight + itemsWeight[i], itemsWeight, number, weight);
        }
    }

    public static void main(String[] args) {
        int[] a = {20,5,15,30,25,10,35,18,8,12};
        _0_1package s = new _0_1package();
        s.f(0,0,a,10,100);
    }
}
