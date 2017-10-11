package number;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yang on 2017/10/5.
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            }
            nums[index] = -nums[index];
        }

        return res;
    }

    public List<Integer> findDuplicatesByReplace(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            } else if (nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            } else {
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(nums[j]);
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
        FindAllDuplicatesInAnArray fadiaa = new FindAllDuplicatesInAnArray();

        System.out.println(fadiaa.findDuplicates(new int[]{4,3,2,7,8,2,3,1}) + " <---> 2, 3");
    }
}
