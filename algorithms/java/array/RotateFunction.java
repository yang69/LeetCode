package array;

/**
 * Created by Yang on 2017/10/23.
 */
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        int allSum = 0; //数组A所有元素的和
        int len = A.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * A[i]; //计算F(0)
            allSum += A[i]; //计算数组A所有元素的和
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) { //F(k)=F(k-1) + allSum - n*A[len-k];
            F = F + allSum - len * A[i];
            max = Math.max(F, max);
        }
        return max;
    }
}
