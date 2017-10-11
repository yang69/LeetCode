package number;

/**
 * Created by Yang on 2017/10/5.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //将正数放到nums的相应位置，例如：4放到nums[3]中
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length) i++;
            else if (nums[nums[i]-1] != nums[i]) swap(nums, nums[i] - 1, i);
            else i++;
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
