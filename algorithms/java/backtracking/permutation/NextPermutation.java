package backtracking.permutation;

/**
 * Created by Yang on 2017/10/5.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]) { //从右边开始向左扫描第一个减小的值
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= i && nums[j] <= nums[i]) { //从i的右边开始寻找刚刚大于num[i]的值
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
