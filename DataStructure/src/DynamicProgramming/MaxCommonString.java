package DynamicProgramming;

/**
 * @Date 2019/4/24 9:21
 */
public class MaxCommonString {
	public int maxCommonString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		char[] sc1 = s1.toCharArray();
		char[] sc2 = s2.toCharArray();
		int[][] maxLen = new int[len1][len2];
		
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				maxLen[i][j] = 0;
			}
		}
		
		
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				//如果两个字符串最后一个字符相等
				if (sc1[i - 1] == sc2[j - 1]) {
					maxLen[i][j] = maxLen[i][j] + 1;
				} else {
					maxLen[i][j] = Math.max(maxLen[i][j - 1], maxLen[i - 1][j]);
				}
			}
		}
		
		return 0;
	}
	
	public int recur(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * recur(n - 1);
		}
	}
	
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[m - 1].length;
		int minL = 0;
		
		int[][] dp = new int[m][n];
		
		dp[0][0] = grid[0][0];
		
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}
		return dp[m - 1][n - 1];
	}
	
	public int numTrees(int n) {
		if (n == 1 || n == 2) {
			return n;
		} else {
			int[] dp = new int[n + 1];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 2;
			//第i个数为顶点的树的个数是小于i的树构成的树的个数乘以大于i的树构成的树的个数
			//f(n) = f(0)*f(n-1-0) + f(1)*f(n-1-1) + ... + f(n-1)*f(0)
			for (int i = 3; i <= n; i++) {
				dp[i] = 0;
				for (int j = 0; j <= i - 1; j++) {
					dp[i] += dp[j] * dp[i - 1 - j];
				}
			}
			return dp[n];
		}
	}
}
