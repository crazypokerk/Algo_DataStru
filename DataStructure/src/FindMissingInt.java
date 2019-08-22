/**
 * @Date 2019/5/17 22:19
 */
public class FindMissingInt {
	public static int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; ) {
			if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				//确定nums[i]的值对应的下标不越界，同时排除num[i]本身位置正确或者nums[i]应该放入的位置nums[i]-1原本就是nums[i](如[1,1])
				
				int index = nums[i];//
				nums[i] = nums[index - 1];
				nums[index - 1] = index;
				//换位置之后需要继续判断换过来的值是否在对的位置上，因此不能i++;
			} else {
				i++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
	
	public static void main(String[] args) {
		int[] n = {7, 8, 9, 11, 12};
		System.out.println(firstMissingPositive(n));
	}
}
