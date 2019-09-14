package SORT;

public class _6_QuickSort {
	// 快速排序,a是数组,n表示数组的大小
	public static void sort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	private static void sort(int[] arr, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		//切分
		int pivotIndex = partition(arr, startIndex, endIndex);
		sort(arr, startIndex, pivotIndex - 1);
		sort(arr, pivotIndex + 1, endIndex);
	}
	
	//单边扫描
	private static int partition(int[] a, int p, int r) {
		int pivot = a[r];//取基准值
		// 快慢指针 i ,j
		int i = p;// i 初始化为起始下标
		for (int j = p; j < r; j++) {
			if (a[j] < pivot) {
				if (i == j) {
					i++;
				} else {
					int tmp = a[i];
					a[i++] = a[j];
					a[j] = tmp;
				}
			}
		}
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
		
		System.out.println("i=" + i);
		return i;
	}
	
	//双边扫描
	private static int partitionV2(int[] arr, int startIndex, int endIndex) {
		int left = startIndex;
		int right = endIndex;
		int pivot = arr[startIndex];//取第一个元素为基准值
		
		while (true) {
			//从左往右扫描
			while (arr[left] <= pivot) {
				left++;
				if (left == right) {
					break;
				}
			}
			
			//从右往左扫描
			while (pivot < arr[right]) {
				right--;
				if (left == right) {
					break;
				}
			}
			
			//左右指针相遇
			if (left >= right) {
				break;
			}
			
			//交换左右数据
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		
		//将基准值插入序列
		int temp = arr[startIndex];
		arr[startIndex] = arr[right];
		arr[right] = temp;
		return right;
	}
	
	public static void main(String[] args) {
		int[] a = {552, 5, 291, 9, 6, 213, 39};
		sort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
