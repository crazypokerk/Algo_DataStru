//package leetcode.BFS_DFS;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * @Date 2019/9/1 16:45
// */
//public class _200_NumIslands {
//
//	public int numIslands(char[][] grid) {
//
//		if (grid == null || grid.length == 0) return 0;
//
//		int rows = grid.length, cols = grid[0].length;
//		int island_count = 0;
//
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				if (grid[i][j] == '1') {
//					island_count++;
//					grid[i][j] = '0';
//					Queue<Integer> queue = new LinkedList<>();
//					// 把是1的坐标转换为一个数字
//					queue.add(i * cols + j);
//					while (!queue.isEmpty()) {
//						int id = queue.remove();
//						int row = id / rows;
//						int col = id % cols;
//
//						if (row - 1 >= 0 && grid[row - 1][col] == '1') {
//							queue.add((row - 1) * cols + col);
//							grid[row - 1][col] = '0';
//						}
//						if (row + 1 < rows && grid[row + 1][col] == '1') {
//							queue.add((row + 1) * cols + col);
//							grid[row + 1][col] = '0';
//						}
//						if (col - 1 >= 0 && grid[row][col - 1] == '1') {
//							queue.add(row * cols + col - 1);
//							grid[row + 1][col] = '0';
//						}
//						if (col + 1 < cols && grid[row][col + 1] == '1') {
//							queue.add(row * cols + col + 1);
//							grid[row][col + 1] = '0';
//						}
//					}
//				}
//			}
//		}
//		return island_count;
//	}
//
//}
