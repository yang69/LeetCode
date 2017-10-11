package sort;

/**
 * Created by Yang on 2017/10/8.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int numZeros = 0;
        int numOnes = 0;
        for (int n : nums) {
            if (n == 0) {
                numZeros++;
            } else if (n == 1) {
                numOnes++;
            }
        }
        int i = 0;
        while (i < numZeros) {
            nums[i++] = 0;
        }
        while (i < numZeros + numOnes) {
            nums[i++] = 1;
        }
        while (i < nums.length) {
            nums[i++] = 2;
        }
    }

    public void sortColorsUsingSwap(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int first = 0; //0的最后位置
        int last = nums.length - 1; //2的最早位置
        for(int i = 0; i <= last; i++) {
            if(nums[i] == 0) { //将0都放到前部
                while(first <= last && nums[first] == 0) {
                    first++;
                }
                if(i > first) {
                    swap(nums, i--, first);
                } else {
                    i = first - 1; //first是下一个需要检查的位置（循环体结束后i会自增1）
                }
            } else if(nums[i] == 2) { //将2都放到后部
                while(last >= first && nums[last] == 2) {
                    last--;
                }
                if(i < last) {
                    swap(nums, i--, last);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
