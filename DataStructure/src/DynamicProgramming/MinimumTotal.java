package DynamicProgramming;

import java.util.List;

/**
 * @Date 2019/4/26 16:19
 */
public class MinimumTotal {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        if (triangle == null || triangle.size() == 0){
//            return 0;
//        }
//        // 只需要记录每一层的最小值即可
//        int[] dp = new int[triangle.size()+1];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            List<Integer> curTr = triangle.get(i);
//            for (int j = 0; j < curTr.size(); j++) {
//                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
//                dp[j] = Math.min(dp[j],dp[j+1]) + curTr.get(j);
//            }
//        }
//        return dp[0];
//    }
	
	public static void main(String[] args) {
		int a = 8;
		int b = 1;
		
		System.out.println(a & b);
	}
}
