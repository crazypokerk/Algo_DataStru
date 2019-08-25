package leetcode.Array;


/**
 * @Date 2019/8/25 9:55
 */
public class _905_SortArrayByParity {
	public static int[] sortArrayByParity(int[] A) {
		if (A.length <= 1) return A;
		
		int front = 0, back = A.length - 1;
		
		while (front < back) {
			if (A[front] % 2 > A[back] % 2) {
				A[front] = A[front] ^ A[back];
				A[back] = A[front] ^ A[back];
				A[front] = A[front] ^ A[back];
			}
			
			if (A[front] % 2 == 0) front++;
			if (A[back] % 2 == 1) back--;
		}
		
		return A;
	}
	
	public static void main(String[] args) {
		int[] test = {3, 1, 2, 4};
		
		
		int[] ints = sortArrayByParity(test);
		for (int anInt : ints) {
			System.out.println(anInt);
		}
		
	}
}
