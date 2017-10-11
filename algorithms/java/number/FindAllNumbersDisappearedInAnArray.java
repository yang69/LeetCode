package number;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class FindAllNumbersDisappearedInAnArray {
    /**
     * 将每个数字指向的地方变为负数
     * 如果那个数依然是正数，说明它没有被指向过，相应的那个数就是缺失的
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || 0 == nums.length) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    /**
     * 将相应元素放到正确的位置上
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbersByReplace(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || 0 == nums.length) {
            return res;
        }
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            } else {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray fandiaa = new FindAllNumbersDisappearedInAnArray();

        System.out.println(fandiaa.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}) + " <---> 5, 6");
    }
}
