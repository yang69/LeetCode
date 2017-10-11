package array;

/**
 * Created by Yang on 2017/10/7.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1); //数组反转
        reverse(nums,0,k-1); //前k个元素反转
        reverse(nums,k,nums.length-1); //后n-k个元素反转
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }
}
