package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Yang on 2017/10/9.
 */
public class LargestNumber {
    public String largestNumberUsingComparator(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        if(nums.length == 1) {
            return nums[0] + "";
        }

        String[] numberStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numberStrings[i] = nums[i] + "";
        }

        Arrays.sort(numberStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String o1o2 = o1 + o2;
                String o2o1 = o2 + o1;
                return - o1o2.compareTo(o2o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberStrings.length; i++) {
            sb.append(numberStrings[i]);
        }

        return sb.toString();
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        int n = nums.length;
        // Shell Sort：
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(nums[j], nums[j - h])) {
                        swap(nums, j, j - h);
                    }
                }
            }
            h /= 3;
        }
        // Step 3. 将排序结果从大到小取出
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private boolean greater(int i, int j) {
        String iString = String.valueOf(i);
        String jString = String.valueOf(j);
        if (iString.length() == jString.length()) {
            return iString.compareTo(jString) > 0;
        } else {
            return (iString + jString).compareTo(jString + iString) > 0;
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
