package dynamicProgramming.greedy;

/**
 * Created by Yang on 2017/10/7.
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] lastPosition = new int[10]; // 0-9最后一次出现的位置
        for (int i = 0; i < A.length; i++) {
            lastPosition[A[i] - '0'] = i;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 9; j > A[i] - '0'; j--) {
                if (lastPosition[j] > i) {
                    char temp = A[i];
                    A[i] = A[lastPosition[j]];
                    A[lastPosition[j]] = temp;
                    return Integer.parseInt(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();

        System.out.println(maximumSwap.maximumSwap(7123) + " <---> 7321");
        System.out.println(maximumSwap.maximumSwap(9972) + " <---> 9972");
    }
}
