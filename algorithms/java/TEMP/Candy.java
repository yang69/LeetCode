package TEMP;

import java.util.Arrays;

/**
 * Created by Yang on 2017/10/9.
 */
public class Candy {
    //        https://leetcode.com/articles/candy/
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < left2right.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                left2right[i] = left2right[i-1] + 1;
            }
        }
        for (int i = right2left.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right2left[i] = right2left[i+1] + 1;
            }
        }
        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(left2right[i], right2left[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();

        System.out.println(candy.candy(new int[]{0}));
    }
}
