/**
 * @Date 2019/4/21 14:04
 */
public class dynamicpalan {
	public static void main(String[] args) {
		int[] w = {2, 2, 3, 6, 3};
		//System.out.println(knapsack(w,5,9));
		
		//2,2,3,6,3  10,15,20,40,25 n:5, w:9
		int[] value = {10, 15, 20, 40, 25};
		System.out.println(knapsack3(w, value, 5, 9));
	}
	
	//weight: 物品重量，n: 物品个数，w: 背包可承载重量
	//true: 1  false: 0
	//wegiht[2,2,3,6,3]
	public static int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w + 1];
		states[0][0] = true;
		states[0][weight[0]] = true;
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= w; j++) {
				//不把第i个物品放进背包
				//意思同一列不同行保持一致，上次能装下这次也能装下
				if (states[i - 1][j] == true) {
					states[i][j] = states[i - 1][j];
				}
			}
			for (int j = 0; j <= w - weight[i]; j++) {
				//把第i个物品放进背包 放进去之后，剩余空间=总空间减去放进去所占空间
				if (states[i - 1][j] == true) {
					states[i][j + weight[i]] = true;
				}
			}
		}
		for (int i = w; i >= 0; i--) {
			if (states[n - 1][i] == true) {
				return i;
			}
		}
		return 0;
	}
	
	public static int knapsack2(int[] items, int n, int w) {
		boolean[] states = new boolean[w + 1]; // 默认值 false
		states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
		states[items[0]] = true;
		for (int i = 1; i < n; ++i) { // 动态规划
			for (int j = w - items[i]; j >= 0; --j) {// 把第 i 个物品放入背包
				if (states[j] == true) states[j + items[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
			if (states[i] == true) return i;
		}
		return 0;
	}
	
	//2,2,3,6,3  10,15,20,40,25 n:5, w:9
	public static int knapsack3(int[] weight, int[] value, int n, int w) {
		int[][] states = new int[n][w + 1];
		for (int i = 0; i < n; ++i) { // 初始化 states
			for (int j = 0; j < w + 1; ++j) {
				states[i][j] = -1;
			}
		}
		states[0][0] = 0;
		states[0][weight[0]] = value[0];
		for (int i = 1; i < n; ++i) { // 动态规划，状态转移
            /*
                这个不装的for循环是下面装的for循环的基础
                在此基础之上，找出目前所在前i个物品里，最大的值，以此一步一步往下走，最终找到最大值
             */
			for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
				//只要上一层的大于等于0，对应的这行元素=上一行同一列元素
				//不装第i个，那么就是除了这个，之前选出来的最大的值
				if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) { // 选择第 i 个物品
				if (states[i - 1][j] >= 0) {
					int v = states[i - 1][j] + value[i];
					if (v > states[i][j + weight[i]]) {
						states[i][j + weight[i]] = v;
					}
				}
			}
		}
		// 找出最大值
		int maxvalue = -1;
		for (int j = 0; j <= w; ++j) {
			if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
		}
		return maxvalue;
	}
	
	
}
