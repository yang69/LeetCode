package number;

/**
 * Created by Yang on 2017/10/6.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        // 乘左边的部分
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        // 乘右边的部分
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i+1];
            res[i] *= right;
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

        for (int n : productOfArrayExceptSelf.productExceptSelf(new int[]{1,2,3,4})) {
            System.out.print(n + " ");
        }
        System.out.println(" <---> 24 12 8 6");
    }
}
