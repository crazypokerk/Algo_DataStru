package leetcode.Top;

/**
 * @Date 2019/9/14 10:05
 */
public class FastSort {
	
	public static void quickSort(int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(int[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int pivot = partition(a, left, right);
		sort(a, left, pivot - 1);
		sort(a, pivot + 1, right);
	}
	
	private static int partition(int[] a, int left, int right) {
		
		int pivot = a[right];
		int i = left;
		for (int j = left; j < right; j++) {
			if (a[j] < pivot) {
				if (i == j) {
					++i;
				} else {
					int tmp = a[i];
					a[i++] = a[j];
					a[j] = tmp;
				}
			}
		}
		
		int tmp = a[right];
		a[right] = a[i];
		a[i] = tmp;
		
		return i;
	}
	
	public static void main(String[] args) {
		
		int[] a = {552, 5, 291, 9, 6, 213, 39};
		quickSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
